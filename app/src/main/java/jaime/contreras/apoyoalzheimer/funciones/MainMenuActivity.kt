package jaime.contreras.apoyoalzheimer.funciones

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import jaime.contreras.apoyoalzheimer.juegos.MenuJuegosActivity
import jaime.contreras.apoyoalzheimer.R
import kotlinx.android.synthetic.main.activity_main_menu.*

class MainMenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        var intento0: Intent = Intent(this,
            AjustesActivity::class.java)
        var intento1: Intent = Intent(this,
            MenuJuegosActivity::class.java)
        var intento3: Intent = Intent(this,
            MiUbicacionActivity::class.java)

        ejercicios_btn.setOnClickListener{
            startActivity(intento1)
        }

        btn_ajustes.setOnClickListener{
            startActivity(intento0)
        }
        
        
        
        ubicacion_btn.setOnClickListener{
            startActivity(intento3)
        }
    }
}
