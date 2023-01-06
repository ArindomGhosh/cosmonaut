package com.arindom.cosmonaut.project.extentions

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

fun Project.configureCompose(
    commonExtention:CommonExtension<*,*,*,*>
){
    val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
    commonExtention.apply {
        buildFeatures {
            compose = true
        }

        composeOptions {
            kotlinCompilerExtensionVersion =
                libs.findVersion("kotlinCompilerExtensionVersion").get().toString()
        }
    }
    dependencies {
        "implementation"(platform(libs.findLibrary("androidx.compose.bom").get()))
        "implementation"(libs.findBundle("compose").get())
        "implementation"(libs.findLibrary("androidx.activity.compose").get())

    }
}