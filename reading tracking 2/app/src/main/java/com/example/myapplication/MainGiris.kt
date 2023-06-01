package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.myapplication.databinding.ActivityMainGirisBinding

class MainGiris : AppCompatActivity() {

    private lateinit var binding: ActivityMainGirisBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_giris)
        setupBinding()
        val sharedPreferences = getSharedPreferences("giris", MODE_PRIVATE)
        val isim =sharedPreferences.getString("user","")
        val sifre=sharedPreferences.getString("pasword","")
        binding.textView.text="Kullanıcı adınız : "+isim
        binding.textView4.text="Şifreniz: "+ sifre
    }
    fun setupBinding() {
        binding = ActivityMainGirisBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
    fun KayıtliKullaniciler (view: View){
        intent= Intent(applicationContext,MainSql::class.java)
        startActivity(intent)
    }
    fun Devam (view: View){
        intent= Intent(applicationContext,MainApi::class.java)
        startActivity(intent)
    }
}