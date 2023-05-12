package com.mynotes.android.buildSrc

/**
 * App configuration properties uses in build .apk or .aab
 */
object Config {
    /**
     * com.mynotes.android.buildsrc.Config: targetSdk
     */
    const val targetSdk = 33
    /**
     * com.mynotes.android.buildsrc.Config: compileSdk
     */
    const val compileSdk = targetSdk
    /**
     * com.mynotes.android.buildsrc.Config: min sdk support
     */
    const val minSdk = 30
    /**
     * com.mynotes.android.buildsrc.Config: version code
     */
    const val versionCode = 1
    /**
     * com.mynotes.android.buildsrc.Config: version name
     */
    private const val major = "0"
    private const val minor = "0"
    private const val path = "1"
    private const val currentTask = "0"
    const val versionName = "$major.$minor.${path}_$currentTask"
    /**
     * com.mynotes.android.buildsrc.Config: modules Id
     */
    object Modules {
        const val application = "com.mynotes.android"
        const val core = "com.mynotes.core"
        const val notes = "com.mynotes.notes"
        const val resources = "com.mynotes.resources"
        const val database = "com.mynotes.database"
        const val data = "com.mynotes.data"
        const val domain = "com.mynotes.domain"
    }
    /**
     * com.mynotes.android.buildsrc.Config: testInstrumentationRunner
     */
    const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
}