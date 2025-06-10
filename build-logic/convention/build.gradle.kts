import org.gradle.internal.impldep.org.bouncycastle.asn1.x500.style.RFC4519Style.l
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
	`kotlin-dsl`
}



java {
	sourceCompatibility = JavaVersion.VERSION_11
	targetCompatibility = JavaVersion.VERSION_11
}

kotlin {
	compilerOptions {
		jvmTarget = JvmTarget.JVM_11
	}
}

dependencies {

	compileOnly(libs.android.gradlePlugin)
	compileOnly(libs.android.tools.common)
	compileOnly(libs.compose.gradlePlugin)
	compileOnly(libs.kotlin.gradlePlugin)
	compileOnly(libs.ksp.gradlePlugin)
	implementation(libs.truth)
}
tasks {
	validatePlugins {
		enableStricterValidation = true
		failOnWarning = true
	}
}
gradlePlugin {
	plugins {
		register("androidApplicationCompose") {
			id = "com.beknur.application.compose"
			implementationClass = "AndroidApplicationComposeConventionPlugin"
		}
		register("androidApplication") {
			id = "com.beknur.application"
			implementationClass = "AndroidApplicationConventionPlugin"
		}

		register("androidLibraryCompose") {
			id = libs.plugins.com.beknur.library.compose.get().pluginId
			implementationClass = "AndroidLibraryComposeConventionPlugin"
		}
		register("androidLibrary") {
			id = "com.beknur.library"
			implementationClass = "AndroidLibraryConventionPlugin"
		}
		register("androidFeature") {
			id = libs.plugins.com.beknur.feature.get().pluginId
			implementationClass = "AndroidFeatureConventionPlugin"
		}
		register("jvmLibrary") {
			id =libs.plugins.com.beknur.jvmLibrary.get().pluginId
			implementationClass = "JvmLibraryConventionPlugin"
		}
		register("sql"){
			id= libs.plugins.com.beknur.sql.get().pluginId
			implementationClass = "SqlDelightConventionPlugin"
		}
		register("koin"){
			id=libs.plugins.com.beknur.koin.get().pluginId
			implementationClass = "KoinConventionPlugin"
		}



	}
}
