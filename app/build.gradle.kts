@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("com.example.template.primitive.android.application")
    id("com.example.template.primitive.android.kotlin")
    id("com.example.template.primitive.android.kotlin.serialization")
    id("com.example.template.primitive.android.kotlin.parcelize")
    id("com.example.template.primitive.android.hilt")
    id("com.example.template.primitive.android.compose")
    id("com.example.template.primitive.android.unitTest")
    alias(libs.plugins.firebase.crashlytics)
}

android {
    namespace = "com.example.template"

    buildFeatures {
        this.dataBinding = true
        this.viewBinding = true
        this.buildConfig = true
    }
}

dependencies {
    implementation(projects.model)
    implementation(projects.data)
    implementation(projects.domain)
    implementation(projects.presentation)

    implementation(libs.androidx.core)
    implementation(libs.androidx.appcompat)
    implementation(libs.google.material)

    implementation(libs.timber)
}
