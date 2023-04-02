package suntrix.kmp.xcframework

import org.jetbrains.kotlin.gradle.plugin.mpp.DefaultCInteropSettings
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget
import org.jetbrains.kotlin.gradle.plugin.mpp.NativeBinary
import org.jetbrains.kotlin.konan.target.Family
import org.jetbrains.kotlin.konan.target.KonanTarget
import java.io.File

/**
 * Created by Sebastian Owodzin on 02/04/2023
 */
private val xcFrameworkInfoParser = XCFrameworkInfoParser()

fun File.carthageBuildDir() = resolve("Carthage/Build")

fun File.carthageXcFrameworkPath(name: String) = carthageBuildDir().resolve("$name.xcframework")

fun KonanTarget.carthageXcFrameworksPaths(projectDir: File, names: List<String>) =
    names.mapNotNull { name ->
        val xcFrameworkPath = projectDir.carthageXcFrameworkPath(name)
        val libraryDefinitions = xcFrameworkInfoParser.parse(xcFrameworkPath)

        libraryDefinitions.select(
            this,
            if (family == Family.WATCHOS) {
                when (this) {
                    is KonanTarget.WATCHOS_ARM32,
                    is KonanTarget.WATCHOS_ARM64 -> KonanTarget.IOS_ARM64
                    is KonanTarget.WATCHOS_X64 -> KonanTarget.IOS_X64
                    is KonanTarget.WATCHOS_SIMULATOR_ARM64 -> KonanTarget.IOS_SIMULATOR_ARM64
                    else -> null
                }
            } else null
        )?.let { xcFrameworkPath.resolve(it.libraryIdentifier) }
    }

fun NativeBinary.linkCarthageFrameworks(projectDir: File, names: List<String>) {
    linkerOpts(target.konanTarget.carthageXcFrameworksPaths(projectDir, names).map { "-F$it" })
}

fun DefaultCInteropSettings.configureCarthageFrameworks(target: KotlinNativeTarget, projectDir: File, names: List<String>) {
    compilerOpts(
        target.konanTarget.carthageXcFrameworksPaths(projectDir, names).map { "-F$it" }
    )
}