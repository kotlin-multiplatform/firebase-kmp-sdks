import org.gradle.api.UnknownDomainObjectException
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

/*

Source set hierarchy that will be created:
  - native
//  - nativeDarwin
//  - nativeDarwin64
    - ios
    - iosSimulatorArm64
    - macosArm64
    - macosX64
    - tvos
    - tvosSimulatorArm64
    - watchosX64
    - watchosSimulatorArm64
//  - nativeDarwin32
//    - watchosArm32
//    - watchosArm64

 */
fun KotlinMultiplatformExtension.nativeSourceSets() {
    with(sourceSets) {
        maybeCreate("nativeMain").apply {
            dependsOn(getByName("commonMain"))
//        }
//
//        maybeCreate("nativeDarwinMain").apply {
//            dependsOn(getByName("commonMain"))
//        }
//
//        maybeCreate("nativeDarwin64Main").apply {
//            dependsOn(getByName("nativeDarwinMain"))

            listOf(
                "iosMain",
                "iosSimulatorArm64Main",
                "macosArm64Main",
                "macosX64Main",
                "tvosMain",
                "tvosSimulatorArm64Main",
//                "watchosX64Main",
//                "watchosSimulatorArm64Main",
//                "watchosArm32Main",
//                "watchosArm64Main"
            ).forEach {
                try {
                    getByName(it).dependsOn(this)
                } catch (exception: UnknownDomainObjectException) {
                    // skip
                }
            }
        }

//        maybeCreate("nativeDarwin32Main").apply {
//            dependsOn(getByName("nativeDarwinMain"))
//
//            listOf(
//                "watchosArm32Main",
//                "watchosArm64Main"
//            ).forEach {
//                try {
//                    getByName(it).dependsOn(this)
//                } catch (exception: UnknownDomainObjectException) {
//
//                }
//            }
//        }

        maybeCreate("nativeTest").apply {
            dependsOn(getByName("commonTest"))
//        }
//
//        maybeCreate("nativeDarwinTest").apply {
//            dependsOn(getByName("commonTest"))
//        }
//
//        maybeCreate("nativeDarwin64Test").apply {
//            dependsOn(getByName("nativeDarwinTest"))

            listOf(
                "iosTest",
                "iosSimulatorArm64Test",
                "macosArm64Test",
                "macosX64Test",
                "tvosTest",
                "tvosSimulatorArm64Test",
//                "watchosX64Test",
//                "watchosSimulatorArm64Test",
//                "watchosArm32Test",
//                "watchosArm64Test"
            ).forEach {
                try {
                    getByName(it).dependsOn(this)
                } catch (exception: UnknownDomainObjectException) {
                    // skip
                }
            }
        }

//        maybeCreate("nativeDarwin32Main").apply {
//            dependsOn(getByName("nativeDarwinTest"))
//
//            listOf(
//                "watchosArm32Test",
//                "watchosArm64Test"
//            ).forEach {
//                try {
//                    getByName(it).dependsOn(this)
//                } catch (exception: UnknownDomainObjectException) {
//
//                }
//            }
//        }
    }
}