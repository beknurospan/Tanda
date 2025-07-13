plugins {
	alias(libs.plugins.com.beknur.library)
	alias(libs.plugins.com.beknur.koin)
	alias(libs.plugins.kotlin.serialization)

}

android {
	namespace = "com.beknur.navigation"
}

dependencies {
	implementation(libs.navigation3.ui)
	implementation(libs.navigation3.runtime)
	implementation(libs.lifecycle.viewmodel.navigation3)

	implementation(libs.serialization.core)

	implementation(libs.androidx.core.ktx)
	implementation(libs.androidx.appcompat)
	implementation(libs.material)
	testImplementation(libs.junit)
	androidTestImplementation(libs.androidx.junit)
	androidTestImplementation(libs.androidx.espresso.core)
}