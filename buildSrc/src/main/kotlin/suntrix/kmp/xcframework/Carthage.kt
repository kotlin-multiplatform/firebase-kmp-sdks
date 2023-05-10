package suntrix.kmp.xcframework

import org.jetbrains.kotlin.gradle.plugin.CInteropSettings
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget
import org.jetbrains.kotlin.gradle.plugin.mpp.NativeBinary
import org.jetbrains.kotlin.konan.target.KonanTarget
import java.io.File

/**
 * Created by Sebastian Owodzin on 02/04/2023
 */
fun File.carthageBuildDir() = resolve("Carthage/Build")

fun KonanTarget.carthageXcFrameworksPaths(projectDir: File, names: Collection<String>) = xcFrameworksPaths(projectDir.carthageBuildDir(), names)

fun NativeBinary.linkCarthageFrameworks(projectDir: File, names: Collection<String>) = linkXCFrameworks(projectDir.carthageBuildDir(), names)

fun CInteropSettings.configureCarthageFrameworks(target: KotlinNativeTarget, projectDir: File, names: Collection<String>) = configureXCFrameworks(target, projectDir.carthageBuildDir(), names)

fun KotlinNativeTarget.linkCarthageFrameworks(projectDir: File, names: Collection<String>) = linkXCFrameworks(projectDir.carthageBuildDir(), names)