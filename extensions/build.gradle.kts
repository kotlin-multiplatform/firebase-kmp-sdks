plugins {
    id("com.android.library")
    kotlin("multiplatform")
}

android {
    multiplatformLibrary()

    namespace = "suntrix.kmp.extensions"
}

kotlin {
    android()

    iosWithArm64()
    macosArm64()
    macosX64()
    tvos()
    tvosSimulatorArm64()
//    watchos()
//    watchosSimulatorArm64()

    nativeSourceSets()
}