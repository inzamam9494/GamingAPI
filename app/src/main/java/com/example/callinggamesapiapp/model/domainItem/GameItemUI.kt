package com.example.callinggamesapiapp.model.domainItem

import com.example.callinggamesapiapp.model.GamesItem

// step 7

data class GameItemUI(
    val id: Int?,
    val title: String?,
    val thumbnail: String?,
    val shortDescription: String?
)

fun GamesItem.toGameItemUI() = GameItemUI(id, title, thumbnail, shortDescription)
