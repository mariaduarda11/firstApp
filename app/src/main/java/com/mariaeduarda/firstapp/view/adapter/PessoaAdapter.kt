package com.mariaeduarda.firstapp.view.adapter

import android.telephony.TelephonyCallback.EmergencyNumberListListener
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar.OnMenuItemClickListener
import androidx.recyclerview.widget.RecyclerView
import com.mariaeduarda.firstapp.R
import com.mariaeduarda.firstapp.databinding.ListItemPessoaBinding
import com.mariaeduarda.firstapp.service.model.Pessoa

class PessoaAdapter(pessoas: List<Pessoa>?, private val clickListListener: (Pessoa)-> Unit) :
RecyclerView.Adapter<PessoaAdapter.PessoaViewHolder>() {
    //criar uma lista vazia de pessoas
    private var  pessoaList: List<Pessoa> = arrayListOf()

    class PessoaViewHolder(private val binding: ListItemPessoaBinding)
        :RecyclerView.ViewHolder(binding.root){

            //carrega as informações da pessoa na lista
            fun bind(pessoa: Pessoa, clickListListener: (Pessoa)-> Unit){
                binding.tvNome.text= pessoa.nome
                binding.tvIdade.text= pessoa.idade.toString() + " anos"
                binding.tvFaixa.text= pessoa.faixa_etaria

                if (pessoa.sexo == "Masculino"){
                    binding.imgMan.visibility= View.VISIBLE
                    binding.imgWoman.visibility= View.GONE
                }else{
                    binding.imgMan.visibility= View.GONE
                    binding.imgWoman.visibility= View.VISIBLE
                }
//meytodop 2
//                if (pessoa.sexo == "Masculino"){
//                    binding.imgMan.setImageResource(R.drawable.baseline_man_24)
//                    binding.imgWoman.setImageResource(R.drawable.baseline_woman_24)
//                }

                //configura o click de algum item da lista
                binding.root.setOnClickListener{
                    clickListListener(pessoa)
                }
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PessoaViewHolder {
        //configura o binding da lista
        val listItemPessoaBinding = ListItemPessoaBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return PessoaViewHolder(listItemPessoaBinding)
    }

    override fun getItemCount(): Int {
        return pessoaList.count()
    }

    override fun onBindViewHolder(holder: PessoaViewHolder, position: Int) {
        holder.bind(pessoaList[position], clickListListener)
    }
    //carrega a lista de pessoas para serem exibidas
    fun updatePessoa(list: List<Pessoa>){
        pessoaList = list
        notifyDataSetChanged()
    }
}