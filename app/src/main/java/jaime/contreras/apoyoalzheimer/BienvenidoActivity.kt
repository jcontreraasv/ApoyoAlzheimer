package jaime.contreras.apoyoalzheimer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_bienvenido.*

class BienvenidoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bienvenido)

        val bundle= intent.extras

        if(bundle!=null){
            val nombre=bundle.getString("name")
            val correo=bundle.getString("email")

            tv_nombre.setText(nombre)
            tv_email.setText(correo)
        }

/*
        val background= object : Thread(){
            override fun run() {
                try{
                    Thread.sleep(5000)

                    val intent = Intent(baseContext,MainMenuActivity::class.java)
                    startActivity(intent)
                }
                catch (e: Exception){
                    e.printStackTrace()
                }
            }
        }
        background.start()

 */
    }
}
