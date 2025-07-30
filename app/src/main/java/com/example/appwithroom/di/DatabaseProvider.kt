package com.example.appwithroom.di

import android.content.Context
import androidx.room.Room
import com.example.appwithroom.data.AppDatabase

object DatabaseProvider {
    private var INSTANCE: AppDatabase? = null

    fun getDatabase(context: Context): AppDatabase {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "user-database"
            ).allowMainThreadQueries() // 測試用，可改為用 coroutine 處理
                .build()
        }
        return INSTANCE!!
    }
}