package com.example.todoapp.TodoAppForKotlinAndMvn.format.request.user

import com.example.todoapp.TodoAppForKotlinAndMvn.format.request.BaseRequestFormat

data class CreateUserRequestFormat(
        var name: String = "",
        var email: String = "",
        var password: String = ""
): BaseRequestFormat()