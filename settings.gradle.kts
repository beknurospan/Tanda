pluginManagement {
	includeBuild("build-logic")
	repositories {
		google {
			content {
				includeGroupByRegex("com\\.android.*")
				includeGroupByRegex("com\\.google.*")
				includeGroupByRegex("androidx.*")
			}
		}
		mavenCentral()
		gradlePluginPortal()
	}
}
dependencyResolutionManagement {
	repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
	repositories {
		google()
		mavenCentral()
	}
}

rootProject.name = "Sausaq"

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
include(":app")

include(":feature:home")
include(":core:domain")
include(":core:database")
include(":core:data")
include(":core:network")
include(":core:datastore")
include(":core:common")
include(":core:designsystem")
include(":core:model")
include(":core:ui")
include(":feature:catalog")
include(":feature:product")
include(":feature:search")
include(":feature:favorites")
include(":feature:cart")
include(":feature:orders")
include(":feature:auth")
include(":feature:profile")
include(":feature:address")
include(":feature:notifications")
include(":feature:payment")
