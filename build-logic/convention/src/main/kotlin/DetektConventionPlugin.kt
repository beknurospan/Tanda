import io.gitlab.arturbosch.detekt.Detekt
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.withType
import com.beknur.convention.libs

class DetektConventionPlugin : Plugin<Project> {
	override fun apply(target: Project) = with(target) {
		pluginManager.apply("io.gitlab.arturbosch.detekt")

		tasks.withType<Detekt>().configureEach {

			buildUponDefaultConfig = true
			parallel = true
			reports {
				xml.required.set(false)
				html.required.set(true)
				txt.required.set(false)
				sarif.required.set(false)
			}
		}

		dependencies {
			"detektPlugins"(libs.findLibrary("detekt.formatting").get())
		}
	}
}