package com.mariaeduarda.firstapp.service.repository

import android.content.Context
import com.mariaeduarda.firstapp.service.model.Pessoa
import com.mariaeduarda.firstapp.service.repository.local.FirstAppDataBase

class PessoaRepository(context: Context) {
    private  val  firstAppDb = FirstAppDataBase.getDataBase(context).pessoaDAO()

    suspend fun insertPessoa(pessoa:Pessoa){
        firstAppDb.insert(pessoa)
    }

    suspend fun getPessoa(id:Int): Pessoa {
      return  firstAppDb.getPessoa(id)
    }

    suspend fun updatePessoa(pessoa:Pessoa){
       return firstAppDb.update(pessoa)
    }
    suspend fun getPessoas(): List<Pessoa> {
       return firstAppDb.getAll()
    }

    suspend fun deletePessoa(id: Int){
        firstAppDb.delete(id)
    }
}