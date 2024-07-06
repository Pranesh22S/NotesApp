plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("com.google.devtools.ksp")
    id("androidx.navigation.safeargs.kotlin")
  //  id("androidx.navigation.safeargs.kotlin")
    //id("com.androidx.application")
    id("kotlin-android")
    //id("kotlin-android-extensions")
    id("kotlin-kapt")
   /* id("kotlin-kapt")
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
  //  id("androidx.navigation.safeargs.kotlin")*/
}

android {
    namespace = "com.example.notesapplicationkt"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.notesapplicationkt"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    viewBinding{
        enable=true
    }
    buildFeatures{
        dataBinding = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}
dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
//    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.5.31")
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation("androidx.navigation:navigation-fragment-ktx:2.3.5")
    implementation ("androidx.navigation:navigation-ui-ktx:2.3.5")
    val room_version = "2.6.1"
    implementation ("androidx.room:room-runtime:$room_version")
    ksp ("androidx.room:room-compiler:$room_version")
    implementation ("androidx.room:room-rxjava2:$room_version")
    implementation ("androidx.room:room-rxjava3:$room_version")
    implementation ("androidx.room:room-guava:$room_version")
    testImplementation ("androidx.room:room-testing:$room_version")
    implementation ("androidx.room:room-paging:$room_version")
}
