plugins {
    id("com.example.template.primitive.android.library")
    id("com.example.template.primitive.android.kotlin")
    id("com.example.template.primitive.android.hilt")
    id("com.example.template.primitive.android.kotlin.ksp")
}

android.namespace = "com.example.template.data.local"
android.buildFeatures.resValues = false

dependencies {
    implementation(libs.androidx.room)
    implementation(libs.androidx.room.ktx)
    ksp(libs.androidx.room.compiler)

    implementation(libs.bundles.datastore)

    implementation(libs.bundles.protobuf)
    compileOnly(libs.protobuf.google)

    implementation(libs.timber)
}
