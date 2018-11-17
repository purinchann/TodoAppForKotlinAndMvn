package com.example.todoapp.TodoAppForKotlinAndMvn.format.response.user

import com.example.todoapp.TodoAppForKotlinAndMvn.format.response.BaseResponseFormat

data class DeleteUserResponseFormat(
        var result: String
): BaseResponseFormat()