import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class CosmonautComposeConvention : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
            pluginManager.apply {

            }
            dependencies {
//                "implementation"(platform(libs.findLibrary("androidx.compose.bom").get()))
//                "implementation"(libs.findLibrary("bundles.compose").get())

            }
        }
    }

}