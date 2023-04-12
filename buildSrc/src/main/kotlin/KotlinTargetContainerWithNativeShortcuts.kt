import org.jetbrains.kotlin.gradle.dsl.KotlinTargetContainerWithNativeShortcuts
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

/**
 * Created by Sebastian Owodzin on 12/04/2023
 */
fun KotlinTargetContainerWithNativeShortcuts.iosWithArm64(
    name: String = "ios",
    configure: KotlinNativeTarget.() -> Unit
) {
    ios(name, configure)
    iosSimulatorArm64(name, configure)
}