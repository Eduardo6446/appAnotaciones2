package com.example.appanotaciones2.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.appanotaciones2.databinding.ActivityMainBinding
import com.example.appanotaciones2.viewmodel.TareasViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val tareasViewModel: TareasViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        tareasViewModel.tareasModel.observe(this, Observer { currentTarea ->
            binding.tvPrueba1.text = currentTarea.tarea
            binding.tvPrueba2.text = currentTarea.Finalizado.toString()
        })

        binding.btnAgregar.setOnClickListener { tareasViewModel.getTareas() }

    }


}