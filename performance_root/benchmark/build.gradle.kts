plugins {
    id("com.android.test")
    id("org.jetbrains.kotlin.android")
}

android {
    compileSdk = AppConfig.COMPILE_SDK
    
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    
    kotlinOptions {
        jvmTarget = "11"
    }
    
    defaultConfig {
        minSdk = AppConfig.MIN_SDK
        targetSdk = AppConfig.TARGET_SDK
        
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    
    buildTypes {
        // This benchmark buildType is used for benchmarking, and should function like your
        // release build (for example, with minification on). It"s signed with a debug key
        // for easy local/CI testing.
        create("benchmark") {
            isDebuggable = true
            signingConfig = getByName("debug").signingConfig
            matchingFallbacks += listOf("release")
        }
    }
    
    targetProjectPath = ":performance_root:performance"
    experimentalProperties["android.experimental.self-instrumenting"] = true
}

dependencies {
    implementation("androidx.test.ext:junit:1.1.3")
    implementation("androidx.test.espresso:espresso-core:3.4.0")
    implementation("androidx.test.uiautomator:uiautomator:2.2.0")
    implementation("androidx.benchmark:benchmark-macro-junit4:1.1.0-beta04")
}

androidComponents {
    beforeVariants(selector().all()) {
        it.enabled = it.buildType == "benchmark"
    }
}