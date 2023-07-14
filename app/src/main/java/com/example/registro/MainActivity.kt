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
        println("Ingrese la edad")
        var edad = readln().toInt()
        println("Ingrese el correo")
        var correo = readln()
        println("Ingrese el sistema de salud")
        var sistemaSalud = readln()

        var usuario = Usuario(nombre, apellido, edad, correo, sistemaSalud)
        usuarios.add(usuario)
    }
    for (u in usuarios) {
        println(u)
    }
}

fun validarNombre(nombre: String): Boolean {
    return nombre.length in 1..20
}

data class Usuario(
    var nombre: String,
    var apellido: String,
    var edad: Int,
    var correo: String,
    var sistemaSalud: String
)

