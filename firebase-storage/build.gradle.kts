import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget
import suntrix.kmp.xcframework.carthageBuildDir
import suntrix.kmp.xcframework.setupCInteropWithXCFrameworks

plugins {
    id("com.android.library")
    kotlin("multiplatform")
}

android {
    multiplatformLibrary()

    namespace = "suntrix.kmp.firebase.storage"
}

kotlin {
    android()

    fun configureNativeTarget(): KotlinNativeTarget.() -> Unit = {
        val frameworks = firebaseCoreFrameworks().plus(
            listOf(
                "FirebaseStorage"
            )
        )

        setupCInteropWithXCFrameworks("FirebaseStorage", frameworks, carthageBuildDir())
    }

    iosWithSimulatorArm64(configure = configureNativeTarget())
    macosArm64(configure = configureNativeTarget())
    macosX64(configure = configureNativeTarget())
    tvosWithSimulatorArm64(configure = configureNativeTarget())
    watchosWithSimulatorArm64(configure = configureNativeTarget())

    nativeSourceSets()

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(project(":extensions"))
                api(project(":firebase-core"))
            }
        }

        val androidMain by getting {
            dependencies {
                implementation("com.google.firebase:firebase-storage")
            }
        }
    }
}