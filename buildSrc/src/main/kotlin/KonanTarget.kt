import groovy.lang.Closure
import org.gradle.api.Action
import org.gradle.api.NamedDomainObjectContainer
import org.gradle.api.Project
import org.gradle.util.ConfigureUtil
import java.io.File
import org.jetbrains.kotlin.gradle.plugin.mpp.DefaultCInteropSettings
import org.jetbrains.kotlin.gradle.plugin.mpp.NativeBinary
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeCompilation
import org.jetbrains.kotlin.gradle.plugin.mpp.pm20.KotlinNativeCompilationData
import org.jetbrains.kotlin.konan.target.Family
import org.jetbrains.kotlin.konan.target.KonanTarget
import suntrix.kmp.xcframework.select
import suntrix.kmp.xcframework.XCFrameworkInfoParser

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

//fun KonanTarget.firebaseCoreFrameworksPaths(projectDir: File, names: List<String>) =
//    carthageXcFrameworksPaths(
//        projectDir,
//        names
//    )

fun NativeBinary.linkCarthageFrameworks(projectDir: File, names: List<String>) {
    linkerOpts(target.konanTarget.carthageXcFrameworksPaths(projectDir, names).map { "-F$it" })
}

//class CarthageCInteropSettings(
//    project: Project,
//    name: String,
//    compilation: KotlinNativeCompilationData<*>
//) : DefaultCInteropSettings(project, name, compilation) {
//
//    init {
//        val konanTarget = target?.konanTarget
//        val nativeFrameworkPaths = konanTarget?.firebaseCoreFrameworksPaths(project.projectDir)
//
//        nativeFrameworkPaths?.let {
//            compilerOpts(nativeFrameworkPaths.map { "-F$it" })
//        }
//    }
//}
//
//val KotlinNativeCompilation.carthageCinterops: NamedDomainObjectContainer<CarthageCInteropSettings>
//    get() = project.container(CarthageCInteropSettings::class.java) { cinteropName ->
//        CarthageCInteropSettings(project, cinteropName, this)
//    }
//
//fun KotlinNativeCompilation.carthageCinterops(action: Closure<Unit>) = cinterops(ConfigureUtil.configureUsing(action))
//fun KotlinNativeCompilation.carthageCinterops(action: Action<NamedDomainObjectContainer<CarthageCInteropSettings>>) = action.execute(carthageCinterops)

fun DefaultCInteropSettings.configureCarthageFrameworks(projectDir: File, names: List<String>) {
    compilerOpts(
        target?.konanTarget?.carthageXcFrameworksPaths(projectDir, names)?.map { "-F$it" } ?: emptyList()
    )
}
