package com.example.th_bai14.model

import java.io.Serializable

data class Student(
    val id: String,
    val name: String,
    val gpa: Double,
    val classOf: String
): Serializable