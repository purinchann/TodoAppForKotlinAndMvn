package com.example.todoapp.TodoAppForKotlinAndMvn.format.request.todo

import com.example.todoapp.TodoAppForKotlinAndMvn.format.request.BaseRequestFormat

data class CreateToDoRequestFormat (

        var userId: Int = 0,

        var text: String = ""

): BaseRequestFormat()