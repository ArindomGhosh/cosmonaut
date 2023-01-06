import com.android.build.api.dsl.ApplicationExtension
import com.arindom.cosmonaut.project.extentions.configureCompose
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.configure

class CosmonautComposeApplication : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply<CosmonautApplicationConvention>()
            }
            extensions.configure<ApplicationExtension> {
                configureCompose(this)
            }
        }
    }
}