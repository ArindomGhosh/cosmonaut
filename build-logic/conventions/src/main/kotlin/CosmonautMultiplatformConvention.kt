import com.android.build.gradle.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.get

class CosmonautMultiplatformConvention:Plugin<Project> {
    override fun apply(target: Project) {
       with(target){
           pluginManager.apply{
               apply("com.android.library")
               apply("org.jetbrains.kotlin.multiplatform")
           }
           extensions.configure<LibraryExtension>() {
               sourceSets["main"].manifest.srcFile("./src/androidMain/AndroidManifest.xml")
               compileSdk = 33//libs.findVersion("compileSdk").get().toString().toInt()
               defaultConfig {
                   minSdk = 21//libs.findVersion("minSdk").get().toInt()
                   targetSdk = 33//libs.findVersion("targetSdk").get().toInt()
               }
           }
       }
    }
}