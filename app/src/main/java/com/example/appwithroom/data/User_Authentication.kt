package com.example.appwithroom.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class User_Authentication(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "Name") val firstName: String?,
    @ColumnInfo(name = "imagePath") val imagePath: String?,
    @ColumnInfo(name = "feature_vector") val featureVector: ByteArray
)


