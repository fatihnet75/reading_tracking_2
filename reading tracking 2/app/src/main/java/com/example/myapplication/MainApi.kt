package com.example.myapplication

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ActivityMainApiBinding

class MainApi : AppCompatActivity() {
    private val mainViewModel: MainViewModel by viewModels()
    lateinit var recyclerView: RecyclerView
    lateinit var binding: ActivityMainApiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainApiBinding.inflate(layoutInflater)
        setContentView(binding.root)
        recyclerView=findViewById(R.id.recyverView)


        var result: List<result>
        mainViewModel.post.observe(this){post->
            result = post.result
            if(!result.isNullOrEmpty()){
                binding.recyverView.layoutManager=LinearLayoutManager(this)
                val adapter = MyAdapter(this, result)
                binding.recyverView.adapter=adapter
            }
        }
    }
}
