package com.example.appwithroom.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

//SQL 操作封裝
@Dao
interface UserDao {
    @Query("SELECT * FROM User_Authentication")
    fun getAll(): List<User_Authentication>

    @Query("SELECT * FROM User_Authentication WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<User_Authentication>

    @Insert
    fun insertAll(vararg users: User_Authentication)

    @Delete
    fun delete(user: User_Authentication)
}