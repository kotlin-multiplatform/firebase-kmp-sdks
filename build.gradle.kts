import org.jetbrains.kotlin.gradle.tasks.CInteropProcess

plugins {
    id("com.github.ben-manes.versions") version "0.42.0"
}

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
            "commonTestImplementation"(kotlin("test-common"))
            "commonTestImplementation"(kotlin("test-annotations-common"))

            "androidMainImplementation"(project.dependencies.platform("com.google.firebase:firebase-bom:30.5.0"))

            "androidTestImplementation"(kotlin("test-junit"))
            "androidTestImplementation"("junit:junit:${Versions.JUNIT}")

            "androidAndroidTestImplementation"("androidx.test.ext:junit:1.1.3")
            "androidAndroidTestImplementation"("androidx.test.ext:junit-ktx:1.1.3")
            "androidAndroidTestImplementation"("androidx.test:runner:1.4.0")
        }
    }

//    tasks {
//        val carthageDir = projectDir.resolve("src/nativeInterop/cinterop")
//
//        if (carthageDir.resolve("Cartfile").exists()) {
//            listOf("bootstrap", "build", "update").forEach {
//                register("carthage${it.capitalize()}", Exec::class) {
//                    group = "carthage"
//
//                    executable = "sh"
//                    args("-c", "/usr/local/bin/carthage $it --cache-builds --project-directory $carthageDir")
//                }
//            }
//
//            withType(CInteropProcess::class) {
//                dependsOn("carthageBootstrap")
//            }
//
//            register("carthageClean", Delete::class) {
//                group = "carthage"
//
//                delete(carthageDir)
//            }
//        }
//    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

tasks {
    listOf("bootstrap", "build", "update").forEach {
        register("carthage${it.capitalize()}", Exec::class) {
            group = "carthage"

            executable = "sh"
            args("-c", "/usr/local/bin/carthage $it --cache-builds --project-directory $rootDir")
        }
    }

    withType(CInteropProcess::class) {
        dependsOn("carthageBootstrap")
    }

    register("carthageClean", Delete::class) {
        group = "carthage"

        delete(rootDir.resolve("Carthage"))
    }
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