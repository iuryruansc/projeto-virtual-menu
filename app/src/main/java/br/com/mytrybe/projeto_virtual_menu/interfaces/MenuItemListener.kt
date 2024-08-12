package br.com.mytrybe.projeto_virtual_menu.interfaces

import android.view.View

interface MenuItemListener {

    fun onDishClick(view: View, position: Int)

}