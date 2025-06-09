import org.gradle.api.Plugin
import org.gradle.api.Project
import com.beknur.convention.libs
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.dependencies

class SqlDelightConventionPlugin : Plugin<Project> {
	override fun apply(target: Project) = with(target) {
		apply(plugin = "com.squareup.sqldelight")

		dependencies {
			"implementation"(libs.findLibrary("sqldelight.runtime").get())
		}


		pluginManager.withPlugin("org.jetbrains.kotlin.jvm") {
			dependencies {
				"implementation"(libs.findLibrary("sqldelight.sqlite.driver").get())
			}
		}

		pluginManager.withPlugin("com.android.base") {
			dependencies {
				"implementation"(libs.findLibrary("sqldelight.android.driver").get())
			}
		}
	}
}
