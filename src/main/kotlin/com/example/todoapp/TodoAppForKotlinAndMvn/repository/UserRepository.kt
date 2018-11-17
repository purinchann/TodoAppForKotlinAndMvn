package com.example.todoapp.TodoAppForKotlinAndMvn.repository

import com.example.todoapp.TodoAppForKotlinAndMvn.entity.User

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Int> {
}