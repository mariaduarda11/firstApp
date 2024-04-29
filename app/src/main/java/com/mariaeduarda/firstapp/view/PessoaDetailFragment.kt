package com.mariaeduarda.firstapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mariaeduarda.firstapp.R
import com.mariaeduarda.firstapp.databinding.FragmentPessoaDetailBinding
import com.mariaeduarda.firstapp.viewmodel.PessoaViewModel


class PessoaDetailFragment : Fragment() {

    //chamar a viewmodel para pegar os dados
    private val viewModel: PessoaViewModel by viewModels()

    //criar o binding para pegar os elementos da tela
    private var _binding: FragmentPessoaDetailBinding? = null

    private val binding: FragmentPessoaDetailBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //configurar o binding
        _binding = FragmentPessoaDetailBinding.inflate(inflater, container, false)
        return binding.root
    }
// chamar a função com viewCreated paraonde vamos implementar o codigo
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    // pegar i id da pessoa que foi enviado pela AllPessoasFragment
    // Setar a pessoa para ser carregada
        arguments?.let {
            viewModel.getPessoa(it.getInt("pessoaId"))
        }
    //carregar as informações da pessoa selecionada
        viewModel.pessoa.observe(viewLifecycleOwner) { pessoa ->
            binding.tvNome.text = pessoa.nome
            binding.tvIdade.text = pessoa.idade.toString() + "anos"
            binding.tvFaixa.text = pessoa.faixa_etaria
            if (pessoa.sexo == "Masculino") {

                binding.baselineM.setImageResource(R.drawable.baseline_man_24)
            } else {
                binding.baselineF .setImageResource(R.drawable.baseline_woman_24)
            }
        }
    }
}