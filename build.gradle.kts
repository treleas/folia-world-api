plugins {
    `java-library`
    `maven-publish`
    alias(libs.plugins.shadow)
    alias(libs.plugins.lombok)
}

allprojects {
    apply<JavaLibraryPlugin>()
    apply<io.freefair.gradle.plugins.lombok.LombokPlugin>()

    java {
        toolchain.languageVersion.set(JavaLanguageVersion.of(21))
    }

    repositories {
        mavenCentral()
        maven("https://mvn.treleas.ru/releases/")
        maven("https://repo.papermc.io/repository/maven-public/")
    }

    tasks {
        compileJava {
            options.encoding = Charsets.UTF_8.name()
        }
        javadoc {
            options.encoding = Charsets.UTF_8.name()
        }
        processResources {
            filteringCharset = Charsets.UTF_8.name()
        }
    }
}

dependencies {
    compileOnly(libs.spigot)
    implementation(project(":api"))
    compileOnly(project(":headers"))
}

tasks.build {
    dependsOn(tasks.shadowJar)

    if (project.version.toString().endsWith("-SNAPSHOT")) {
        finalizedBy(tasks.publishToMavenLocal)
    }
}

tasks.shadowJar {
    listOf("v1_20_R3", "v1_20_R4").forEach {
        val task = project(":$it").tasks.named("reobfJar")
        dependsOn(task)
        from(zipTree(task.map { it.outputs.files.singleFile }))
    }
}

tasks.compileJava {
    options.release.set(8)
}

val isSnapshot = project.version.toString().endsWith("-SNAPSHOT")

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = project.group.toString()
            artifactId = project.name
            version = "${project.version}"
            description ="${project.description}"

            artifact(tasks.shadowJar) { classifier = null }

            pom {
                name.set("FoliaWorldAPI")
                description.set(project.description)
                url.set("https://dev.treleas.ru/treleas/folia-world-api")
                packaging = "jar"

                developers {
                    developer {
                        id.set("treleas")
                        name.set("Ivan Churin")
                        email.set("treleas2@gmail.com")
                        url.set("https://gitlab.com/treleas")
                    }
                }
            }
        }
    }

    repositories {
        val url = if (isSnapshot) {
            "https://mvn.treleas.ru/snapshots/"
        } else {
            "https://mvn.treleas.ru/releases/"
        }

        maven(url) {
            credentials(PasswordCredentials::class)
            name = "treleas"
        }
    }
}
