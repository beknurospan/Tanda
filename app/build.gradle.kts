
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
	alias(libs.plugins.com.beknur.application)
	alias(libs.plugins.com.beknur.application.compose)
	alias(libs.plugins.kotlin.android)
	alias(libs.plugins.kotlin.compose)
	alias(libs.plugins.kotlin.serialization)
	alias(libs.plugins.com.beknur.koin)
}

android {
	namespace = "com.beknur.sausaq"
	compileSdk = 36

	defaultConfig {
		applicationId = "com.beknur.sausaq"
		minSdk = 28
		targetSdk = 36
		versionCode = 1
		versionName = "1.0"

		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
	}


	buildTypes {
		release {
			isMinifyEnabled = true
			isShrinkResources = true
			proguardFiles(
				getDefaultProguardFile("proguard-android-optimize.txt"),
				"proguard-rules.pro"
			)
		}
	}
	compileOptions {
		sourceCompatibility = JavaVersion.VERSION_11
		targetCompatibility = JavaVersion.VERSION_11
	}
	buildFeatures {
		compose = true
	}
}
kotlin {
	compilerOptions {
		jvmTarget.set(JvmTarget.JVM_11)
	}
}
dependencies {
	implementation(libs.navigation3.ui)
	implementation(libs.navigation3.runtime)
	implementation(libs.lifecycle.viewmodel.navigation3)

	implementation(libs.serialization.core)
	implementation(project(":core:designsystem"))

	implementation(libs.androidx.core.ktx)
	implementation(libs.androidx.lifecycle.runtime.ktx)
	implementation(libs.androidx.activity.compose)
	implementation(platform(libs.androidx.compose.bom))
	implementation(libs.androidx.ui)
	implementation(libs.androidx.ui.graphics)
	implementation(libs.androidx.ui.tooling.preview)
	implementation(libs.androidx.material3)
	testImplementation(libs.junit)
	androidTestImplementation(libs.androidx.junit)
	androidTestImplementation(libs.androidx.espresso.core)
	androidTestImplementation(platform(libs.androidx.compose.bom))
	androidTestImplementation(libs.androidx.ui.test.junit4)
	debugImplementation(libs.androidx.ui.tooling)
	debugImplementation(libs.androidx.ui.test.manifest)
	implementation(libs.androidx.material.icons.extended)
	implementation(project(":feature:catalog"))
	implementation(project(":feature:product"))
	implementation(project(":feature:favorites"))
	implementation(project(":feature:cart"))
	implementation(project(":feature:auth"))
	implementation(project(":feature:profile"))
	implementation(project(":feature:productdetail"))
	implementation(project(":feature:address"))
	implementation(project(":feature:cards"))
	implementation(project(":feature:payment"))
	implementation(project(":feature:orders"))
	implementation(project(":feature:notifications"))
	implementation(project(":feature:home"))
	implementation(project(":feature:about_app"))
	implementation(project(":feature:support"))
	implementation(project(":feature:search"))
	implementation(project(":feature:searchmap"))
	implementation(project(":core:navigation"))
	implementation(project(":core:domain"))
	implementation(project(":core:database"))
	implementation(project(":core:common"))
	implementation(project(":core:data"))
	implementation(project(":core:network"))
	implementation(project(":core:datastore"))

}


