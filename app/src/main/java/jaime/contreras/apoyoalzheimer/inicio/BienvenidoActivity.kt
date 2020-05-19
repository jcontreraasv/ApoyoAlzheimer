package jaime.contreras.apoyoalzheimer.inicio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import jaime.contreras.apoyoalzheimer.R
import jaime.contreras.apoyoalzheimer.funciones.MainMenuActivity

class BienvenidoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bienvenido)

        val background= object : Thread(){
            override fun run() {
                try{
                    Thread.sleep(5000)

                    val intent = Intent(baseContext,
                        MainMenuActivity::class.java)
                    startActivity(intent)
                }
                catch (e: Exception){
                    e.printStackTrace()
                }
            }
        }
        background.start()
    }
}
