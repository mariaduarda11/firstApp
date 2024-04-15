package com.mariaeduarda.firstapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.mariaeduarda.firstapp.R
import com.mariaeduarda.firstapp.databinding.FragmentPessoaBinding
import com.mariaeduarda.firstapp.service.model.Pessoa
import com.mariaeduarda.firstapp.viewmodel.PessoaViewModel


class PessoaFragment : Fragment() {
    private val viewModel: PessoaViewModel by viewModels()

    private var _binding: FragmentPessoaBinding? = null
    private  val binding: FragmentPessoaBinding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding= FragmentPessoaBinding.inflate(inflater,container,false)
        return binding.root
        return inflater.inflate(R.layout.fragment_pessoa, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        binding.btnEnviar.setOnClickListener{
            val nome = binding.edtNome.editableText.toString()
            val ano  = binding.edtAno.editableText.toString()


            if (nome!= ""&& ano !=""){

                val idade = 2024 - ano.toInt()
                var sexo = ""
                var faixaEtaria = ""

                if(idade<= 12){
                    faixaEtaria = "criança"
                }else if (idade<= 17) {
                    faixaEtaria = "adolescente"
                }else if (idade <= 68){
                    faixaEtaria = "adulto"
                }else{
                    faixaEtaria = "idoso"
                }


                if (binding.masculino.isChecked){
                    sexo = "Masculino"
                }else{
                    sexo = "Feminino"
                }

                val  pessoa = Pessoa(
                    nome = nome,
                    sexo = sexo,
                    idade = idade,
                    faixa_etaria = faixaEtaria
                )






                viewModel.insert(pessoa)
                binding.edtNome.editableText.clear()
                binding.edtAno.editableText.clear()
                findNavController().navigateUp()
            }else{
                Toast.makeText(requireContext(),"Digite os dados", Toast.LENGTH_LONG).show()
            }

        }
    }
}