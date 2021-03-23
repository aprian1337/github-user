package com.aprian1337.github_user

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
        val name: String ="",
        val username: String = "",
        val location: String ="",
        val repository: Int =0,
        val company: String ="",
        val followers: Int =0,
        val following: Int =0,
        val avatar: Int = 0,
):Parcelable