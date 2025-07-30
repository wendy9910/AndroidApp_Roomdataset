package com.example.appwithroom.data

class UserRepository(private val userDao: UserDao) {
    fun getAllUsers(): List<User_Authentication> = userDao.getAll()
    fun insertUser(user: User_Authentication) = userDao.insertAll(user)
    fun deleteUser(user: User_Authentication) = userDao.delete(user)
}
