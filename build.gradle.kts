// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
	alias(libs.plugins.android.application) apply false
	alias(libs.plugins.kotlin.android) apply false
	alias(libs.plugins.kotlin.compose) apply false
	alias(libs.plugins.android.library) apply false
	alias(libs.plugins.kotlin.serialization) apply false
	alias(libs.plugins.sqlDelight) apply false
	alias(libs.plugins.detekt) apply false
}
tasks.register("detektAll") {
	group = "verification"
	description = "Runs detekt on all subprojects"

	dependsOn(
		subprojects.mapNotNull { subproject ->
			subproject.tasks.findByName("detekt")
		}
	)
}
