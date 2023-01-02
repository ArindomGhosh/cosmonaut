pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
    includeBuild("build-logic")
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

enableFeaturePreview("VERSION_CATALOGS")
rootProject.name = "Cosmonaut"
include(":androidApp")
include(":kmm:spacex")
include(":kmm:core:route")
include(":kmm:core:common")
include(":kmm:core:network")
include(":kmm:shared")
include(":kmm:features:spaceXLaunches")
