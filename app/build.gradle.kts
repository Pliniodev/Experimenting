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
    // compose
    implementation(libs.bundles.compose)
    implementation(platform(libs.compose.bom))
    
    // core
    implementation(libs.bundles.ktx)
    implementation(libs.material3)
    implementation(libs.ksp)

    // lyricist
    implementation(libs.bundles.lyricist)
    ksp(libs.lyricist.processor)

    // test
    testImplementation(libs.junit)
    androidTestImplementation(platform(libs.compose.bom))
    androidTestImplementation(libs.bundles.android.test)
    debugImplementation(libs.ui.tooling)
    debugImplementation(libs.ui.test.manifest)
}

ksp {
    arg("lyricist.internalVisibility", "true")
    arg("lyricist.generateStringsProperty", "true")
}