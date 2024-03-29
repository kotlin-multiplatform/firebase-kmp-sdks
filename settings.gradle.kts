pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
    resolutionStrategy {
        eachPlugin {
            // AGP plugin is already defined in buildSrc/build.gradle.kts
            // Kotlin plugin is already defined in buildSrc/build.gradle.kts

//            if (requested.id.id.startsWith("org.jetbrains.kotlin")) {
//                useVersion("1.8.21")
//            }

            if (requested.id.id == "org.owasp.dependencycheck") {
                useVersion("8.2.1")
            }
        }
    }
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }
}

rootProject.name = "firebase-multiplatform"

include(
    ":extensions",
    ":firebase-analytics",
    ":firebase-appcheck",
    ":firebase-appdistribution",
    ":firebase-auth",
    ":firebase-core",
    ":firebase-crashlytics",
    ":firebase-database",
    ":firebase-dynamiclinks",
    ":firebase-firestore",
    ":firebase-functions",
    ":firebase-inappmessaging",
    ":firebase-installations",
    ":firebase-messaging",
    ":firebase-performance",
    ":firebase-remoteconfig",
    ":firebase-storage"
)