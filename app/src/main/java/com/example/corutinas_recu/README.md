
# Juego de Frases de Verdadero o Falso

Esta aplicación de Android está desarrollada con Jetpack Compose y ofrece un juego de preguntas de verdadero o falso
basado en una serie de frases. A continuación, se presenta una visión general de la estructura y funcionalidades
principales de la aplicación:

## Descripción General

La aplicación consiste en un juego de frases donde el jugador debe determinar si una afirmación dada es verdadera o
falsa. La interfaz de usuario está compuesta por frases aleatorias, temporizador y botones de respuesta.

## Estructura del Código

El código se organiza en varias secciones clave:

- **Variables Globales**: Contiene la información sobre frases, puntuación, temporizador y el estado del juego.
- **Función Auxiliar `aux()`**: Inicializa la lista de frases con afirmaciones verdaderas y falsas.
- **Función `Greeting()`**: Define la interfaz de usuario del juego utilizando Jetpack Compose, mostrando el
  temporizador, la puntuación y las frases
- **Función `BotonStart()`**: Define el botón de inicio del juego y su comportamiento al presionarlo.
- **Función `BotonRespuesta()`**: Define los botones de respuesta (Verdadero o Falso) y su comportamiento al
  seleccionar una respuesta.

## Frases y variables globales

Las frases ya vienen dadas y agregamos más variables a la data class `Frase` de la cual partimos. 
Así quedaría el código de las variables


```kotlin

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

```

## Codigo Boton Start y Iniciar juego

Aquí pongo el código que voy a usar para iniciar el juego sin todos los comentarios y con lo importante 
y no la colocación para el User, en esta función de iniciar el juego cambia el estado del juego a iniciado, selecciona 
una frase aleatoria y comienza la cuenta atrás. Y el botón inicia o reinicia el juego al pulsarlo.

```kotlin
fun iniciarJuego() {
    juegoIniciado = true
    fraseActual.value = frases.random() // Selecciona una frase aleatoria
    scope.launch {
        repeat(20) {
            delay(1000)
            CuentaAtras--
        }
        juegoIniciado = false
    }
}

@Composable
Button(
    onClick = {
        if (!juegoIniciado) {
            CuentaAtras = 20
            puntuacion = 0
            iniciarJuego()
        }
    }
) {
    Text("START")
}
```

## Codigo Respuesta

La función `BotonRespuesta` toma dos parámetros: `verdadero`, que indica si el botón representa una 
respuesta verdadera o falsa, y `color`, que especifica el color del botón. Al hacer clic en el botón, 
se verifica si el juego está en curso y si la respuesta seleccionada es correcta o incorrecta. 
Dependiendo de esto, se actualiza la frase actual del juego y la puntuación. El diseño del botón 
incluye bordes redondeados y un texto "V" o "F" según la respuesta representada.

```kotlin

@Composable
fun BotonRespuesta(verdadero: Boolean, color: Color) {
    Button(
        onClick = {
            if (!juegoIniciado) return@Button
            if (fraseActual.value.verdadero == verdadero) {
                fraseActual.value = frases.random() // Selecciona una nueva frase correcta
                puntuacion++
            } else {
                fraseActual.value = frases.random() // Selecciona una nueva frase incorrecta
            }
        },

        modifier = Modifier
            .padding(10.dp)
            .size(150.dp)
            .padding(8.dp), // Añadir padding para que se vean mejor los bordes redondeados
        shape = androidx.compose.foundation.shape.RoundedCornerShape(20.dp), // Agregar bordes redondeados

        colors = ButtonDefaults.buttonColors(color)
    ) {
        if (verdadero) {
            Text("V",
                color = Color.Black,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 20.sp
            )

        } else {
            Text("F",
                color = Color.Black,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 20.sp)
        }
    }
}
```



