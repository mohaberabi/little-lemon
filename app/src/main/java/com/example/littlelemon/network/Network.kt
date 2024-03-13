package com.example.littlelemon.network

import androidx.room.PrimaryKey
import com.example.littlelemon.data.MenuItemEntity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MenuItemNetwork(
    @SerialName("id")
    val id: Int,
    @SerialName("title")
    val title: String,
    @SerialName("description")
    val description: String,
    @SerialName("price")
    val price: Double,
    @SerialName("image")
    val image: String,
    @SerialName("category")
    val category: String,
) {
    fun toMenuEntity(): MenuItemEntity {
        return MenuItemEntity(
            id = id,
            title = title,
            description = description,
            price = price,
            image = image,
            category = category,
        )
    }
}