package com.example.cobaroomdb.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface historyBelanjaDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(daftar: daftarBelanja)

    @Query("SELECT * FROM daftarBelanja ORDER BY id asc")
    fun selectAll() : MutableList<daftarBelanja>

    @Query("SELECT * FROM daftarBelanja WHERE id=:isi_id")
    suspend fun getItem(isi_id: Int) : daftarBelanja
}