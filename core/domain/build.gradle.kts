plugins {
	alias(libs.plugins.com.beknur.library)
	alias(libs.plugins.com.beknur.koin)
	alias(libs.plugins.kotlin.serialization)



}

android {
	namespace = "com.beknur.domain"
}

dependencies {
	implementation(libs.kotlinx.serialization.protobuf)
}