package com.example.todoapp.TodoAppForKotlinAndMvn.controller

// Request
import com.example.todoapp.TodoAppForKotlinAndMvn.format.request.user.CreateUserRequestFormat

// Response
import com.example.todoapp.TodoAppForKotlinAndMvn.format.response.user.UserResponseFormat
import com.example.todoapp.TodoAppForKotlinAndMvn.format.response.user.UserListResponseFormat
import com.example.todoapp.TodoAppForKotlinAndMvn.format.response.user.DeleteUserResponseFormat

// Facade
import com.example.todoapp.TodoAppForKotlinAndMvn.facade.UserFacade

// Library
import org.springframework.http.HttpStatus
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/users")
class UserController @Autowired constructor(private val userFacade: UserFacade) {

    @RequestMapping(method = arrayOf(RequestMethod.GET))
    fun getUserList(): UserListResponseFormat {
        return userFacade.getUserList()
    }

    @RequestMapping(value = "{id:^[0-9]+$}", method = arrayOf(RequestMethod.GET))
    fun getUser(@PathVariable id: Int): UserResponseFormat {
        return userFacade.getUser(id)
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    fun createUser(@RequestBody requestFormat: CreateUserRequestFormat): UserResponseFormat {
        return userFacade.createUser(requestFormat.name, requestFormat.email, requestFormat.password)
    }

    @DeleteMapping(value = "{id:^[0-9]+$}")
    fun deleteUser(@PathVariable id: Int): DeleteUserResponseFormat {
        return userFacade.deleteUser(id)
    }
}