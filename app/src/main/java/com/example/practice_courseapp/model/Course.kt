package com.example.practice_courseapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Course(
    @StringRes val name: Int,
    val numberOfAssociatedCourses: Int,
    @DrawableRes val image: Int
)
