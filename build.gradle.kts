plugins {
    java
    id("com.github.johnrengelman.shadow").version("7.1.2")
    id("maven-publish")
}

group = "rip.hippo.possi"
version = "4.2.2"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
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