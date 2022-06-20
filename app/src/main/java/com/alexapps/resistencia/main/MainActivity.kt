package com.alexapps.resistencia.main

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alexapps.resistencia.R
import com.alexapps.resistencia.databinding.ActivityMainBinding

import androidx.lifecycle.ViewModelProvider


class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding //colocado la actividad principal, paso 1

    private lateinit var viewModel: MainViewModel //creo Viewmodel

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //paso 2
        mainBinding = ActivityMainBinding.inflate(layoutInflater)//colocado la actividad principal
        val view = mainBinding.root //colocado la actividad principal,
        setContentView(view)

        //paso 3, ViewModel

        //Parte del view mode
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        // vinculo a la actividad Viewmode observadores de os live dat

        viewModel.resultadoDone.observe(this){ Resultado ->
            mainBinding.resultadoTextview.text = getString(R.string.Resultado) + Resultado.toString()
        }


        with(mainBinding){
            botonCalcular.setOnClickListener {
                val banda1 = banda1Spinner.selectedItem.toString()
                val banda2 = banda2Spinner.selectedItem.toString()
                val banda3 = banda3Spinner.selectedItem.toString()
                val porcentaje = porcentajeSpinner.selectedItem.toString()
                viewModel.calcular(banda1, banda2, banda3, porcentaje)
            }
        }

    }
}