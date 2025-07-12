plugins {
	alias(libs.plugins.com.beknur.library)
	alias(libs.plugins.com.beknur.library.compose)
}

android {
	namespace = "com.beknur.about_app"

}

dependencies {

	implementation(libs.androidx.core.ktx)
	implementation(libs.androidx.appcompat)
	implementation(libs.material)
	testImplementation(libs.junit)
	androidTestImplementation(libs.androidx.junit)
	androidTestImplementation(libs.androidx.espresso.core)
}