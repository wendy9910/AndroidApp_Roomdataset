package com.example.appwithroom.data

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [User_Authentication::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}