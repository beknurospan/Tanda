plugins {
	alias(libs.plugins.com.beknur.library)
	alias(libs.plugins.kotlin.serialization)
	alias(libs.plugins.com.beknur.koin)
}

android {
	namespace = "com.beknur.network"

}

dependencies {
	implementation(libs.ktor.client.core)
	implementation(libs.ktor.client.cio)
	implementation(libs.ktor.client.content.negotiation)
	implementation(libs.ktor.serialization.kotlinx.json)
	implementation(libs.kotlinx.serialization.json)


	implementation(libs.serialization.core)
	implementation(libs.androidx.core.ktx)
	implementation(libs.androidx.appcompat)
	implementation(libs.material)
	testImplementation(libs.junit)
	androidTestImplementation(libs.androidx.junit)
	androidTestImplementation(libs.androidx.espresso.core)
}