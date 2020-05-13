package jaime.contreras.apoyoalzheimer.inicio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import jaime.contreras.apoyoalzheimer.R

class SplashscreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

        val background= object : Thread(){

            override fun run() {
                try{
                    Thread.sleep(5000)

                    val intent = Intent(baseContext,
                        MainActivity::class.java)
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
