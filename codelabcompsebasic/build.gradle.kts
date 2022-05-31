plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    compileSdk = 32
    
    defaultConfig {
        applicationId = "fu.trainnin.codelabcompsebasic"
        minSdk = 23
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"
        
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.ANDROID_COMPOSE
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    
    implementation(Dependencies.ANDROID_KTX_CORE)
    implementation(Dependencies.ANDROID_COMPOSE_UI)
    implementation(Dependencies.ANDROID_COMPOSE_MATERIAL)
    implementation(Dependencies.ANDROID_COMPOSE_UI_TOOLS_PREVIEW)
    implementation(Dependencies.ANDROID_LIFECYCLE_RUNTIME_KTX)
    implementation(Dependencies.ANDROID_COMPOSE_ACTIVITY)
    testImplementation(Dependencies.JUNIT)
    //android test
    androidTestImplementation(Dependencies.ANDROID_TEST_CORE)
    androidTestImplementation(Dependencies.ANDROID_TEST_RUNNER)
    androidTestImplementation(Dependencies.ANDROID_TEST_RULES)
    androidTestImplementation(Dependencies.ANDROID_TEST_JUNIT)
    androidTestImplementation(Dependencies.ANDROID_TEST_ESPRESSO_CORE)
    androidTestImplementation(Dependencies.ANDROID_COMPOSE_JUNIT)
    debugImplementation(Dependencies.ANDROID_COMPOSE_UI_TOOLS)
    debugImplementation(Dependencies.ANDROID_COMPOSE_UI_TEST_MANIFEST)
}