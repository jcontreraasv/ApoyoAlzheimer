package jaime.contreras.apoyoalzheimer.inicio

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import jaime.contreras.apoyoalzheimer.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.properties.Delegates


class MainActivity : AppCompatActivity() {

    private var correo by Delegates.notNull<String>()
    private var contrasena by Delegates.notNull<String>()
    private lateinit var campoTextoCorreo: EditText
    private lateinit var campoTextoContrasena: EditText

    val RC_SIGN_IN=123
    lateinit var mGoogleSignInClient: GoogleSignInClient

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initialise()

        // Configure sign-in to request the user's ID, email address, and basic
        // profile. ID and basic profile are included in DEFAULT_SIGN_IN.

        // Configure sign-in to request the user's ID, email address, and basic
        // profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build()

        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        google_boton.setOnClickListener{
            val signInIntent = mGoogleSignInClient.signInIntent
            startActivityForResult(signInIntent, RC_SIGN_IN)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            val task =
                GoogleSignIn.getSignedInAccountFromIntent(data)
            handleSignInResult(task)
        }
    }

    private fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
        try {
            val account =
                completedTask.getResult(ApiException::class.java)

            // Signed in successfully, show authenticated UI.
            updateUI(account)
        } catch (e: ApiException) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            //Log.w(FragmentActivity.TAG, "signInResult:failed code=" + e.statusCode)
            updateUI(null)
        }
    }

    private fun updateUI(account: GoogleSignInAccount?) {
        if (account!=null){
            val intent= Intent(this, BienvenidoActivity::class.java)

            startActivity(intent)
        }
    }

    private fun initialise() {

        campoTextoCorreo = findViewById(R.id.etEmail)
        campoTextoContrasena = findViewById(R.id.etPassword)
        mAuth = FirebaseAuth.getInstance()
    }

    private fun loginUser() {

        correo = campoTextoCorreo.text.toString()
        contrasena = campoTextoContrasena.text.toString()

        if (!TextUtils.isEmpty(correo) && !TextUtils.isEmpty(contrasena)) {

            mAuth.signInWithEmailAndPassword(correo, contrasena).addOnCompleteListener(this) {
                    task ->
                    if (task.isSuccessful) {
                        goHome()
                    }
                    else {
                        Toast.makeText(this, "Fallo de inicio de sesión.", Toast.LENGTH_SHORT).show()
                    }
                }
        }
        else {
            Toast.makeText(this, "Campos vacios.", Toast.LENGTH_SHORT).show()
        }
    }


    private fun goHome() {

        val intent = Intent(this, BienvenidoActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)

        startActivity(intent)
    }

    fun iniciosesion(view:View) {
        loginUser()
    }

    fun olvidarContra(view:View) {
        startActivity(Intent(this, OlvidarContraActivity::class.java))
    }

    //
    fun registrar(view:View) {
        startActivity(Intent(this, RegistroActivity::class.java))
    }
}

