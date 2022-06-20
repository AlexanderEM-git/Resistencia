package com.alexapps.resistencia.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData


class MainViewModel: ViewModel() {

    //tipo de dato que puede ser observado por fuera de la actividad afuera
    private val Resultado: MutableLiveData<String> = MutableLiveData()
    val resultadoDone: LiveData<String> = Resultado

    //funciones para trabajar

    fun calcular(banda1: String, banda2: String, banda3: String, porcentaje: String) {

        var valor = ""

        when (banda1) {
            "Marron" -> valor = "1"
            "Rojo" -> valor = "2"
            "Naranja" -> valor = "3"
            "Amarillo" -> valor = "4"
            "Verde" -> valor = "5"
            "Azul" -> valor = "6"
            "Violeta" -> valor = "7"
            "Gris" -> valor = "8"
            "Blanco" -> valor = "9"
        }
        when (banda2) {
            "Negro" -> valor += "0"
            "Marron" -> valor += "1"
            "Rojo" -> valor += "2"
            "Naranja" -> valor += "3"
            "Amarillo" -> valor += "4"
            "Verde" -> valor += "5"
            "Azul" -> valor += "6"
            "Violeta" -> valor += "7"
            "Gris" -> valor += "8"
            "Blanco" -> valor += "9"
        }

        if ((banda3 == "Verde") || banda3 == "Gris" || banda3 == "Oro" || (banda3 == "Rojo")) {
            var aux = valor.toFloat()
            val i = aux / 10
            valor = i.toString()
            when (banda3) {
                "Rojo" -> valor += "kΩ"
                "Verde" -> valor += "MΩ"
                "Gris" -> valor += "GΩ"
                "Oro" -> valor += "Ω"
            }

        } else {
            when (banda3) {
                "Negro" -> valor += "Ω"
                "Marron" -> valor += "0Ω"
                "Naranja" -> valor += "kΩ"
                "Amarillo" -> valor += "0kΩ"
                "Azul" -> valor += "MΩ"
                "Violeta" -> valor += "0MΩ"
                "Blanco" -> valor += "GΩ"
                "Plata" -> valor += "0.${valor}Ω"

            }
        }
        when (porcentaje) {
            "Marron" -> valor += " " + "±1%"
            "Rojo" -> valor += " " + "±2%"
            "Verde" -> valor += " " + "±0.5%"
            "Azul" -> valor += " " + "±0.25%"
            "Violeta" -> valor += " " + "±0.1%"
            "Gris" -> valor += " " + "±0.01%"
            "Oro" -> valor += " " + "±5%"
            "Plata" -> valor += " " + "±10%"
        }

        Resultado.value = valor
    }

}