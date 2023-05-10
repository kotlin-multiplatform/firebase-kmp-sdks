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

    iosWithSimulatorArm64()
    macosArm64()
    macosX64()
    tvosWithSimulatorArm64()
    watchosWithSimulatorArm64()

    nativeSourceSets()
}