plugins {
    id("dev.pliniodev.application")
    id("com.google.devtools.ksp") version libs.versions.ksp
}

android {
    namespace = "com.pliniodev.partiturasecompania"

    defaultConfig {
        applicationId = "com.pliniodev.partiturasecompania"
    }
}

dependencies {

    implementation(libs.core.ktx)
    implementation(libs.lifecycle.runtime.ktx)
    implementation(libs.activity.compose)
    implementation(platform(libs.compose.bom))
    implementation(libs.ui)
    implementation(libs.ui.graphics)
    implementation(libs.ui.tooling.preview)
    implementation(libs.material3)
    implementation(libs.ksp)

    // lyricist
    implementation(libs.lyricist)
    implementation(libs.lyricist.processor)
    ksp(libs.lyricist.processor)

    // test
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
    androidTestImplementation(platform(libs.compose.bom))
    androidTestImplementation(libs.ui.test.junit4)
    debugImplementation(libs.ui.tooling)
    debugImplementation(libs.ui.test.manifest)
}

ksp {
    arg("lyricist.internalVisibility", "true")
    arg("lyricist.generateStringsProperty", "true")
}