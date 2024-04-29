package com.mariaeduarda.firstapp.view

import android.app.AlertDialog
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
import java.time.LocalDateTime


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

        //Carregar a pessoa caso tenha selecionado
        arguments?. let {
            viewModel.getPessoa(it.getInt("pessoaId"))
        }

        binding.btnEnviar.setOnClickListener{
            val nome = binding.edtNome.editableText.toString()
            val ano  = binding.edtAno.editableText.toString()


            if (nome!= ""&& ano !="" ){

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

                viewModel.pessoa.value?.let {

                    pessoa.id = it.id
                    viewModel.update(pessoa)

                }?: run {
                    viewModel.insert(pessoa)
                }


                viewModel.insert(pessoa)
                binding.edtNome.editableText.clear()
                binding.edtAno.editableText.clear()
                findNavController().navigateUp()
            }else{
                Toast.makeText(requireContext(),"Digite os dados", Toast.LENGTH_LONG).show()
            }

        }

        binding.btnDeletar.setOnClickListener {
            AlertDialog.Builder(requireContext())
                .setTitle("Exclusão de pessoas")
                .setMessage("você reamente deseja deletar?")
                .setPositiveButton("sim"){_,_ -> }
                .show()

            viewModel.delete(viewModel.pessoa.value?.id ?: 0)
            findNavController().navigateUp()

        }



        viewModel.pessoa.observe(viewLifecycleOwner){pessoa->
            binding.edtNome.setText(pessoa.nome)
            binding.edtAno.setText(( LocalDateTime.now().year - pessoa.idade).toString())


            if (pessoa.sexo == "Masculino"){
                binding.masculino.isChecked = true
            }else{
                binding.feminino.isChecked = true
            }
            binding.btnDeletar.visibility = View.VISIBLE

        }
    }
}