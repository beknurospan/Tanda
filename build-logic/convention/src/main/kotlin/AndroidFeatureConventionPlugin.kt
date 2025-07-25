import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.dependencies
import com.beknur.convention.libs

class AndroidFeatureConventionPlugin : Plugin<Project> {
	override fun apply(target: Project) {
		with(target) {
			apply(plugin = "org.jetbrains.kotlin.plugin.serialization")
			apply(plugin = "com.beknur.koin")
			apply(plugin = "com.beknur.library")

			dependencies {
				"implementation"(libs.findLibrary("androidx.lifecycle.runtimeCompose").get())
				"implementation"(libs.findLibrary("androidx.lifecycle.viewModelCompose").get())

				"implementation"(libs.findLibrary("androidx.tracing.ktx").get())
				"implementation"(libs.findLibrary("kotlinx.serialization.json").get())
				"implementation"(project(":core:designsystem"))
				"implementation"(project(":core:domain"))
				"implementation"(project(":core:navigation"))
				"implementation"(libs.findLibrary("navigation3.ui").get())
				"implementation"(libs.findLibrary("navigation3.runtime").get())
				"implementation"(libs.findLibrary("lifecycle.viewmodel.navigation3").get())

				"implementation"(libs.findLibrary("serialization.core").get())

				"testImplementation"(libs.findLibrary("androidx.navigation.testing").get())
				"androidTestImplementation"(
					libs.findLibrary("androidx.lifecycle.runtimeTesting").get(),
				)
			}
		}
	}
}
