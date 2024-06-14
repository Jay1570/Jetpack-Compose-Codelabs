package com.example.myapplication

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes  val topicName: Int,
    val grade : Int,
    @DrawableRes val topicImage: Int
)