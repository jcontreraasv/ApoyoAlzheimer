package jaime.contreras.apoyoalzheimer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main_menu.*
import kotlinx.android.synthetic.main.activity_menu_juegos.*

class MenuJuegosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_juegos)

        var intento3: Intent = Intent(this,JuegoExamenActivity::class.java)

        examenBtn.setOnClickListener{
            startActivity(intento3)
        }
    }
}
