plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.plugin.compose") version "2.0.21"
}

android {
    namespace = "com.example.playlist_maker_android_voroninartem"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.playlist_maker_android_voroninartem" // ИСПРАВЛЕНО
        minSdk = 26
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        compose = true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
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
}

dependencies {
    implementation(platform("androidx.compose:compose-bom:2025.05.00"))
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.activity:activity-compose:1.9.1")
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
}