package com.example.appwithroom.ui.theme.userinput

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.appwithroom.data.UserRepository
import com.example.appwithroom.data.User_Authentication
import com.example.appwithroom.di.DatabaseProvider
import java.util.*

class UserInputViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = UserRepository(
        DatabaseProvider.getDatabase(application).userDao()
    )
    //新增新使用者，並聯動資料庫
    fun addUser(name: String, imagePath: String, featureVector: ByteArray): User_Authentication {
        val user = User_Authentication(
            uid = UUID.randomUUID().hashCode(),
            firstName = name,
            imagePath = imagePath,
            featureVector = featureVector
        )
        repository.insertUser(user)
        return user
    }
}