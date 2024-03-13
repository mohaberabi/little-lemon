package com.example.littlelemon.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MenuItemDao {
    @Query("SELECT * FROM items")
    fun getAll(): LiveData<List<MenuItemEntity>>

    @Insert
    fun insert(item: MenuItemEntity)

    @Delete
    fun delete(item: MenuItemEntity)

    @Query("SELECT (SELECT COUNT(*) FROM items) == 0")
    fun isEmpty(): Boolean
}