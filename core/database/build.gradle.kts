
plugins {
	alias(libs.plugins.com.beknur.library)
	alias(libs.plugins.kotlin.serialization)
	alias(libs.plugins.com.beknur.koin)
	alias(libs.plugins.ksp)
}

android {
	namespace = "com.beknur.database"
}

dependencies {
	implementation(libs.room.runtime)
	implementation(libs.room.ktx)
	ksp(libs.room.compiler)
}




