package br.com.mytrybe.projeto_virtual_menu.views

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import br.com.mytrybe.projeto_virtual_menu.MenuDatabase
import br.com.mytrybe.projeto_virtual_menu.R

class MenuItemDetailActivity : AppCompatActivity() {

    private val name: TextView by lazy { findViewById(R.id.detail_name) }
    private val description: TextView by lazy { findViewById(R.id.detail_description) }
    private val price: TextView by lazy { findViewById(R.id.detail_price) }
    private val image: ImageView by lazy { findViewById(R.id.detail_image) }
    private val button: Button by lazy { findViewById(R.id.detail_back_button) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu_item_detail)

        val menuID = intent.getIntExtra("dish_name", 0)
        val dish = MenuDatabase.getDishById(menuID + 1)

        name.text = dish!!.name
        image.setImageResource(dish.photo)
        description.text = dish.description
        price.text = dish.price

        button.setOnClickListener {
            val back = Intent(baseContext, MainActivity::class.java)
            startActivity(back)
        }
    }
}