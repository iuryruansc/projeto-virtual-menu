package br.com.mytrybe.projeto_virtual_menu.views

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.mytrybe.projeto_virtual_menu.MenuDatabase
import br.com.mytrybe.projeto_virtual_menu.R
import br.com.mytrybe.projeto_virtual_menu.adapter.MenuAdapter
import br.com.mytrybe.projeto_virtual_menu.interfaces.MenuItemListener

class MainActivity : AppCompatActivity(), MenuItemListener {

    private val menuList: RecyclerView by lazy { findViewById(R.id.main_menu) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main_linear_container)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val menu = MenuDatabase.getDishes()

        val adapter = MenuAdapter(menu)
        adapter.setMenuListener(this)

        menuList.layoutManager = LinearLayoutManager(baseContext)
        menuList.adapter = adapter

    }

    override fun onDishClick(view: View, position: Int) {
        val it = Intent(baseContext, MenuItemDetailActivity::class.java)
        it.putExtra("dish_name", position)
        startActivity(it)
    }
}