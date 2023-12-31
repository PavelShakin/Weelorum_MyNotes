import com.mynotes.android.buildSrc.Config
import com.mynotes.android.buildSrc.Dependencies

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdk = Config.compileSdk
    namespace = Config.Modules.resources

    defaultConfig {
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk
        multiDexEnabled = true
        vectorDrawables.useSupportLibrary = true
        testInstrumentationRunner = Config.testInstrumentationRunner
    }

    buildTypes {
        release {
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Dependencies.Compose.compileVersion
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }

    buildFeatures {
        compose = true
    }
}

dependencies {

    //region Modules
    implementation(project(Dependencies.Modules.core))
    //endregion

    //region AndroidBase
    implementation(Dependencies.AndroidBase.ktx)
    implementation(Dependencies.AndroidBase.appcompat)
    implementation(Dependencies.AndroidBase.material)
    implementation(Dependencies.AndroidBase.constraintLayout)
    runtimeOnly(Dependencies.AndroidBase.kotlinxMetadataJvm)
    //endregion

    //region Tests
    testImplementation(Dependencies.Tests.junit)
    androidTestImplementation(Dependencies.Tests.extJunit)
    androidTestImplementation(Dependencies.Tests.espressoCore)
    //endregion

    //region Navigation
    implementation(Dependencies.Navigation.fragment)
    implementation(Dependencies.Navigation.ui)
    implementation(Dependencies.Navigation.compose)
    implementation(Dependencies.Navigation.testing)
    //endregion

    //region Compose
    implementation(Dependencies.Compose.ui)
    implementation(Dependencies.Compose.activity)
    implementation(Dependencies.Compose.material)
    implementation(Dependencies.Compose.tooling)
    implementation(Dependencies.Compose.livedata)
    implementation(Dependencies.Compose.accompanist)
    implementation(Dependencies.Compose.permissions)
    androidTestImplementation(Dependencies.Compose.uiTest)
    debugImplementation(Dependencies.Compose.toolingTest)
    //endregion

    //region DI
    implementation(Dependencies.DI.dagger)
    implementation(Dependencies.DI.daggerSupport)
    kapt(Dependencies.DI.daggerCompiler)
    kapt(Dependencies.DI.daggerAndroidProcessor)
    //endregion

    //region Lifecycle
    implementation(Dependencies.Lifecycle.runtime)
    implementation(Dependencies.Lifecycle.livedata)
    implementation(Dependencies.Lifecycle.viewModel)
    implementation(Dependencies.Lifecycle.viewModelCompose)
    implementation(Dependencies.Lifecycle.viewModelSavedState)
    kapt(Dependencies.Lifecycle.compiler)
    //endregion

    //region Room
    api(Dependencies.Room.runtime)
    kapt(Dependencies.Room.compiler)
    implementation(Dependencies.Room.roomKtx)
    testImplementation(Dependencies.Room.testing)
    //endregion
}
