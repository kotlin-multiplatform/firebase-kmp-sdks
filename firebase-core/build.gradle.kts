import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget
import suntrix.kmp.xcframework.configureCarthageFrameworks
import suntrix.kmp.xcframework.linkCarthageFrameworks

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

        compilations.getByName("main") {
            cinterops.create("FirebaseCore") {
                configureCarthageFrameworks(target, rootDir, frameworks)
                extraOpts = listOf("-compiler-option", "-DNS_FORMAT_ARGUMENT(A)=", "-verbose")
            }
        }

        binaries.all {
            linkCarthageFrameworks(rootDir, frameworks)
        }
    }

    iosWithArm64(configure = configureNativeTarget())
    macosArm64(configure = configureNativeTarget())
    macosX64(configure = configureNativeTarget())
    tvos(configure = configureNativeTarget())
    tvosSimulatorArm64(configure = configureNativeTarget())
//    watchos(configure = configureNativeTarget())
//    watchosSimulatorArm64(configure = configureNativeTarget())

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
                implementation("com.google.firebase:firebase-common-ktx")
            }
        }

        val androidInstrumentedTest by getting {
            dependsOn(commonTest)
        }
    }
}