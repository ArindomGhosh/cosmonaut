plugins {
    `kotlin-dsl`
}

group = "com.arindom.cosmonaut.buildlogic"

dependencies {
    implementation(libs.android.gradlePlugin)
    implementation(libs.kotlin.gradlePlugin)
}