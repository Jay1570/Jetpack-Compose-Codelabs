plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "com.example.lemonade"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.lemonade"
        minSdk = 24
        targetSdk = 34
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
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {

        }
    }
}

dependencies {
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.6.7")
    implementation(platform("androidx.compose:compose-bom:2024.05.00"))
    implementation("androidx.activity:activity-compose:1.9.0")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation(libs.androidx.monitor)
    implementation(libs.androidx.junit.ktx)
    testImplementation("org.testng:testng:7.10.2")
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.2")
    testImplementation("org.testng:testng:7.10.2")
    testImplementation("org.testng:testng:7.10.2")
    androidTestImplementation("junit:junit:4.13.2")
    androidTestImplementation("org.junit.jupiter:junit-jupiter:5.10.2")
    androidTestImplementation("org.junit.jupiter:junit-jupiter:5.10.2")
    androidTestImplementation("org.junit.jupiter:junit-jupiter:5.10.2")

    debugImplementation("androidx.compose.ui:ui-test-manifest:1.6.7")
    debugImplementation("androidx.compose.ui:ui-tooling")
}