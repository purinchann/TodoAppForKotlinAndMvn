package com.example.todoapp.TodoAppForKotlinAndMvn.format.request.todo

import com.example.todoapp.TodoAppForKotlinAndMvn.format.request.BaseRequestFormat

data class GetToDoRequestFormat (
        var userId: Int = 0
) : BaseRequestFormat()