package com.example.callinggamesapiapp.model.domainItem

import com.example.callinggamesapiapp.model.DetailedItem

// step 15
data class DetailedItemUI(
    val id: Int? = null,
    val title: String? = null,
    val thumbnail: String? = null,
    val description: String? = null
)


fun DetailedItem.toDetailedItemUI() = DetailedItemUI(id, title, thumbnail, description)