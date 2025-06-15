plugins {
	alias(libs.plugins.com.beknur.library.compose)
	alias(libs.plugins.com.beknur.feature)




}

android {
	namespace="com.beknur.home"
}

dependencies {

	implementation(libs.androidx.core.ktx)
	implementation(libs.androidx.appcompat)

}