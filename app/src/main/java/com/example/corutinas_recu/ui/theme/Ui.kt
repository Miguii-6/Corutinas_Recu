package com.example.corutinas_recu.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

/**
 * Variables globales
 */
// Para crear los objetos de las frases
data class Frase(var texto: String, var verdadero: Boolean)
// Lista para almacenar las frases
var frases: MutableList<Frase> = mutableListOf()
// La frase actual
var fraseActual: MutableState<Frase> = mutableStateOf(Frase("-", true))
var CuentaAtras by mutableStateOf(20)
var puntuacion by mutableStateOf(0)
var juegoIniciado by mutableStateOf(false)

/**
 * Función auxiliar con las frases verdaderas y falsas
 */
@Composable
fun aux() {
    // Introducir frases en la lista
    frases.add(Frase("el torneo de rugby cinco naciones, ahora es seis naciones",true))
    frases.add(Frase("en el cielo hay cinco estrellas",false))
    frases.add(Frase("el dia cinco de diciembre del 2023 es martes",true))
    frases.add(Frase("cinco más cinco son diez",true))
    frases.add(Frase("dos mas dos son cinco",false))
    frases.add(Frase("los elefantes tienen cinco patas",false))
    frases.add(Frase("las estaciones climáticas son cinco",false))
    frases.add(Frase("tenemos cinco dedos los humanos",true))
    frases.add(Frase("cinco días tiene la semana sin el Domingo y el Sábado",true))
    frases.add(Frase("una gallina pesa menos que cinco toneladas",true))
}
