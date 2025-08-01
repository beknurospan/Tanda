plugins {
	alias(libs.plugins.com.beknur.library)
	alias(libs.plugins.com.beknur.koin)

}

android {
	namespace = "com.beknur.data"
}

dependencies {
	api(project(":core:database"))
	api(project(":core:network"))
	api(project(":core:domain"))
	api(project(":core:common"))

	implementation(libs.androidx.core.ktx)
	implementation(libs.androidx.appcompat)
	implementation(libs.material)
	testImplementation(libs.junit)
	androidTestImplementation(libs.androidx.junit)
	androidTestImplementation(libs.androidx.espresso.core)
}