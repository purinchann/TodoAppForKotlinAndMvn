package com.example.todoapp.TodoAppForKotlinAndMvn.format.response.user

import com.example.todoapp.TodoAppForKotlinAndMvn.format.response.BaseResponseFormat

import com.example.todoapp.TodoAppForKotlinAndMvn.entity.User

data class UserListResponseFormat(
        var userList: MutableList<User>
): BaseResponseFormat()