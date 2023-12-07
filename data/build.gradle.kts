plugins {
    id("com.example.template.primitive.android.library")
    id("com.example.template.primitive.android.kotlin")
    id("com.example.template.primitive.android.hilt")
}

android.namespace = "com.example.template.data"
android.buildFeatures.resValues = false

dependencies {
    implementation(projects.model)
    implementation(projects.data.local)
    implementation(projects.data.remote)
}
