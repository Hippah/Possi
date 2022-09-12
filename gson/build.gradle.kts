plugins {
    java
    id("com.github.johnrengelman.shadow")
    id("maven-publish")
}

group = "rip.hippo.possi"
version = "4.1.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")

    implementation(project(":core"))

    compileOnly("com.google.code.gson:gson:2.9.0")
    testImplementation("com.google.code.gson:gson:2.9.0")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = project.group.toString()
            from(components["java"])
        }
    }
}