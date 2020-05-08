package jaime.contreras.apoyoalzheimer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main_menu.*

class MainMenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        var intento0: Intent = Intent(this,ActivityAjustes::class.java)
        var intento1: Intent = Intent(this,MenuJuegosActivity::class.java)

        ejercicios_btn.setOnClickListener{
            startActivity(intento1)
        }

        btn_ajustes.setOnClickListener{
            startActivity(intento0)
        }
    }
}
