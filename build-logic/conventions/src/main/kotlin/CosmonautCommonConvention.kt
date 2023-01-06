import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.*
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class CosmonautCommonConvention : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply<CosmonautMultiplatformConvention>()
            }

            extensions.configure<KotlinMultiplatformExtension>() {
                android()

                iosX64()
                iosArm64()
                iosSimulatorArm64()

            }
        }
    }
}

