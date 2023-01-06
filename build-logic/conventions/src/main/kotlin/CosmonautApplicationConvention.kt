import com.android.build.api.dsl.ApplicationExtension
import com.arindom.cosmonaut.project.extentions.configureCompose
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.*

class CosmonautApplicationConvention:Plugin<Project> {
    override fun apply(target: Project) {
        with(target){
            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
            pluginManager.apply{
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
            }

            extensions.configure<ApplicationExtension>{
                compileSdk = libs.findVersion("compileSdk").get().toString().toInt()
                defaultConfig {
                    minSdk = libs.findVersion("minSdk").get().toString().toInt()
                    targetSdk = libs.findVersion("targetSdk").get().toString().toInt()
                }
                configureCompose(this)
            }

            dependencies {
                "implementation"(project(":kmm:shared"))
            }
        }
    }
}