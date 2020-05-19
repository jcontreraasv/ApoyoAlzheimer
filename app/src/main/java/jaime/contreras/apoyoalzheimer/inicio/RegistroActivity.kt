package jaime.contreras.apoyoalzheimer.inicio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import jaime.contreras.apoyoalzheimer.R
import kotlin.properties.Delegates

class RegistroActivity : AppCompatActivity() {

    private lateinit var nombre: EditText
    private lateinit var apellido: EditText
    private lateinit var correoET: EditText
    private lateinit var contrasenaET: EditText
    private lateinit var dbReference: DatabaseReference
    private lateinit var db: FirebaseDatabase
    private lateinit var auth: FirebaseAuth

    private var nombres by Delegates.notNull<String>()
    private var apellidos by Delegates.notNull<String>()
    private var correo by Delegates.notNull<String>()
    private var contrasena by Delegates.notNull<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        initialise()
    }

    private fun initialise() {

        nombre = findViewById(R.id.txtName)
        apellido = findViewById(R.id.txtLastName)
        correoET = findViewById(R.id.txtEmail)
        contrasenaET = findViewById(R.id.txtPassword)
        
        db = FirebaseDatabase.getInstance()

        auth = FirebaseAuth.getInstance()

        dbReference = db.reference.child("Users")
    }

    private fun createNewAccount() {

        nombres = nombre.text.toString()
        apellidos = apellido.text.toString()
        correo = correoET.text.toString()
        contrasena = contrasenaET.text.toString()

        if (!TextUtils.isEmpty(nombres) && !TextUtils.isEmpty(apellidos) && !TextUtils.isEmpty(correo) && !TextUtils.isEmpty(contrasena)) {

            auth.createUserWithEmailAndPassword(correo, contrasena).addOnCompleteListener(this) {

                    val user: FirebaseUser = auth.currentUser!!
                    verifyEmail(user);

                    val currentUserDb = dbReference.child(user.uid)
                    currentUserDb.child("firstName").setValue(nombres)
                    currentUserDb.child("lastName").setValue(apellidos)

                    updateUserInfoAndGoHome()
                Toast.makeText(this, "Registro Exitoso", Toast.LENGTH_SHORT).show()

            }.addOnFailureListener{

                    Toast.makeText(this, "Error en la autenticación.", Toast.LENGTH_SHORT).show()
                }
        }
        else {
            Toast.makeText(this, "Llene todos los campos", Toast.LENGTH_SHORT).show()
        }
    }

    fun register(view:View){
        createNewAccount()
    }

    private fun updateUserInfoAndGoHome() {
        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

    private fun verifyEmail(user: FirebaseUser) {
        user.sendEmailVerification().addOnCompleteListener(this) {
                    task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "Email " + user.getEmail(), Toast.LENGTH_SHORT).show()
                    }
                    else {
                        Toast.makeText(this, "Error al verificar el correo ", Toast.LENGTH_SHORT).show()
                    }
            }
    }
}

