package com.example.todoapp.TodoAppForKotlinAndMvn.facade

import com.example.todoapp.TodoAppForKotlinAndMvn.entity.User

import com.example.todoapp.TodoAppForKotlinAndMvn.repository.UserRepository

import com.example.todoapp.TodoAppForKotlinAndMvn.format.response.user.DeleteUserResponseFormat
import com.example.todoapp.TodoAppForKotlinAndMvn.format.response.user.UserListResponseFormat
import com.example.todoapp.TodoAppForKotlinAndMvn.format.response.user.UserResponseFormat

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserFacade @Autowired constructor(private val repository: UserRepository) {

    fun getUser(id: Int): UserResponseFormat {
        var user = repository.findById(id)
        if (user.isPresent)
            return UserResponseFormat(User())
            else
            return UserResponseFormat(user.get())
    }

    fun getUserList(): UserListResponseFormat {
        var userList = repository.findAll()
        var _userList = userList.filterNotNull().toMutableList()
        return UserListResponseFormat(_userList)
    }

    fun createUser(name: String, email: String, password: String): UserResponseFormat {
        var t: User = User()
        t.name = name
        t.email = email
        t.password = password
        var user: User = repository.save(t)
        return UserResponseFormat(user)
    }

    fun deleteUser(id: Int): DeleteUserResponseFormat {
        var t: User = User()
        t.id = id
        repository.delete(t)
        return DeleteUserResponseFormat("OK")
    }
}