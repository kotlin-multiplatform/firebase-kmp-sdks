plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
}

dependencies {
    implementation("com.android.tools.build:gradle:7.4.1")
    implementation("org.ajoberstar.grgit:grgit-core:5.0.0")
    implementation(kotlin("gradle-plugin", "1.8.21"))
}

//kotlin {
//    jvmToolchain(17)
//}