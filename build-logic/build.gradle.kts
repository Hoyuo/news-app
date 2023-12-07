import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

group = "com.example.template.buildlogic"

repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
}

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions.jvmTarget = JavaVersion.VERSION_17.toString()

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    implementation(gradleKotlinDsl())
    implementation(libs.kotlin.stdlib)
    implementation(libs.kotlin.gradlePlugin)
    implementation(libs.android.gradlePlugin)
    implementation(libs.hilt.android.gradlePlugin)
    implementation(libs.protobuf.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "com.example.template.primitive.android.application"
            implementationClass = "com.example.template.primitive.AndroidApplicationPlugin"
        }
        register("androidLibrary") {
            id = "com.example.template.primitive.android.library"
            implementationClass = "com.example.template.primitive.AndroidLibraryPlugin"
        }
        register("androidProguard") {
            id = "com.example.template.primitive.android.proguard"
            implementationClass = "com.example.template.primitive.AndroidProguardPlugin"
        }
        register("androidUnitTest") {
            id = "com.example.template.primitive.android.unitTest"
            implementationClass = "com.example.template.primitive.KotlinUnitTestPlugin"
        }
        register("androidCompose") {
            id = "com.example.template.primitive.android.compose"
            implementationClass = "com.example.template.primitive.AndroidComposePlugin"
        }
        register("androidHilt") {
            id = "com.example.template.primitive.android.hilt"
            implementationClass = "com.example.template.primitive.AndroidHiltPlugin"
        }
        register("androidKotlinPlugin") {
            id = "com.example.template.primitive.android.kotlin"
            implementationClass = "com.example.template.primitive.AndroidKotlinPlugin"
        }
        register("androidKotlinSerializationPlugin") {
            id = "com.example.template.primitive.android.kotlin.serialization"
            implementationClass = "com.example.template.primitive.AndroidKotlinSerializationPlugin"
        }
        register("androidKotlinParcelizePlugin") {
            id = "com.example.template.primitive.android.kotlin.parcelize"
            implementationClass = "com.example.template.primitive.AndroidKotlinParcelizePlugin"
        }
        register("androidKotlinSymbolPlugin") {
            id = "com.example.template.primitive.android.kotlin.ksp"
            implementationClass = "com.example.template.primitive.AndroidKotlinSymbolPlugin"
        }

        // Conventions
        register("androidFeature") {
            id = "com.example.template.convention.feature"
            implementationClass = "com.example.template.convention.AndroidFeaturePlugin"
        }

        register("GoogleProtoBuf") {
            id = "com.example.template.primitive.google.protobuf"
            implementationClass = "com.example.template.primitive.GoogleProtoBufPlugin"
        }
    }
}
