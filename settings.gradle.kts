pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
    resolutionStrategy {
        eachPlugin {
// it's already defined in buildSrc/build.gradle.kts
//            if (requested.id.id.startsWith("com.android")) {
//                useModule("com.android.tools.build:gradle:7.2.2")
//            }

            if (requested.id.id.startsWith("org.jetbrains.kotlin")) {
                useVersion("1.7.10")
            }

            if (requested.id.id == "org.owasp.dependencycheck") {
                useVersion("7.2.0")
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
    ":firebase-core",
    ":firebase-installations",
//    ":firebase-firestore",
//    ":firebase-functions"
)