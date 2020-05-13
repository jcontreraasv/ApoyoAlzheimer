package jaime.contreras.apoyoalzheimer.juegos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import jaime.contreras.apoyoalzheimer.PRUEBAS.QuizActivity
import jaime.contreras.apoyoalzheimer.R
import kotlinx.android.synthetic.main.activity_menu_juegos.*

class MenuJuegosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_juegos)

        var intento1: Intent = Intent(this, JuegoOperacionesActivity::class.java)

        var intento3: Intent = Intent(this, JuegoExamenActivity::class.java)
        //var intento3: Intent = Intent(this, QuizActivity::class.java)

        operacionesBtn.setOnClickListener{
            startActivity(intento1)
        }

        examenBtn.setOnClickListener{
            startActivity(intento3)
        }
    }
}
