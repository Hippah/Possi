plugins {
    id("java")
    id("com.github.johnrengelman.shadow")
    id("maven-publish")
}

group = "rip.hippo.possi"
version = "4.2.1"

repositories {
    mavenCentral()
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    maven("https://jitpack.io")
    maven("https://repo.extendedclip.com/content/repositories/placeholderapi/")
}

dependencies {
    implementation(project(":core"))
    compileOnly("org.spigotmc:spigot-api:1.19-R0.1-SNAPSHOT")
    implementation("rip.hippo:ChatTranslate:1.2.0")
    compileOnly("me.clip:placeholderapi:2.11.2")
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = project.group.toString()
            from(components["java"])
        }
    }
}