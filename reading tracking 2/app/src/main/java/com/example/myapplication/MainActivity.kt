package com.example.myapplication
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.myapplication.databinding.ActivityMainBinding
import android.widget.ArrayAdapter
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var dbHelper: DatabaseHelpers
    private lateinit var userListAdapter: ArrayAdapter<String>
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        dbHelper = DatabaseHelpers(this)
        userListAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1)
    }

    fun Giris(view: View) {
        val isim = binding.GirisKullaniciAdi?.text.toString()
        val sifre = binding.GirisParola?.text.toString()

        val users = dbHelper.getAllStudents()
        var isUserFound = false

        users.forEach { user ->
            if (user.userName == isim && user.password == sifre) {
                isUserFound = true
                val sharedPreferences = this.getSharedPreferences("giris", MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                editor.putString("user", isim)
                editor.putString("password", sifre)
                editor.apply()

                val intent = Intent(applicationContext, MainGiris::class.java)
                startActivity(intent)
            }
        }

        if (!isUserFound) {
            Toast.makeText(this, "Kullanıcı adı veya parola yanlış", Toast.LENGTH_SHORT).show()
        }
    }

    fun kayıt(view: View) {
        val intent = Intent(applicationContext, MainKayit::class.java)
        startActivity(intent)
    }
}