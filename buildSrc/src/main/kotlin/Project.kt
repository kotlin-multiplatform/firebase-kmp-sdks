import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.api.tasks.Copy
import org.gradle.api.tasks.compile.JavaCompile
import org.gradle.kotlin.dsl.findByType
import org.gradle.kotlin.dsl.register
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

/**
 * Created by Sebastian Owodzin on 20/09/2021
 */
fun Project.setupAllProjects(jvmTarget: JavaVersion = JavaVersion.VERSION_1_8) {
    val jvmTargetString = jvmTarget.toString()
    afterEvaluate {
        tasks.withType(JavaCompile::class) {
            sourceCompatibility = jvmTargetString
            targetCompatibility = jvmTargetString
            options.compilerArgs.addAll(listOf("-Xmaxerrs", "10000"))
        }

        tasks.withType<KotlinCompile>().all {
            kotlinOptions.freeCompilerArgs += "-progressive"
            kotlinOptions.jvmTarget = jvmTargetString
        }

        /*
            temp fix for
            The following Kotlin source sets were configured but not added to any Kotlin compilation:
             * androidAndroidTestBeta
             * androidAndroidTestRelease
         */
//        project.extensions.findByType<KotlinMultiplatformExtension>()?.let { ext ->
//            ext.sourceSets.removeAll { sourceSet ->
//                setOf(
//                    "androidAndroidTestRelease",
//                    "androidTestFixtures",
//                    "androidTestFixturesDebug",
//                    "androidTestFixturesRelease"
//                ).contains(sourceSet.name)
//            }
//        }

        tasks.register("gatherTestResults", Copy::class) {
            from(project.buildDir.resolve("test-results"))
            include("**/*.xml")
            into(project.rootProject.buildDir.resolve("test-results"))
        }
    }
}