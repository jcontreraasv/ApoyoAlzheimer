package jaime.contreras.apoyoalzheimer.juegos

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import jaime.contreras.apoyoalzheimer.R

class JuegoColoresActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_juego_colores)

        val dialog= AlertDialog.Builder(this)
        val dialogView=layoutInflater.inflate(R.layout.activity_juego_colores_dialog,null)

        dialog.setView(dialogView)
        dialog.setCancelable(false)
        dialog.setPositiveButton("Ok",{ dialogInterface: DialogInterface, i: Int -> })
        dialog.show()
    }
}
