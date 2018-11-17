package com.example.todoapp.TodoAppForKotlinAndMvn.format.response.todo

import com.example.todoapp.TodoAppForKotlinAndMvn.format.response.BaseResponseFormat

data class DeleteToDoResponseFormat (
        var result: String
) : BaseResponseFormat()