plugins {
	alias(libs.plugins.com.beknur.library)
	alias(libs.plugins.com.beknur.koin)
}

android {
	namespace = "com.beknur.common"

}

dependencies {

	implementation(libs.androidx.core.ktx)

}