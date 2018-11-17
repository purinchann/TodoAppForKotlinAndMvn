package com.example.todoapp.TodoAppForKotlinAndMvn.format.request.todo

import com.example.todoapp.TodoAppForKotlinAndMvn.format.request.BaseRequestFormat

data class UpdateToDoTextRequestFormat (
        var text: String = ""
) : BaseRequestFormat()