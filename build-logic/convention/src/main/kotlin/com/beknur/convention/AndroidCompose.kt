package com.beknur.convention

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.api.provider.Provider
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.compose.compiler.gradle.ComposeCompilerGradlePluginExtension


internal fun Project.configureAndroidCompose(
	commonExtension: CommonExtension<*, *, *, *, *, *>,
) {
	commonExtension.apply {
		buildFeatures {
			compose = true
		}

		val libs=extensions.getByType<VersionCatalogsExtension>().named("libs")
		dependencies {
			val bom = libs.findLibrary("androidx-compose-bom").get()
			"implementation"(platform(bom))
			"androidTestImplementation"(platform(bom))
			"implementation"(libs.findLibrary("androidx-compose-ui-tooling-preview").get())
			"debugImplementation"(libs.findLibrary("androidx-compose-ui-tooling").get())
		}

		testOptions {
			unitTests {
				// For Robolectric
				isIncludeAndroidResources = true
			}
		}

	}


}
