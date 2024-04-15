package com.mariaeduarda.firstapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.mariaeduarda.firstapp.R
import com.mariaeduarda.firstapp.databinding.FragmentAllPessoasBinding
import com.mariaeduarda.firstapp.view.adapter.PessoaAdapter
import com.mariaeduarda.firstapp.viewmodel.AllPessoasViewModel

class AllPessoasFragment : Fragment() {
    // chamar a viewmodel
    private val viewModel: AllPessoasViewModel by viewModels()


    //chamar o adapter
    private lateinit var adapter: PessoaAdapter

    // criar o binding
    private var _binding: FragmentAllPessoasBinding?= null

    private val binding: FragmentAllPessoasBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //configurar o binding
        _binding = FragmentAllPessoasBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Quando clicar em algum item da lista
        adapter = PessoaAdapter(viewModel.pessoalist.value){

        }

        // configura a recycler
        val recycler = binding.rvPessoas
        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.adapter = adapter

        //observar para adicionar um item na lista quando for adicionado
       viewModel.pessoalist.observe(viewLifecycleOwner){
           adapter.updatePessoa(it)
        }

        //Navegar para a tela de cadastro de pessoas
        binding.btnAdd.setOnClickListener{
            findNavController().navigate(R.id.pessoaFragment)
        }
        // Carregar as pessoas cadastradas
        viewModel.loadPessoas()
    }
}