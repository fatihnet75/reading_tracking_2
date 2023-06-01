package com.example.myapplication

import android.content.Context
import android.text.util.Linkify
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import java.util.concurrent.TimeoutException

class MyAdapter(private val context: Context, private val data: List<result>) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    // ViewHolder sınıfı, her bir öğenin görünümünü temsil eder
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val resim: ImageView = view.findViewById(R.id.kitapResmi)
        val baslik: TextView = view.findViewById(R.id.kitapBaslik)
        val fiyat: TextView = view.findViewById(R.id.fiyat)
        val yazar:TextView = view.findViewById(R.id.yazar)
        val yayin: TextView = view.findViewById(R.id.yayin)
        val url: TextView = view.findViewById(R.id.url)
    }

    // Yeni bir ViewHolder oluşturmak için kullanılır
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_page, parent, false)
        return ViewHolder(itemView)
    }

    // ViewHolder'ı belirli bir konuma bağlar
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.url.autoLinkMask = Linkify.WEB_URLS
        Glide.with(context)
            .load(item.image)
            .into(holder.resim);
        holder.baslik.text = "BAŞLIK: "+item.title
        holder.yayin.text = "YAYIN:"+item.yayın
        holder.yazar.text = "YAZAR:"+item.yazar
        holder.fiyat.text = "FİYAT:"+item.fiyat
        holder.url.text = item.url
    }

    // Veri kümesinin boyutunu döndürür
    override fun getItemCount(): Int {
        return data.size
    }
}
