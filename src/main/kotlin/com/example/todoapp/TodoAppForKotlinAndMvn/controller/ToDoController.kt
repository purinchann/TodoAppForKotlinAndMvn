package com.example.todoapp.TodoAppForKotlinAndMvn.controller

// Request
import com.example.todoapp.TodoAppForKotlinAndMvn.format.request.todo.CreateToDoRequestFormat
import com.example.todoapp.TodoAppForKotlinAndMvn.format.request.todo.GetToDoRequestFormat
import com.example.todoapp.TodoAppForKotlinAndMvn.format.request.todo.UpdateToDoTextRequestFormat

// Response
import com.example.todoapp.TodoAppForKotlinAndMvn.format.response.todo.CreateToDoResponseFormat
import com.example.todoapp.TodoAppForKotlinAndMvn.format.response.todo.DeleteToDoResponseFormat
import com.example.todoapp.TodoAppForKotlinAndMvn.format.response.todo.ToDoListResponseFormat
import com.example.todoapp.TodoAppForKotlinAndMvn.format.response.todo.UpdateToDoCompleteFlgResponseFormat
import com.example.todoapp.TodoAppForKotlinAndMvn.format.response.todo.UpdateToDoTextResponseFormat

// Facade
import com.example.todoapp.TodoAppForKotlinAndMvn.facade.ToDoFacade

// Library
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/todo")
class ToDoController @Autowired constructor(private val toDoFacade: ToDoFacade) {

    // query: userId
    @GetMapping
    fun getToDoList(@ModelAttribute requestFormat: GetToDoRequestFormat): ToDoListResponseFormat {
        return toDoFacade.getToDo(requestFormat.userId)
    }

    // body: userId, text
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createToDo(@RequestBody requestFormat: CreateToDoRequestFormat): CreateToDoResponseFormat {
        return toDoFacade.createToDo(requestFormat.userId, requestFormat.text)
    }

    // path: id, body: text
    @RequestMapping(value = "{id:^[0-9]+$}", method = arrayOf(RequestMethod.PATCH))
    fun updateToDoText(@PathVariable id: Int, @RequestBody requestFormat: UpdateToDoTextRequestFormat): UpdateToDoTextResponseFormat {
        return toDoFacade.updateToDoText(id, requestFormat.text)
    }

    // path: /{id}/complate
    @RequestMapping(value = "{id:^[0-9]+$}/complete", method = arrayOf(RequestMethod.PATCH))
    fun updateToDoCompleteFlg(@PathVariable id: Int): UpdateToDoCompleteFlgResponseFormat {
        return toDoFacade.updateToDoCompleteFlg(id)
    }

    // path: id
    @RequestMapping(value = "{id:^[0-9]+$}", method = arrayOf(RequestMethod.DELETE))
    fun deleteToDo(@PathVariable id: Int): DeleteToDoResponseFormat {
        return toDoFacade.deleteToDo(id)
    }
}