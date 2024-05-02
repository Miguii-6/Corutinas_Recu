
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

## Frases

Las frases ya vienen dadas y agregamos más variables a la data class `Frase` de la cual partimos.
