package com.example.todoapp.TodoAppForKotlinAndMvn.format.response.todo

import com.example.todoapp.TodoAppForKotlinAndMvn.format.response.BaseResponseFormat

import com.example.todoapp.TodoAppForKotlinAndMvn.entity.ToDo

data class ToDoListResponseFormat(
        val toDoList: MutableList<ToDo>
): BaseResponseFormat()