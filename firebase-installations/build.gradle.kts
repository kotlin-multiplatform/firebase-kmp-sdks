plugins {
    id("com.android.library")
    kotlin("multiplatform")
}

android {
    multiplatformLibrary()
}

kotlin {
    android()

    fun configureNativeTarget(): org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget.() -> Unit = {
        val frameworks = listOf(
            "FirebaseInstallations"
        )

        compilations.getByName("main") {
            cinterops.create("FirebaseInstallations") {
                configureCarthageFrameworks(rootDir, frameworks)

//                extraOpts = listOf("-compiler-option", "-DNS_FORMAT_ARGUMENT(A)=", "-verbose")
            }
        }

        binaries.all {
            linkCarthageFrameworks(rootDir, frameworks)
        }
    }

    ios(configure = configureNativeTarget())
    iosSimulatorArm64(configure = configureNativeTarget())
    macosArm64(configure = configureNativeTarget())
    macosX64(configure = configureNativeTarget())
    tvos(configure = configureNativeTarget())
    tvosSimulatorArm64(configure = configureNativeTarget())
//    watchos(configure = configureNativeTarget())
//    watchosSimulatorArm64(configure = configureNativeTarget())

    nativeSourceSets()

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(project(":extensions"))
                implementation(project(":firebase-core"))
            }
        }

        val androidMain by getting {
            dependencies {
                implementation("com.google.firebase:firebase-installations-ktx")
            }
        }
    }
}