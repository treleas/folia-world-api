dependencies {
    compileOnly(libs.spigot)
    compileOnly(project(":api"))
}

tasks.compileJava {
    options.release.set(8)
}