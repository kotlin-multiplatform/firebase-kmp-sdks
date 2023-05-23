import com.android.build.gradle.internal.tasks.factory.dependsOn
import org.jetbrains.kotlin.gradle.tasks.CInteropProcess
import suntrix.kmp.xcframework.CarthagePlugin
import java.util.*

plugins {
    id("com.github.ben-manes.versions") version "0.46.0"
}

apply<CarthagePlugin>()

allprojects {
    repositories {
        mavenLocal()
        google()
        mavenCentral()
    }

    setupAllProjects()
}

subprojects {
    apply(plugin="maven-publish")

    group = "suntrix.multiplatform.firebase"

    afterEvaluate {
        dependencies {
            "commonMainImplementation"("org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.Kotlinx.COROUTINES}")

            "commonTestImplementation"(kotlin("test"))

            "androidMainImplementation"(project.dependencies.platform("com.google.firebase:firebase-bom:32.0.0"))
            "androidMainImplementation"("org.jetbrains.kotlinx:kotlinx-coroutines-play-services:${Versions.Kotlinx.COROUTINES}")

            "androidUnitTestImplementation"("junit:junit:4.13.2")

            "androidTestImplementation"("androidx.test.ext:junit:1.1.5")
            "androidTestImplementation"("androidx.test.ext:junit-ktx:1.1.5")
            "androidTestImplementation"("androidx.test:runner:1.5.2")
        }
    }
}

tasks.register("clean", Delete::class) {
    dependsOn("carthageClean")

    delete(rootProject.buildDir)
}

tasks.withType<com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask> {

    fun isNonStable(version: String): Boolean {
        val stableKeyword = listOf("RELEASE", "FINAL", "GA").any { version.toUpperCase().contains(it) }
        val versionMatch = "^[0-9,.v-]+(-r)?$".toRegex().matches(version)

        return (stableKeyword || versionMatch).not()
    }

    rejectVersionIf {
        isNonStable(candidate.version)
    }

    checkForGradleUpdate = true
    outputFormatter = "plain,html"
    outputDir = "build/dependency-reports"
    reportfileName = "dependency-updates"
}

// check for latest dependencies - ./gradlew dependencyUpdates -Drevision=release
// check for any known dependency vulnerabilities - ./gradlew dependencyCheckAnalyze