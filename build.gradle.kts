plugins {
    kotlin("jvm") version "2.1.10"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    // AndroidX Test Libraries
    // JUnit 5 for Unit Testing
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.2")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.7.2")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher:1.7.2")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(11)
}