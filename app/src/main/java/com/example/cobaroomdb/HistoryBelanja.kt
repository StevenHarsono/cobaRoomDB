package com.example.cobaroomdb

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cobaroomdb.database.historyBelanjaDB

class HistoryBelanja : AppCompatActivity() {
    var DB_history = historyBelanjaDB.getDatabase(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_history_belanja)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onStart() {
        super.onStart()

        val historybelanja = DB_history.funhistoryBelanjaDao().selectAll()

        val historyBelanjaStrings = historybelanja.map { history ->
            "Item: ${history.item}\nJumlah: ${history.jumlah}\nTanggal: ${history.tanggal}"
        }.toTypedArray()

        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, historyBelanjaStrings)

        val listView = findViewById<ListView>(R.id.listView)
        listView.adapter = arrayAdapter
    }
}