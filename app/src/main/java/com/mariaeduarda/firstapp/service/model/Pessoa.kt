package com.mariaeduarda.firstapp.service.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity (tableName = "pessoa")
data class Pessoa(
    @PrimaryKey(autoGenerate = true)
    var id: Int =0,
    var name: String ="",
    var idade: Int =0

)
