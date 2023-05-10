import org.jetbrains.kotlin.gradle.dsl.KotlinTargetContainerWithNativeShortcuts
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

/**
 * Created by Sebastian Owodzin on 12/04/2023
 */
fun KotlinTargetContainerWithNativeShortcuts.iosWithSimulatorArm64(
    name: String = "ios",
    configure: KotlinNativeTarget.() -> Unit = {}
) {
    ios(name, configure)
    iosSimulatorArm64(name, configure)
}

//fun KotlinTargetContainerWithNativeShortcuts.macosWithArm64(
//    name: String = "macos",
//    configure: KotlinNativeTarget.() -> Unit = {}
//) {
//    macosArm64(name, configure)
//    macosX64(name, configure)
//}

fun KotlinTargetContainerWithNativeShortcuts.tvosWithSimulatorArm64(
    name: String = "tvos",
    configure: KotlinNativeTarget.() -> Unit = {}
) {
    tvos(name, configure)
    tvosSimulatorArm64(name, configure)
}

fun KotlinTargetContainerWithNativeShortcuts.watchosWithSimulatorArm64(
    name: String = "watchos",
    configure: KotlinNativeTarget.() -> Unit = {}
) {
//    watchos(name, configure)
//    watchosSimulatorArm64(name, configure)
}