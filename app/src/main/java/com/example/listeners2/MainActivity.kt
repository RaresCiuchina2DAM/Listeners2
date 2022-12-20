package com.example.listeners2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import com.example.listeners2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //el boton debe estar desactivado hasya que se haya introducido algun caracter en los dos edittext
        binding.btn.isEnabled = false

        //se activa el boton cuando se ingresa un caracter en los dos edittext
        binding.edittext1.addTextChangedListener {
            if (binding.edittext1.text.toString().isNotEmpty() && binding.edittext2.text.toString().isNotEmpty()) {
                binding.btn.isEnabled = true
            }
        }
        binding.edittext2.addTextChangedListener {
            if (binding.edittext1.text.toString().isNotEmpty() && binding.edittext2.text.toString().isNotEmpty()) {
                binding.btn.isEnabled = true
            }
        }
        //mostrar el tag de donde este el foco en el textview
        binding.edittext1.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                binding.textview.text = binding.edittext1.tag.toString()
            }
        }
        binding.edittext2.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                binding.textview.text = binding.edittext2.tag.toString()
            }
        }

        //se le añade el texto del edittext1 al edittext2
        binding.btn.setOnClickListener {
            binding.edittext1.text.append(binding.edittext2.text)
            binding.edittext2.text.clear()
            binding.btn.isEnabled = false
        }




    }
}