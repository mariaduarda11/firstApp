package com.mariaeduarda.firstapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.mariaeduarda.firstapp.R
import com.mariaeduarda.firstapp.databinding.FragmentCalculoBinding
import com.mariaeduarda.firstapp.service.model.Pessoa
import com.mariaeduarda.firstapp.viewmodel.PessoaViewModel


class PessoaFragment : Fragment() {
    private val viewModel: PessoaViewModel by viewModels()

    private var _binding: FragmentCalculoBinding? = null
    private  val binding: FragmentCalculoBinding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding= FragmentCalculoBinding.inflate(inflater,container,false)
        return binding.root
        return inflater.inflate(R.layout.fragment_calculo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        binding.btnEnviar.setOnClickListener{
            val nome  = binding.edtNome.editableText.toString()
            val ano  = binding.edtAno.editableText.toString()
            if (nome != "" && ano !=""){

                val idade = 2024 - ano.toInt()


                binding.tvNome.text = "Nome:${nome}"
                binding.tvIdade.text = "Ano:${ano}"
                binding.tvIdade.text = "Idade:${idade}"

                val  pessoa = Pessoa(
                    name = nome,
                    idade = idade
                )
                viewModel.insert(pessoa)
                binding.edtNome.editableText.clear()
                binding.edtAno.editableText.clear()
            }else{
                Toast.makeText(requireContext(),"Digite os dados", Toast.LENGTH_LONG).show()
            }
        }
    }
}