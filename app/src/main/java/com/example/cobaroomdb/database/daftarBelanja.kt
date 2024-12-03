package com.example.cobaroomdb.database

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import androidx.room.Entity

@Entity
data class daftarBelanja(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id")
    var id: Int = 0,

    @ColumnInfo(name="tanggal")
    var tanggal: String? = null,

    @ColumnInfo(name="item")
    var item: String? = null,

    @ColumnInfo(name="jumlah")
    var jumlah: String? = null,

    @ColumnInfo(name="status")
    var status: Int = 0
)
