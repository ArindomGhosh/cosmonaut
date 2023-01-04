package com.arindom.cosmonaut.core.data.presentation

interface Route {
    val routeName: String
}

sealed interface CosmonautRoute : Route {

    object LoginRoute : CosmonautRoute {
        override val routeName: String
            get() = "LoginRoute"
    }

    object OnboardingRoute : CosmonautRoute {
        override val routeName: String
            get() = "OnboardingRoute"
    }

    object SpaceXFeatureRoute : CosmonautRoute {
        override val routeName: String
            get() = "SpaceXRoute"
    }
}

sealed interface SpaceXRoute : Route {

    object Launches : SpaceXRoute {
        override val routeName: String
            get() = "Launches"
    }


    data class LaunchDetails(
        val launchId: String,
    ) : SpaceXRoute {
        override val routeName: String
            get() = "LaunchDetails"
    }
}
