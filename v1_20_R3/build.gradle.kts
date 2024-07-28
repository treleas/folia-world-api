plugins {
    java
    alias(libs.plugins.paperweight.userdev)
}

dependencies {
    paperweight.foliaDevBundle("1.20.4-R0.1-SNAPSHOT")
    pluginRemapper("net.fabricmc:tiny-remapper:0.10.3:fat")
    compileOnly(project(":api"))
}

tasks.compileJava {
    options.release.set(17)
}