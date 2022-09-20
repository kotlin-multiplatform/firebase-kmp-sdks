import com.android.build.gradle.LibraryExtension
import org.gradle.api.Project
import org.gradle.api.plugins.ExtensionAware
import org.gradle.api.plugins.ExtensionContainer
import org.gradle.kotlin.dsl.get

/**
 * Created by Sebastian Owodzin on 23/06/2020
 */
fun Project.androidLibrary(
    extensionBlock: (ExtensionContainer.() -> Unit)? = null
) {
    with((this as ExtensionAware).extensions) {
        configure<LibraryExtension>("android") {
            androidLibrary()
        }

        extensionBlock?.invoke(this)
    }
}

fun LibraryExtension.androidLibrary() {
    compileSdk = Versions.TARGET_ANDROID_SDK

    defaultConfig {
        minSdk = Versions.MIN_ANDROID_SDK
        targetSdk = Versions.TARGET_ANDROID_SDK

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        testInstrumentationRunnerArguments["clearPackageData"] = "true"

        consumerProguardFiles("proguard-rules.pro")
    }

    testOptions {
        animationsDisabled = true
        execution = "ANDROIDX_TEST_ORCHESTRATOR"

        unitTests {
            isIncludeAndroidResources = true
            isReturnDefaultValues = true

            all {
                it.testLogging {
                    events("passed", "skipped", "failed")
                }
            }
        }
    }
}

fun Project.multiplatformLibrary(
    extensionBlock: (ExtensionContainer.() -> Unit)? = null
) {
    with((this as ExtensionAware).extensions) {
        configure<LibraryExtension>("android") {
            multiplatformLibrary()
        }

        extensionBlock?.invoke(this)
    }
}

fun LibraryExtension.multiplatformLibrary() {
    androidLibrary()

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
}