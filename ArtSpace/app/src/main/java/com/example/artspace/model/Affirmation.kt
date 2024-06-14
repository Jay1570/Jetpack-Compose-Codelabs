package com.example.artspace.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Affirmation(
    @StringRes val stringRes: Int,
    @DrawableRes val image: Int
)
