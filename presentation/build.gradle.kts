plugins {
    id("com.example.template.primitive.android.library")
    id("com.example.template.primitive.android.kotlin")
    id("com.example.template.primitive.android.hilt")
}

android.namespace = "com.example.template.presentation"
android.buildFeatures.resValues = false
android.buildFeatures.dataBinding = true

dependencies {
    implementation(projects.model)
    implementation(projects.domain)

    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.fragment)
    implementation(libs.bundles.lifecycle)
}
