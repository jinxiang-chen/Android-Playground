plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    
    compileSdk = AppConfig.COMPILE_SDK
    buildToolsVersion = AppConfig.BUILD_TOOLS_VERSION
    
    defaultConfig {
        minSdk = AppConfig.MIN_SDK
        targetSdk = AppConfig.TARGET_SDK
        versionCode = 1
        applicationId = "fu.trainnin.stateincompose"
        
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }
    
    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
        }
        
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
        }
    }
    compileOptions {
        sourceCompatibility(JavaVersion.VERSION_11)
        targetCompatibility(JavaVersion.VERSION_11)
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        viewBinding = true
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
    
    //test
    testImplementation(Dependencies.COROUTINE_TEST)
    testImplementation(Dependencies.JUNIT)
    testImplementation(Dependencies.TRUTH)
    testImplementation(Dependencies.TRUTH_EXTENSION_JAVA8)
    testImplementation(Dependencies.ROBOLECTRIC)
    testImplementation(Dependencies.ANDROID_TEST_CORE)
    testImplementation(Dependencies.ANDROID_TEST_ARCH_CORE_TESTING)
    //android test
    androidTestImplementation(Dependencies.ANDROID_TEST_CORE)
    androidTestImplementation(Dependencies.ANDROID_TEST_RUNNER)
    androidTestImplementation(Dependencies.ANDROID_TEST_RULES)
    androidTestImplementation(Dependencies.ANDROID_TEST_JUNIT)
    androidTestImplementation(Dependencies.ANDROID_TEST_ESPRESSO_CORE)
    androidTestImplementation(Dependencies.ANDROID_COMPOSE_JUNIT)
    //android
    implementation(Dependencies.ANDROID_KTX_CORE)
    implementation(Dependencies.ANDROID_APPCOMPAT)
    implementation(Dependencies.ANDROID_CONSTRAINT_LAYOUT)
    implementation(Dependencies.ANDROID_MATERIAL)
    // android compose
    implementation(Dependencies.ANDROID_COMPOSE_UI)
    implementation(Dependencies.ANDROID_COMPOSE_MATERIAL)
    implementation(Dependencies.ANDROID_COMPOSE_UI_TOOLS_PREVIEW)
    implementation(Dependencies.ANDROID_COMPOSE_RUNTIME)
    implementation(Dependencies.ANDROID_COMPOSE_VIEW_MODEL)
    implementation(Dependencies.ANDROID_COMPOSE_RUNTIME_LIVEDATA)
    implementation(Dependencies.ANDROID_COMPOSE_ACTIVITY)
    implementation(Dependencies.ANDROID_COMPOSE_CONSTRAINT_LAYOUT)
    debugImplementation(Dependencies.ANDROID_COMPOSE_UI_TOOLS)
    debugImplementation(Dependencies.ANDROID_COMPOSE_UI_TEST_MANIFEST)
}