import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget
import suntrix.kmp.xcframework.carthageBuildDir
import suntrix.kmp.xcframework.setupCInteropWithXCFrameworks

plugins {
    id("com.android.library")
    kotlin("multiplatform")
}

android {
    multiplatformLibrary()

    namespace = "suntrix.kmp.firebase.core"
}

kotlin {
    android()

    fun configureNativeTarget(): KotlinNativeTarget.() -> Unit = {
        val frameworks = firebaseCoreFrameworks()

        setupCInteropWithXCFrameworks("FirebaseCore", frameworks, carthageBuildDir())
    }

    iosWithSimulatorArm64(configure = configureNativeTarget())
    macosArm64(configure = configureNativeTarget())
    macosX64(configure = configureNativeTarget())
    tvosWithSimulatorArm64(configure = configureNativeTarget())
    watchosWithSimulatorArm64(configure = configureNativeTarget())

    nativeSourceSets()

    sourceSets {
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }

        val androidMain by getting {
            dependencies {
                implementation("androidx.startup:startup-runtime:${Versions.Androidx.STARTUP}")
                implementation("com.google.firebase:firebase-common")
            }
        }

        val androidInstrumentedTest by getting {
            dependsOn(commonTest)
        }
    }
}