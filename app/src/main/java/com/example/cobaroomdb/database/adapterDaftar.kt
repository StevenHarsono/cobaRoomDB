package com.example.cobaroomdb.database

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.cobaroomdb.R
import com.example.cobaroomdb.TambahDaftar
import com.google.android.material.floatingactionbutton.FloatingActionButton

class adapterDaftar (private val daftarBelanja: MutableList<daftarBelanja>):
RecyclerView.Adapter<adapterDaftar.ListViewHolder>(){

    private lateinit var onItemClickCallback : OnItemClickCallback
    class ListViewHolder (itemView: View): RecyclerView.ViewHolder(itemView) {
        var item = itemView.findViewById<TextView>(R.id.itemBarang)
        var jumlah = itemView.findViewById<TextView>(R.id.jumlah)
        var tanggal = itemView.findViewById<TextView>(R.id.textView)

        var btnEdit = itemView.findViewById<FloatingActionButton>(R.id.buttonEdit)
        var btnDelete = itemView.findViewById<FloatingActionButton>(R.id.buttonDelete)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): adapterDaftar.ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(
            R.layout.activity_adapter_daftar, parent,
            false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return daftarBelanja.size
    }

    override fun onBindViewHolder(holder: adapterDaftar.ListViewHolder, position: Int) {
        var daftar = daftarBelanja[position]

        holder.tanggal.setText(daftar.tanggal)
        holder.item.setText(daftar.item)
        holder.jumlah.setText(daftar.jumlah)

        holder.btnEdit.setOnClickListener {
            val intent = Intent(it.context, TambahDaftar::class.java)
            intent.putExtra("id", daftar.id)
            intent.putExtra("addEdit", 1)
            it.context.startActivity(intent)
        }

        holder.btnDelete.setOnClickListener {
            onItemClickCallback.delData(daftar)
        }
    }

    interface OnItemClickCallback {
        fun delData(dtBelanja: daftarBelanja)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    fun isiData(daftar: List<daftarBelanja>) {
        daftarBelanja.clear()
        daftarBelanja.addAll(daftar)
        notifyDataSetChanged()
    }
}

