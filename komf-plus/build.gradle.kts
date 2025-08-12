plugins {
    kotlin("jvm") version "1.6.10"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    implementation("ch.qos.logback:logback-classic:1.2.3")
    testImplementation("org.junit.jupiter:junit-jupiter:5.7.0")
}

tasks.test {
    useJUnitPlatform()
}