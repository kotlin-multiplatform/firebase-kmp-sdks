plugins {
    id("com.android.library")
    kotlin("multiplatform")
}

android {
    multiplatformLibrary()
}

//dependencies {
//    androidTestImplementation("androidx.test.ext:junit:1.1.3")
//    androidTestImplementation("androidx.test.ext:junit-ktx:1.1.3")
//}

kotlin {
    android()

    fun configureNativeTarget(): org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget.() -> Unit = {
//        binaries {
//            getTest("DEBUG").apply {
//                linkCarthageFrameworks()
////                linkerOpts(nativeFrameworkPaths.map { "-F$it" })
//                linkerOpts("-ObjC")
//            }
//        }

        val frameworks = listOf(
//            "FirebaseAnalytics",
            "FirebaseCore",
            "FirebaseCoreDiagnostics",
//            "FirebaseInstallations",
//            "GoogleAppMeasurement",
//            "GoogleAppMeasurementIdentitySupport",
            "GoogleDataTransport",
            "GoogleUtilities",
            "nanopb",
            "PromisesObjC"
        )

        compilations.getByName("main") {
//            carthageCinterops.create("FirebaseCore")
            cinterops.create("FirebaseCore") {
                configureCarthageFrameworks(rootDir, frameworks)

//                extraOpts = listOf("-compiler-option", "-DNS_FORMAT_ARGUMENT(A)=", "-verbose")
            }

            cinterops.create("FirebaseCoreDiagnostics") {
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
        all {
            languageSettings.apply {

            }
        }

        val commonMain by getting {
            dependencies {
//                api("org.jetbrains.kotlinx:kotlinx-serialization-core:${Versions.Kotlinx.SERIALIZATION}")
//                api("org.jetbrains.kotlinx:kotlinx-serialization-properties:${Versions.Kotlinx.SERIALIZATION}")
            }
        }
        val commonTest by getting {
            dependencies {
//                implementation(kotlin("test-common"))
//                implementation(kotlin("test-annotations-common"))
            }
        }

        val androidMain by getting {
            dependencies {
                implementation("androidx.startup:startup-runtime:${Versions.Androidx.STARTUP}")
                implementation("com.google.firebase:firebase-common-ktx")
            }
        }
        val androidTest by getting {
            dependencies {
//                implementation(kotlin("test-junit"))
//                implementation("junit:junit:${Versions.JUNIT}")
            }
        }
    }
}