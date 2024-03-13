package com.example.littlelemon.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "items")
data class MenuItemEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val description: String,
    val price: Double,
    val image: String,
    val category: String,
)