package com.example.todoapp.TodoAppForKotlinAndMvn

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping

@RestController
class HelloController {

    @RequestMapping("/")
    fun Hello(): String {
        return "Hello World"
    }
}