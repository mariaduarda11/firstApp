package com.mariaeduarda.firstapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.mariaeduarda.firstapp.R
import com.mariaeduarda.firstapp.databinding.ActivityMainBinding
import com.mariaeduarda.firstapp.databinding.FragmentCalculoBinding


class CalculoFragment : Fragment() {
    // TODO: Rename and change types of parameters
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
            var nome  = binding.edtNome.editableText.toString()
           var idade  = binding.edtAno.editableText.toString()
           var ano = 2024 - idade.toInt()


           binding.tvNome.text = "Nome:${nome}"
            binding.tvIdade.text = "Ano:${idade}"
            binding.tvIdade.text = "Idade:${ano}"
        }
    }


    
}