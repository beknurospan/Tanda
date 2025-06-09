import com.android.build.gradle.LibraryExtension
import com.beknur.convention.configureKotlinAndroid
import com.beknur.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class AndroidLibraryConventionPlugin : Plugin<Project> {
	override fun apply(target: Project) {
		with(target) {
			apply(plugin = "com.android.library")
			apply(plugin = "org.jetbrains.kotlin.android")

			extensions.configure<LibraryExtension> {
				configureKotlinAndroid(this)
				defaultConfig.targetSdk = 35

				resourcePrefix =
					path.split("""\W""".toRegex()).drop(1).distinct().joinToString(separator = "_")
						.lowercase() + "_"
			}

			dependencies {
				"androidTestImplementation"(libs.findLibrary("kotlin.test").get())
				"testImplementation"(libs.findLibrary("kotlin.test").get())

				"implementation"(libs.findLibrary("androidx.tracing.ktx").get())
			}
		}
	}
}
