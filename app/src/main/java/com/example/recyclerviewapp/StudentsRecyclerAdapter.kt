package com.example.recyclerviewapp

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
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
        holder.doneButton.isChecked = student.done
    }

    fun removeStudent(position: Int) {
        DataManager.students.removeAt(position)
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textName = itemView.findViewById<TextView>(R.id.text_Name)
        val textClassName = itemView.findViewById<TextView>(R.id.text_className)
        val deleteButton = itemView.findViewById<ImageButton>(R.id.delete_button)
        val doneButton = itemView.findViewById<CheckBox>(R.id.checkBox)
        var studentPosition = 0

        init {
            itemView.setOnClickListener {
                val intent = Intent(context, AddAndCreateStudentActivity::class.java)
                intent.putExtra("STUDENT_POSITION", studentPosition)
                context.startActivity(intent)
            }
            doneButton.setOnClickListener { view ->
                DataManager.students[studentPosition].done = doneButton.isChecked
                Snackbar.make(view, "click", Snackbar.LENGTH_LONG).show()
            }
            deleteButton.setOnClickListener {view ->
                val dialogBuilder = AlertDialog.Builder(context)

                dialogBuilder.setTitle("Remove Student?")
                    .setMessage("Do you want to remove this Student?")
                    .setPositiveButton("Remove", DialogInterface.OnClickListener {
                       dialog, id ->
                        Snackbar.make(view, "Student removed", Snackbar.LENGTH_LONG).show()
                        removeStudent(studentPosition) 
                    })
                    .setNegativeButton("Cancel", DialogInterface.OnClickListener {
                        dialog, id -> dialog.cancel()
                    })

                val alert = dialogBuilder.create()
                
                alert.show()
            }
        }
    }

}