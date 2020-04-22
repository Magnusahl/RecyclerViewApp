package com.example.recyclerviewapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.studentsList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = StudentsRecyclerAdapter(this, DataManager.students)

        val fab = findViewById<View>(R.id.floatingActionButton2)
        fab.setOnClickListener { view ->
            val intent = Intent(this, AddAndCreateStudentActivity::class.java)
            startActivity(intent)
        }
    }
}
