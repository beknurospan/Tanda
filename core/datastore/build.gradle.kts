plugins {
	alias(libs.plugins.com.beknur.library)
	alias(libs.plugins.com.beknur.koin)
	alias(libs.plugins.kotlin.serialization)
}

android {
	namespace = "com.beknur.datastore"


}

dependencies {
	api(project(":core:domain"))
	implementation(libs.kotlinx.serialization.protobuf)
	implementation(libs.androidx.datastore.v117)
	implementation(libs.androidx.datastore.preferences)
	implementation(libs.androidx.core.ktx)
	implementation(libs.androidx.appcompat)
	implementation(libs.material)
	testImplementation(libs.junit)
	androidTestImplementation(libs.androidx.junit)
	androidTestImplementation(libs.androidx.espresso.core)
}