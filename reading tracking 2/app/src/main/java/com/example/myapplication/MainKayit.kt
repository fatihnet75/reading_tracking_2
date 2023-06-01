package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.databinding.ActivityMainKayitBinding

class MainKayit : AppCompatActivity() {
    private lateinit var binding: ActivityMainKayitBinding
    private lateinit var dbHelper : DatabaseHelpers
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_kayit)
        dbHelper = DatabaseHelpers(this)
        setupBinding()
    }
    fun setupBinding() {
        binding = ActivityMainKayitBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
    fun girisDon (view: View){
        intent= Intent(applicationContext,MainActivity::class.java)
        startActivity(intent)
    }
    fun setupDatabase(){
        dbHelper = DatabaseHelpers(this)
    }
    fun addUserss(id: Int,Username:String,pasword:String){
       val users=Student(id,Username,pasword)
        dbHelper.addStudent(users)
        Toast.makeText(this,"kayıt başarılı yapılmıştır",Toast.LENGTH_LONG).show()

    }

    fun kayitOl (view: View){

        val id =+1
        val userName =binding.kayitKullaniciAdi.text.toString()
        val pasword =binding.KayitParola.text.toString()
        addUserss(id,userName,pasword)
    }
}