import com.android.build.gradle.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.get
import org.gradle.kotlin.dsl.getByType

class CosmonautMultiplatformConvention : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
            pluginManager.apply {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.multiplatform")
            }
            extensions.configure<LibraryExtension>() {
                sourceSets["main"].manifest.srcFile("./src/androidMain/AndroidManifest.xml")
                compileSdk = libs.findVersion("compileSdk").get().toString().toInt()
                defaultConfig {
                    minSdk = libs.findVersion("minSdk").get().toString().toInt()
                    targetSdk = libs.findVersion("targetSdk").get().toString().toInt()
                }
            }
        }
    }
}