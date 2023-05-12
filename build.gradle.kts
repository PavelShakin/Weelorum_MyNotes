buildscript {
    dependencies {
        classpath("com.android.tools.build:gradle:7.4.2")
        classpath("org.jlleitschuh.gradle:ktlint-gradle:10.3.0")
    }
    repositories {
        mavenCentral()
    }
}

plugins {
    val plugins = com.mynotes.android.buildSrc.AppPlugins
    val version = com.mynotes.android.buildSrc.AppPlugins.Versions

    id(plugins.application) version version.android apply false
    id(plugins.library) version version.android apply false
    id(plugins.kotlin) version version.kotlin apply false
    id(plugins.kapt) version version.kotlin apply false
    id(plugins.navigation) version version.navigation apply false
    id(plugins.detekt) version version.detekt apply true
    id(plugins.ktLint) version version.ktLint apply true
}

subprojects {
    apply(plugin = "org.jlleitschuh.gradle.ktlint")
}
