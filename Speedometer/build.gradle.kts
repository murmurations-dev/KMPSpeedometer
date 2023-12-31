plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.ksp)
    alias(libs.plugins.kmp.nativecoroutines)
}

//@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    targetHierarchy.default()

    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "Speedometer"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                //put your multiplatform dependencies here
                implementation(libs.kermit)
                implementation(libs.kotlinx.coroutines.core)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(libs.kotlin.test)
            }
        }
        val iosMain by getting {
            dependencies {
                // Only if you want to talk to Kermit from Swift
                api(libs.kermit.simple)
            }
        }
    }
}

android {
    namespace = "dev.murmurations.kmpspeedometer"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
}
dependencies {
    implementation(libs.androidx.core.ktx)
}
