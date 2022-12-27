package com.arindom.cosmonaut.presentation.route

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
        override val params: List<RoutParam>,
    ) : SpaceXRoute {

        override val routePattern: String
            get() = "$routeName?$queryName={$queryName}/$someName"

        override val routeName: String
            get() = "LaunchDetails"

        companion object Params {
            const val someName: String = "SomeName"
            const val queryName: String = "QueryName"
        }
    }
}

interface Route {
    val routeName: String
    val routePattern: String
        get() = routeName
    val params: List<RoutParam>
        get() = emptyList()

    fun navigate(): String {
        val path = params.fold("") { acc, routParam ->
            acc.plus(
                when (routParam.paramType) {
                    QueryType.REQUIRED -> "/${routParam.paramValue}"
                    QueryType.OPTIONAL -> "?${routParam.paramName}=${routParam.paramValue}"
                }
            )
        }
        return "$routeName$path"
    }
}

enum class QueryType {
    REQUIRED,
    OPTIONAL
}

data class RoutParam(
    val paramType: QueryType,
    val paramName: String,
    val paramValue: Any
)

fun main() {
    SpaceXRoute.LaunchDetails(
        launchId = "123456",
        params = listOf(
            RoutParam(
                paramName = SpaceXRoute.LaunchDetails.Params.someName,
                paramType = QueryType.REQUIRED,
                paramValue = DummyParam(
                    "message",
                    1245
                )
            )
        )
    )
}

data class DummyParam(
    val msg: String,
    val intent: Int
)