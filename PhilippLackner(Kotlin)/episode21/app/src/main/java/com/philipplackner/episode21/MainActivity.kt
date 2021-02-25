package com.philipplackner.episode21

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var todoList= mutableListOf(
            Todo("Todo1",false),
            Todo("Todo2",true),
            Todo("Todo3",false),
            Todo("Todo4",false),
            Todo("Todo5",true),
            Todo("Todo6",false),
            Todo("Todo7",false)
        )
        val adapter=TodoAdapter(todoList)
        rvTodos.adapter=adapter
        rvTodos.layoutManager=LinearLayoutManager(this)
        btnAddTodo.setOnClickListener {
            val title=etTodo.text.toString()
            val todo=Todo(title,false)
            todoList.add(todo)
            adapter.notifyItemInserted(todoList.size-1)
        }
    }
}
