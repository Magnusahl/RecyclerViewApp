package com.example.recyclerviewapp

object DataManager {
    val students = mutableListOf<Student>()

    init {
        createMockData()
    }

    fun createMockData() {

        var student = Student("Alessio", "MAP19", done = false)
        students.add(student)

        student = Student("Andreas", "MAP19", done = false)
        students.add(student)

        student = Student("Jansson", "MAP19", done = false)
        students.add(student)

        student = Student("Lovisa", "MAP19", done = false)
        students.add(student)

        student = Student("Magnus", "MAP19", done = false)
        students.add(student)

        student = Student("Jakob", "MAP19", done = false)
        students.add(student)
    }


}