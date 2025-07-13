import com.android.build.api.dsl.ApplicationExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.configure
import com.beknur.convention.configureKotlinAndroid

class AndroidApplicationConventionPlugin : Plugin<Project> {
	override fun apply(target: Project) {
		with(target) {
			apply(plugin = "com.android.application")
			apply(plugin = "org.jetbrains.kotlin.android")
			apply(plugin = "com.beknur.detekt")


			extensions.configure<ApplicationExtension> {
				configureKotlinAndroid(this)
				defaultConfig.targetSdk = 36

			}


		}
	}
}