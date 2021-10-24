package com.kikopoggi.profilecardlayout

data class UserProfile constructor(val name: String, val status: Boolean, val drawableId: Int)

val userProfileList = arrayListOf<UserProfile>(
    UserProfile(name = "João da Silva", true, R.drawable.man),
    UserProfile(name = "Maria da Silva", false, R.drawable.woman),
    UserProfile(name = "João da Silva", true, R.drawable.man),
    UserProfile(name = "Maria da Silva", false, R.drawable.woman),
    UserProfile(name = "João da Silva", true, R.drawable.man),
    UserProfile(name = "Maria da Silva", false, R.drawable.woman),
    UserProfile(name = "João da Silva", true, R.drawable.man),
    UserProfile(name = "Maria da Silva", false, R.drawable.woman),
    UserProfile(name = "João da Silva", true, R.drawable.man),
    UserProfile(name = "Maria da Silva", false, R.drawable.woman),
    UserProfile(name = "João da Silva", true, R.drawable.man),
    UserProfile(name = "Maria da Silva", false, R.drawable.woman)
)