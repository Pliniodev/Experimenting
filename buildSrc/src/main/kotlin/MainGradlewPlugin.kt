import com.android.build.gradle.LibraryExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.dsl.KotlinAndroidProjectExtension
import org.jlleitschuh.gradle.ktlint.KtlintExtension
import org.jlleitschuh.gradle.ktlint.reporter.ReporterType

class MainGradlewPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        applyPlugins(target)
        configureAndroid(target)
        configureKtlint(target)
    }

    private fun configureKtlint(project: Project) {
        project.ktlint().apply {
            android.set(true)
            ignoreFailures.set(false)
            reporters {
                reporter(ReporterType.PLAIN)
                reporter(ReporterType.SARIF)
                reporter(ReporterType.CHECKSTYLE)
            }
        }
    }

    private fun configureAndroid(project: Project) {
        project.android().apply {
            compileSdk = ProjectConfig.compileSdk

            defaultConfig {
                minSdk = ProjectConfig.minSdk
                testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
            }

            buildFeatures {
                compose = true
            }

            composeOptions {
                kotlinCompilerExtensionVersion = "1.5.6"
            }
            
            compileOptions {
                sourceCompatibility = JavaVersion.VERSION_17
                targetCompatibility = JavaVersion.VERSION_17
            }
        }
        
        project.kotlin().apply {
            jvmToolchain(17)
        }
    }
    
    private fun Project.android(): LibraryExtension =
        extensions.getByType(LibraryExtension::class.java)
    
    private fun Project.ktlint(): KtlintExtension =
        extensions.getByType(KtlintExtension::class.java)
    
    private fun Project.kotlin(): KotlinAndroidProjectExtension =
        extensions.getByType(KotlinAndroidProjectExtension::class.java)

    private  fun applyPlugins(project: Project) {
        project.apply {
            plugin("org.jlleitschuh.gradle.ktlint")
            plugin("com.android.library")
            plugin("org.jetbrains.kotlin.android")
            plugin("com.google.devtools.ksp") 
        }
    }
}