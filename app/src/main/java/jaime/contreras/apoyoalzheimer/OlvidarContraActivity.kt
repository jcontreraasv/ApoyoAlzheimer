package jaime.contreras.apoyoalzheimer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class OlvidarContraActivity : AppCompatActivity() {

    private lateinit var txtEmail:EditText
    private lateinit var auth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_olvidar_contra)

        txtEmail=findViewById(R.id.txtName)
        auth=FirebaseAuth.getInstance()
    }

    fun botonSend(view:View){
        val email= txtEmail.text.toString()

        if (!TextUtils.isEmpty(email)) {
            auth.sendPasswordResetEmail(email).addOnCompleteListener(this) {
                    task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "Verifica tu correo.", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this,MainActivity::class.java))
                }
                else {
                    Toast.makeText(this, "No se encontró el usuario con este correo", Toast.LENGTH_SHORT).show()
                }
            }
        }
        else {
            Toast.makeText(this, "Agregue el correo", Toast.LENGTH_SHORT).show()
        }
    }
}
