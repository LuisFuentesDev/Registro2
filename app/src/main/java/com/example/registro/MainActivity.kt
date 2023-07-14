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
        while (!validarApellido(apellido)){
            println("Apellido inválido, ingrese nuevamente")
            apellido = readln()
        }

        println("Ingrese la edad")
        var edad = readln().toInt()
        validadEdad(edad)
        while (!validadEdad(edad)){
            println("Edad inválida, ingrese nuevamente")
            edad = readln().toInt()
        }

        println("Ingrese el correo")
        var correo = readln()
        validarCorreo(correo)
        while (!validarCorreo(correo)){
            println("Correo inválido, ingrese nuevamente")
            correo = readln()
        }

        println("Ingrese el sistema de salud")
        var sistemaSalud = readln()
        validarSistemaSalud(sistemaSalud)
        while (!validarSistemaSalud(sistemaSalud)){
            println("Apeliido inválido, ingrese nuevamente")
            sistemaSalud = readln()
        }

        var usuario = Usuario(nombre, apellido, edad, correo, sistemaSalud)
        usuarios.add(usuario)
    }
    for (u in usuarios) {
        println(u)
    }
}

fun validarSistemaSalud(sistemaSalud: String) {

}

fun validarCorreo(correo: String) {

}

fun validadEdad(edad: Int) {

}

fun validarApellido(apellido: String) {

}

fun validarNombre(nombre: String): Boolean {
    return nombre.length in 1..20 && nombre.all { it.isLetterOrDigit() }
}

data class Usuario(
    var nombre: String,
    var apellido: String,
    var edad: Int,
    var correo: String,
    var sistemaSalud: String
)

