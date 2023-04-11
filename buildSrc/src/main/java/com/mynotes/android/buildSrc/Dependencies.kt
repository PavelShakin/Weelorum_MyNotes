package com.mynotes.android.buildSrc

object Dependencies {

    /**
     * com.vortex.android.buildsrc.Dependencies: Android base libraries
     */
    object AndroidBase {
        const val ktx = ("androidx.core:core-ktx:1.7.0")
        const val appcompat = ("androidx.appcompat:appcompat:1.4.1")
        const val material = ("com.google.android.material:material:1.5.0")
        const val constraintLayout = ("androidx.constraintlayout:constraintlayout:2.1.3")
        const val kotlinxMetadataJvm = ("org.jetbrains.kotlinx:kotlinx-metadata-jvm:0.5.0")
        const val fragments = ("androidx.fragment:fragment-ktx:1.5.5")
    }

    /**
     * com.vortex.android.buildsrc.Dependencies: Compose
     */
    object Compose {
        private const val version = "1.2.1"
        private const val materialVersion = "1.3.1"
        const val compileVersion = "1.3.1"
        const val accompanistVersion = "0.27.0"
        const val ui = "androidx.compose.ui:ui:$version"
        const val activity = "androidx.activity:activity-compose:1.6.0"
        const val material = "androidx.compose.material:material:$materialVersion"
        const val tooling = "androidx.compose.ui:ui-tooling-preview:$version"
        const val runtime = "androidx.compose.runtime:runtime:$version"
        const val livedata = "androidx.compose.runtime:runtime-livedata:$version"
        const val toolingTest = "androidx.compose.ui:ui-tooling:$version"
        const val uiTest = "androidx.compose.ui:ui-test-junit4:$version"
        const val foundation = "androidx.compose.foundation:foundation:$version"
        const val compiler = "androidx.compose.compiler:compiler:$compileVersion"
        private const val versionCoil = "2.2.2"
        const val coil = "io.coil-kt:coil:$versionCoil"
        const val coilCompose = "io.coil-kt:coil-compose:$versionCoil"
        const val customView = "androidx.customview:customview:1.1.0"
        const val poolingContainer = "androidx.customview:customview-poolingcontainer:1.0.0"
        const val accompanist =
            "com.google.accompanist:accompanist-systemuicontroller:$accompanistVersion"
        const val permissions = "com.google.accompanist:accompanist-permissions:$accompanistVersion"
        const val lottieCompose = "com.airbnb.android:lottie-compose:5.0.3"
    }

    /**
     * com.vortex.android.buildsrc.Dependencies: Coroutines
     */
    object Coroutines {
        private const val version = "1.6.0"
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
        const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$version"
    }

    /**
     * com.vortex.android.buildsrc.Dependencies: Dependency Injection
     */
    object DI {
        private const val version = "2.44"
        const val dagger = ("com.google.dagger:dagger:$version")
        const val daggerCompiler = ("com.google.dagger:dagger-compiler:$version")
        const val daggerSupport = ("com.google.dagger:dagger-android-support:$version")
        const val daggerAndroidProcessor = ("com.google.dagger:dagger-android-processor:$version")
    }

    /**
     * com.vortex.android.buildsrc.Dependencies: Lifecycle
     */
    object Lifecycle {
        private const val version = "2.5.1"
        const val viewModel = ("androidx.lifecycle:lifecycle-viewmodel-ktx:$version")
        const val viewModelCompose = ("androidx.lifecycle:lifecycle-viewmodel-compose:$version")
        const val livedata = ("androidx.lifecycle:lifecycle-livedata-ktx:$version")
        const val runtime = ("androidx.lifecycle:lifecycle-runtime-ktx:$version")
        const val compiler = ("androidx.lifecycle:lifecycle-compiler:$version")
        const val viewModelSavedState =
            ("androidx.lifecycle:lifecycle-viewmodel-savedstate:$version")
    }

    /**
     * com.vortex.android.buildsrc.Dependencies: Navigation
     */
    object Navigation {
        private const val version = "2.4.1"
        const val fragment = ("androidx.navigation:navigation-fragment-ktx:$version")
        const val ui = ("androidx.navigation:navigation-ui-ktx:$version")
        const val testing = ("androidx.navigation:navigation-testing:$version")
        const val compose = ("androidx.navigation:navigation-compose:$version")
    }

    /**
     * com.vortex.android.buildsrc.Dependencies: Room
     */
    object Room {
        private const val version = "2.4.3"
        const val runtime = ("androidx.room:room-runtime:$version")
        const val compiler = ("androidx.room:room-compiler:$version")
        const val roomKtx = ("androidx.room:room-ktx:$version")
        const val testing = ("androidx.room:room-testing:$version")
    }

    /**
     * com.vortex.android.buildsrc.Dependencies: Tests
     */
    object Tests {
        private const val mockitoVersion = "4.3.1"
        const val junit = ("junit:junit:4.13.1")
        const val extJunit = ("androidx.test.ext:junit:1.1.3")
        const val espressoCore = ("androidx.test.espresso:espresso-core:3.4.0")
        const val testingCore = ("androidx.arch.core:core-testing:2.1.0")
        const val truth = ("com.google.truth:truth:1.0.1")
        const val mockitoCore = ("org.mockito:mockito-core:$mockitoVersion")
        const val mockitoAndroid = ("org.mockito:mockito-android:$mockitoVersion")
    }

    /**
     * com.mynotes.android.buildsrc.Dependencies: Modules
     */
    object Modules {
        val core = mapOf("path" to ":core")
        val resources = mapOf("path" to ":resources")
        val notes = mapOf("path" to ":notes")
    }
}