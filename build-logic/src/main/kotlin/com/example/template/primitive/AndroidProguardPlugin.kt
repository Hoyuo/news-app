package com.example.template.primitive

import com.example.template.internal.proguardPath
import com.example.template.internal.release
import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidProguardPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            android {
                buildTypes {
                    release {
                        isMinifyEnabled = true
                        proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"))
                        proguardPath("$projectDir/proguard")
                    }
                }
            }
        }
    }
}
