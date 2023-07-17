package com.example.registro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

fun main() {
    var usuarios = mutableListOf<Usuario>()
    println("Ingrese la cantidad de usuarios")
    val cantidadUsuarios = readln().toInt()
    for (i in 1..cantidadUsuarios) {
        println("Ingrese el nombre")
        var nombre = readln()
        while (!validarNombre(nombre)) {
            println("Nombre inválido, ingrese nuevamente")
            nombre = readln()
        }
        println("Ingrese el apellido")
        var apellido = readln()
        validarApellido(apellido)
        while (!validarApellido(apellido)) {
            println("Apellido inválido, ingrese nuevamente")
            apellido = readln()
        }

        println("Ingrese la edad")
        var edad = readln().toInt()
        validadEdad(edad)
        while (!validadEdad(edad)) {
            println("Edad inválida, ingrese nuevamente")
            edad = readln().toInt()
        }

        println("Ingrese el correo")
        var correo = readln()
        validarCorreo(correo)
        while (!validarCorreo(correo)) {
            println("Correo inválido, ingrese nuevamente")
            correo = readln()
        }

        println("Ingrese el sistema de salud: Fonasa o Isapre")
        var sistemaSalud = readln()
        validarSistemaSalud(sistemaSalud)
        while (!validarSistemaSalud(sistemaSalud)) {
            println("Apeliido inválido, ingrese nuevamente")
            sistemaSalud = readln()
        }

        var usuario = Usuario(nombre, apellido, edad, correo, sistemaSalud)
        usuarios.add(usuario)
    }
    for (u in usuarios.sortedBy { usuario -> usuario.edad }) {
        println(u)
    }
}

fun validarSistemaSalud(sistemaSalud: String): Boolean {
    return sistemaSalud == "Fonasa" || sistemaSalud == "Isapre" || sistemaSalud == "fonasa" || sistemaSalud == "isapre"
}

fun validarCorreo(correo: String): Boolean {
    return correo.length in 5..200 && correo.contains('@') || correo.contains('.')
}

fun validadEdad(edad: Int): Boolean {
    return edad in 0..100
}

fun validarApellido(apellido: String): Boolean {
    return apellido.length in 0..25
}

fun validarNombre(nombre: String): Boolean {
    return nombre.length in 1..20 && nombre.all { it.isLetterOrDigit() }
}

data class Usuario(
    val nombre: String,
    val apellido: String,
    val edad: Int,
    val correo: String,
    val sistemaSalud: String
)

