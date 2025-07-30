package com.example.appwithroom.ui.userlist

import android.app.Application
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.AndroidViewModel
import com.example.appwithroom.data.User_Authentication
import com.example.appwithroom.data.UserRepository
import com.example.appwithroom.di.DatabaseProvider

class UserListViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = UserRepository(
        DatabaseProvider.getDatabase(application).userDao()
    )

    // 使用者清單資料（可由畫面直接觀察到變化）
    val users = mutableStateListOf<User_Authentication>()

    // 載入所有使用者資料
    fun loadUsers() {
        users.clear()
        users.addAll(repository.getAllUsers())
    }
    // 刪除使用者資料
    fun deleteUser(user: User_Authentication) {
        repository.deleteUser(user)
        loadUsers() // 刪除後刷新列表
    }

}
