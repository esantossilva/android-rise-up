package com.example.lessonsapp

data class Contact(val id: Int, var name: String, var email: String, var phoneNumber: String) {
    override fun toString(): String {
        return name
    }
}