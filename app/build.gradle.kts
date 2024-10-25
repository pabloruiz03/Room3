plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    kotlin("kapt") // Asegúrate de incluir esto para KAPT
}

android {
    namespace = "pablo.ruiz.room3"
    compileSdk = 34

    defaultConfig {
        applicationId = "pablo.ruiz.room3"
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
        jvmTarget = "1.8" // Asegúrate de que esto esté en línea con tu versión de Kotlin
    }

    buildFeatures {
        compose = true // Habilitar Jetpack Compose
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1" // Cambia según la versión de Compose que estés usando
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    // Dependencias básicas
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom)) // BOM para manejar versiones de Compose
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)

    // Agrega las dependencias de Room
    val roomVersion = "2.5.2" // Cambia a la última versión si es necesario
    implementation("androidx.room:room-runtime:$roomVersion") // Dependencia de Room
    kapt("androidx.room:room-compiler:$roomVersion") // Procesador de anotaciones de Room
    implementation("androidx.room:room-ktx:$roomVersion") // Extensiones de Kotlin para Room (opcional)

    // Dependencias de Lifecycle y ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2") // ViewModel para Lifecycle
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.2") // ViewModel para Compose

    // Dependencias para pruebas
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)

    // Herramientas de desarrollo
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)


}
