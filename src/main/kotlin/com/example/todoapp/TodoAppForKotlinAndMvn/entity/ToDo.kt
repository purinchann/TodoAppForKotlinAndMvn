package com.example.todoapp.TodoAppForKotlinAndMvn.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import java.sql.Timestamp
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "todo")
data class ToDo (

        @Id
        @GeneratedValue
        var id: Int? = 0,

        @Column(name = "user_id", nullable = false)
        var userId: Int = 0,

        @Column(nullable = false)
        var text: String = "",

        @Column(name = "complete_flg", nullable = false)
        var completeFlg: Boolean = false,

        @Column(name = "complete_datetime", nullable = true)
        var completeDatetime: Timestamp? = null,

        @JsonIgnore
        @Column(name = "createdAt", nullable = false)
        var createdAt: Timestamp = Timestamp(0),

        @JsonIgnore
        @Column(name = "updatedAt", nullable = false)
        var updatedAt: Timestamp = Timestamp(0),

        @JsonIgnore
        @Column(name = "delete_flg", nullable = false)
        var deleteFlg: Boolean = false
)
