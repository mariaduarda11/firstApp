package com.mariaeduarda.firstapp.view.adapter

import android.telephony.TelephonyCallback.EmergencyNumberListListener
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar.OnMenuItemClickListener
import androidx.recyclerview.widget.RecyclerView
import com.mariaeduarda.firstapp.databinding.ListItemPessoaBinding
import com.mariaeduarda.firstapp.service.model.Pessoa

class PessoaAdapter(pessoas: List<Pessoa>?, private val clickListListener: (Pessoa)-> Unit) :
RecyclerView.Adapter<PessoaAdapter.PessoaViewHolder>()

{
    private var  pessoaList: List<Pessoa> = arrayListOf()

    class PessoaViewHolder(private val binding: ListItemPessoaBinding)
        :RecyclerView.ViewHolder(binding.root){
            fun bind(pessoa: Pessoa, clickListListener: (Pessoa)-> Unit){
                binding.tvNome.text= pessoa.nome
                binding.tvIdade.text= pessoa.idade.toString()

                binding.root.setOnClickListener{
                    clickListListener(pessoa)
                }
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PessoaViewHolder {
        val listItemPessoaBinding = ListItemPessoaBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return PessoaViewHolder(listItemPessoaBinding)
    }

    override fun getItemCount(): Int {
        return pessoaList.count()
    }

    override fun onBindViewHolder(holder: PessoaViewHolder, position: Int) {
        holder.bind(pessoaList[position], clickListListener)
    }
    fun updatePessoa(list: List<Pessoa>){
        pessoaList = list
        notifyDataSetChanged()
    }
}