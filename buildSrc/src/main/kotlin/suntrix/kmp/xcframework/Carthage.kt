package suntrix.kmp.xcframework

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.Delete
import org.gradle.api.tasks.Exec
import org.gradle.kotlin.dsl.register
import org.gradle.kotlin.dsl.support.delegates.ProjectDelegate
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.plugin.CInteropSettings
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget
import org.jetbrains.kotlin.gradle.plugin.mpp.NativeBinary
import org.jetbrains.kotlin.gradle.tasks.CInteropProcess
import org.jetbrains.kotlin.konan.target.KonanTarget
import java.io.File

/**
 * Created by Sebastian Owodzin on 02/04/2023
 */
fun File.carthageBuildDir() = resolve("Carthage/Build")

fun Project.carthageBuildDir() = rootDir.resolve("Carthage/Build")

fun KonanTarget.carthageXcFrameworksPaths(projectDir: File, names: Collection<String>) = xcFrameworksPaths(projectDir.carthageBuildDir(), names)

fun NativeBinary.linkCarthageFrameworks(projectDir: File, names: Collection<String>) = linkXCFrameworks(projectDir.carthageBuildDir(), names)

fun CInteropSettings.configureCarthageFrameworks(target: KotlinNativeTarget, projectDir: File, names: Collection<String>) = configureXCFrameworks(target, projectDir.carthageBuildDir(), names)

fun KotlinNativeTarget.linkCarthageFrameworks(projectDir: File, names: Collection<String>) = linkXCFrameworks(projectDir.carthageBuildDir(), names)

class CarthagePlugin : Plugin<Project> {
    override fun apply(project: Project) {
        with(project.tasks) {
            listOf("bootstrap", "build", "update").forEach {
                register("carthage${it.replaceFirstChar { it.titlecase() }}", Exec::class) {
                    group = "carthage"

                    executable = "sh"
                    args("-c", "/usr/local/bin/carthage $it --cache-builds --project-directory ${project.rootDir}")
                }
            }

            withType(CInteropProcess::class) {
                dependsOn("carthageBootstrap")
            }

            register("carthageClean", Delete::class) {
                group = "carthage"

                delete(project.rootDir.resolve("Carthage"))
            }
        }
    }
}