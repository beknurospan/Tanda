import org.gradle.api.Plugin
import org.gradle.api.Project
import com.beknur.convention.libs
import org.gradle.kotlin.dsl.dependencies

class KoinConventionPlugin : Plugin<Project> {
	override fun apply(target: Project) = with(target) {
		pluginManager.withPlugin("org.jetbrains.kotlin.jvm") {
			dependencies {
				"implementation"(libs.findLibrary("koin.core").get())
			}
		}

		pluginManager.withPlugin("com.android.base") {
			dependencies {
				"implementation"(libs.findLibrary("koin.android").get())
			}

			pluginManager.withPlugin("org.jetbrains.kotlin.plugin.compose") {
				dependencies {
					"implementation"(libs.findLibrary("koin.compose").get())
				}
			}
		}
	}
}
