plugins {
    id("com.android.library")
    kotlin("multiplatform")
}

android {
    multiplatformLibrary()
}

kotlin {
    android()

    ios()
    iosSimulatorArm64()
    macosArm64()
    macosX64()
    tvos()
    tvosSimulatorArm64()
//    watchos()
//    watchosSimulatorArm64()

    nativeSourceSets()
}