package com.pliniodev.experimenting.resources

import cafe.adriel.lyricist.LyricistStrings

data class HomeStrings(
    val hello: (String) -> String = { name -> "Hello $name" },
)

@LyricistStrings(languageTag = "pt", default = true)
val strings = HomeStrings()