package br.com.mytrybe.projeto_virtual_menu.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import br.com.mytrybe.projeto_virtual_menu.R
import br.com.mytrybe.projeto_virtual_menu.interfaces.MenuItemListener
import br.com.mytrybe.projeto_virtual_menu.models.Menu


class MenuAdapter(private val menu: List<Menu>):Adapter<MenuAdapter.MenuViewHolder>() {

    private var menuListener: MenuItemListener? = null

    fun setMenuListener(listener: MenuItemListener) {
        this.menuListener = listener
    }


    class MenuViewHolder(view: View, menuItemListener: MenuItemListener?): ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.item_menu_name)
        val image: ImageView = view.findViewById(R.id.item_menu_image)

        init {
            view.setOnClickListener {
                menuItemListener?.onDishClick(view, adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_menu_layout, parent, false)
        return MenuViewHolder(view, menuListener)
    }

    override fun getItemCount(): Int = menu.size

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.name.text = menu[position].name
        holder.image.setImageResource(menu[position].photo)
    }

}