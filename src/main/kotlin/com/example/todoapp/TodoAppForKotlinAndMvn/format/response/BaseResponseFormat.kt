package com.example.todoapp.TodoAppForKotlinAndMvn.format.response

import java.io.Serializable
import java.util.Date

abstract class BaseResponseFormat(
        var responseDatetime: Date = Date()
) : Serializable