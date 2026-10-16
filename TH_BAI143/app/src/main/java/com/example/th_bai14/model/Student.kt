package com.example.th_bai14.model

import java.io.Serializable

data class Student(
    val id: String,
    val name: String,
    var gpa: Double,
    val classOf: String
): Serializable