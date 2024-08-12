package br.com.mytrybe.projeto_virtual_menu.models

data class Menu(
    val id: Int,
    val name: String,
    val photo: Int,
    val description: String,
    val price: String,
)
