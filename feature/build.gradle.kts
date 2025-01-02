plugins {
    `android-library`
    `kotlin-android`
    alias(libs.plugins.jetbrainsCompose)
    id("com.google.devtools.ksp") version libs.versions.ksp
}

apply<MainGradlewPlugin>()

android {
    namespace = "com.pliniodev.experimenting.feature"
}

dependencies {
    implementation(project(":core:navigation"))

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

    // voyager
    implementation(libs.bundles.voyager)

    // koin
    implementation(libs.bundles.koin)

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