package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainSqlBinding

class MainSql : AppCompatActivity() {
    private lateinit var binding: ActivityMainSqlBinding
    private lateinit var dbHelper: DatabaseHelpers
    private lateinit var userListAdapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainSqlBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dbHelper = DatabaseHelpers(this)
        userListAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1)
        binding.textsql.adapter = userListAdapter

        getAllUsers()
    }

    fun geridonus(view: View) {
        val intent = Intent(applicationContext, MainGiris::class.java)
        startActivity(intent)
    }

    fun getAllUsers() {
        val users = dbHelper.getAllStudents()
        val userList = users.map { user ->
            "Kullanıcı id: ${user.id}, kullanıcı adı: ${user.userName}, kullanıcı parola: ${user.password}\n"
        }
        userListAdapter.clear()
        userListAdapter.addAll(userList)
    }
}