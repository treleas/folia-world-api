dependencies {
    compileOnly(libs.spigot)
    api(libs.jetbrains.annotations)
}

tasks.compileJava {
    options.release.set(8)
}