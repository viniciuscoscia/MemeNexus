plugins {
    alias(libs.plugins.kotlinJvm)
    alias(libs.plugins.ktor)
    application
}

group = "com.viniciuscoscia.memenexus"
version = "1.0.0"
application {
    mainClass.set("com.viniciuscoscia.memenexus.ApplicationKt")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=${extra["io.ktor.development"] ?: "false"}")
}

dependencies {
    implementation(projects.shared)
    implementation(libs.logback)
    implementation(libs.ktor.server.core)
    implementation(libs.ktor.server.netty)
//    testImplementation(libs.ktor.server.tests) commented out until it gets stable
    testImplementation(libs.kotlin.test.junit)
}