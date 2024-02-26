package com.example.lessonsapp

data class Question(
    val id: Int,
    val question: String,
    val optionsList: List<String>,
)