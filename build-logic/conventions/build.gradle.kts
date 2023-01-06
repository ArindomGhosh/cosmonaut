plugins {
    `kotlin-dsl`
}

group = "com.arindom.cosmonaut.buildlogic"

dependencies {
    implementation(libs.android.gradlePlugin)
    implementation(libs.kotlin.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("CosmonautCommonConvention") {
            id = "cosmonaut.kmm.common"
            implementationClass = "CosmonautCommonConvention"
        }

        register("CosmonautMultiplatformConvention"){
            id = "cosmonaut.kmm.multiplatform"
            implementationClass = "CosmonautMultiplatformConvention"
        }
    }
}