package com.example.todoapp.TodoAppForKotlinAndMvn.format.response.todo

import com.example.todoapp.TodoAppForKotlinAndMvn.format.response.BaseResponseFormat

data class UpdateToDoCompleteFlgResponseFormat (
        var result: String
) : BaseResponseFormat()