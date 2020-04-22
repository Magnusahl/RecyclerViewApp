package com.example.recyclerviewapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.student_list_view.view.*

class StudentsRecyclerAdapter(private val context: Context, private val students: List<Student>) :
    RecyclerView.Adapter<StudentsRecyclerAdapter.ViewHolder>() {
    private val layoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = layoutInflater.inflate(R.layout.student_list_view, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount() = students.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val student = students[position]
        holder.textName.text = student.name
        holder.textClassName.text = student.className
        holder.studentPosition = position
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textName = itemView.findViewById<TextView>(R.id.text_Name)
        val textClassName = itemView.findViewById<TextView>(R.id.text_className)
        var studentPosition = 0

        init {
            itemView.setOnClickListener {
                val intent = Intent(context, AddAndCreateStudentActivity::class.java)
                intent.putExtra("STUDENT_POSITION", studentPosition)
                context.startActivity(intent)
            }
        }


    }

}