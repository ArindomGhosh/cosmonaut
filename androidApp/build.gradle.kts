plugins {
    id("cosmonaut.compose.application")
}

android {
    namespace = "com.arindom.cosmonaut.androidApp"
    defaultConfig {
        applicationId = "com.arindom.cosmonaut.androidApp"
        versionCode = 1
        versionName = "1.0"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}

dependencies {
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.koin.android)
    implementation(libs.koin.compose)
}