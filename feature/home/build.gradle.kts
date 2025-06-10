plugins {
	alias(libs.plugins.com.beknur.library)
	alias(libs.plugins.com.beknur.sql)


}

android {
	namespace="com.beknur.home"
}

dependencies {

	implementation(libs.androidx.core.ktx)
	implementation(libs.androidx.appcompat)

}