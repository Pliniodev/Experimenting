package com.pliniodev.feature.resource

import cafe.adriel.lyricist.LyricistStrings

data class FeatureStrings(
    val title: String = "Title",
)

@LyricistStrings(languageTag = "pt", default = true)
val strings = FeatureStrings()