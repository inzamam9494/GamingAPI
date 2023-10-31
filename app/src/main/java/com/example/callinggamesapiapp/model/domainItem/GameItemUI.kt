package com.example.callinggamesapiapp.model.domainItem

import com.example.callinggamesapiapp.model.GamesItem

// step 7

data class GameItemUI(
    val id: Int? = null,
    val title: String? = null,
    val thumbnail: String? = null,
    val shortDescription: String? = null
)

fun GamesItem.toGameItemUI() = GameItemUI(id, title, thumbnail, shortDescription)
