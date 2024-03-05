package com.mariaeduarda.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.mariaeduarda.firstapp.databinding.ActivityMainBinding
import com.mariaeduarda.firstapp.databinding.LinearBinding

class MainActivity : AppCompatActivity() {


    //:private var _bindingLinear: LinearBinding? = null
    //:private  val bindingLinear: LinearBinding get() = _bindingLinear!!
    private var _binding: ActivityMainBinding? = null
    private  val binding: ActivityMainBinding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.btnEnviar.setOnClickListener{
//            var nome  = binding.edtNome.editableText.toString()
//            var idade  = binding.edtIdade.editableText.toString()
//            var ano = 2024 - idade.toInt()
//            binding.tvNome.text = "Nome:${nome}"
//            binding.tvIdade.text = "Ano:${idade}"
//            binding.tvIdade.text = "Idade:${ano}"
        binding.btnEnviar.setOnClickteleConstrain{
            val email = binding.edtEmail.editableText.toString()
            if (email.contains("@")&& email.contains(".com")){
                binding.tvEmail.text = "Email: ${email}"
            } else {
                binding.tvEmail.text= "Email invalido"
            }
            //:if(telefone.longth==11)
            if (fone==11){
                binding.tvTelefone.text="Telefone valido"
            }else{
                binding.tvTelefone.text="telefone invalido"
            }
        }
    }
}