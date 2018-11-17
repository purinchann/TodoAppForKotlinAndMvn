package com.example.todoapp.TodoAppForKotlinAndMvn.facade

import com.example.todoapp.TodoAppForKotlinAndMvn.entity.ToDo

import com.example.todoapp.TodoAppForKotlinAndMvn.repository.ToDoRepository
import com.example.todoapp.TodoAppForKotlinAndMvn.repository.UserRepository

import com.example.todoapp.TodoAppForKotlinAndMvn.format.response.todo.CreateToDoResponseFormat
import com.example.todoapp.TodoAppForKotlinAndMvn.format.response.todo.DeleteToDoResponseFormat
import com.example.todoapp.TodoAppForKotlinAndMvn.format.response.todo.ToDoListResponseFormat
import com.example.todoapp.TodoAppForKotlinAndMvn.format.response.todo.UpdateToDoCompleteFlgResponseFormat
import com.example.todoapp.TodoAppForKotlinAndMvn.format.response.todo.UpdateToDoTextResponseFormat

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ToDoFacade @Autowired constructor(private val userRepository: UserRepository,
                                        private val toDoRepository: ToDoRepository) {

    fun getToDo(userId: Int): ToDoListResponseFormat {

        var todoList: MutableList<ToDo> = toDoRepository.findByUserId(userId)
        return ToDoListResponseFormat(todoList)
    }

    fun createToDo(userId: Int, text: String): CreateToDoResponseFormat {
        var t: ToDo = ToDo()
        t.userId = userId
        t.text = text
        var createdToDo: ToDo = toDoRepository.save(t)
        return CreateToDoResponseFormat(createdToDo)
    }

    fun updateToDoText(id: Int, text: String): UpdateToDoTextResponseFormat {

        toDoRepository.updateTextById(id, text)

        var todo: ToDo = toDoRepository.findOneById(id)
        return UpdateToDoTextResponseFormat(todo)
    }

    fun updateToDoCompleteFlg(id: Int): UpdateToDoCompleteFlgResponseFormat {
        toDoRepository.updateCompleteFlgById(id)
        return UpdateToDoCompleteFlgResponseFormat("OK")
    }

    fun deleteToDo(id: Int): DeleteToDoResponseFormat {
        var t: ToDo = ToDo()
        t.id = id
        toDoRepository.delete(t)
        return DeleteToDoResponseFormat("OK")
    }
}