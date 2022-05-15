package com.example.thirdmsixthhm

import android.media.Image
import java.io.Serializable

data class Lesson(
    var image: String? = null,
    var lesson: String? = null,
    var color: Int? = null
) : Serializable
