import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.dependencies
import com.beknur.convention.libs
import com.beknur.convention.configureKotlinJvm

class JvmLibraryConventionPlugin : Plugin<Project> {
	override fun apply(target: Project) {
		with(target) {
			apply(plugin = "org.jetbrains.kotlin.jvm")

			configureKotlinJvm()
			dependencies {
				"testImplementation"(libs.findLibrary("kotlin.test").get())
			}
		}
	}
}
