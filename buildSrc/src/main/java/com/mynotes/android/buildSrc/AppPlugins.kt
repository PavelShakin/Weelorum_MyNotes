package com.mynotes.android.buildSrc

object AppPlugins {
    const val application = "com.android.application"
    const val library = "com.android.library"
    const val kotlin = "org.jetbrains.kotlin.android"
    const val kapt = "org.jetbrains.kotlin.kapt"
    const val navigation = "androidx.navigation.safeargs"
    const val detekt = "io.gitlab.arturbosch.detekt"
    const val ktLint = "org.jlleitschuh.gradle.ktlint"

    object Versions {
        const val android = "7.4.2"
        const val kotlin = "1.8.20"
        const val navigation = "2.5.1"
        const val detekt = "1.21.0"
        const val ktLint = "10.3.0"
    }
}