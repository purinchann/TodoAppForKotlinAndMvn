package com.example.todoapp.TodoAppForKotlinAndMvn.format.response.todo

import com.example.todoapp.TodoAppForKotlinAndMvn.format.response.BaseResponseFormat

import com.example.todoapp.TodoAppForKotlinAndMvn.entity.ToDo

data class UpdateToDoTextResponseFormat (
        var todo: ToDo
) : BaseResponseFormat()