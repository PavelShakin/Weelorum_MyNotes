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
    const val applicationId = "com.mynotes.android"
    const val coreId = "com.mynotes.core"
    const val notesId = "com.mynotes.notes"
    const val resourcesId = "com.mynotes.resources"
    const val databaseId = "com.mynotes.database"
    const val dataId = "com.mynotes.data"
    /**
     * com.mynotes.android.buildsrc.Config: testInstrumentationRunner
     */
    const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
}