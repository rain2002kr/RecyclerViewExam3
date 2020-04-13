package com.example.recyclerviewexam3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.stream.Collectors.toList

class MainActivity : AppCompatActivity() {
    val listData = (0..100).toList().shuffled()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val adapter = DataAdapter(listData,R.layout.item_model)
        adapter.onItemSelectedListener = {
            println("선택된 id : $it")
        }

        intlist.adapter = adapter
        intlist.layoutManager = LinearLayoutManager(this,RecyclerView.VERTICAL,false)

    }
}
