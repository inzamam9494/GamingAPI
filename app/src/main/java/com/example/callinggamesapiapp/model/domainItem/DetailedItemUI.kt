package com.example.callinggamesapiapp.model.domainItem

import com.example.callinggamesapiapp.model.DetailedItem

// step 15
data class DetailedItemUI(
    val id: Int,
    val title: String,
    val thumbnail: String,
    val description: String
)


fun DetailedItem.toDetailedItemUI() = DetailedItemUI(id, title, thumbnail, description)