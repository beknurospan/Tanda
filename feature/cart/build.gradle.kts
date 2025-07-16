plugins {
	alias(libs.plugins.com.beknur.library.compose)
	alias(libs.plugins.com.beknur.feature)
}

android {
	namespace = "com.beknur.cart"

}

dependencies {
	implementation(libs.coil.compose.v250)
	implementation(libs.androidx.core.ktx)
	implementation(libs.androidx.appcompat)
	implementation(libs.material)
	testImplementation(libs.junit)
	androidTestImplementation(libs.androidx.junit)
	androidTestImplementation(libs.androidx.espresso.core)
}