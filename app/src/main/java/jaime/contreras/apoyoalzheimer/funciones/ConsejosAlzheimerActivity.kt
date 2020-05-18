package jaime.contreras.apoyoalzheimer.funciones

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import jaime.contreras.apoyoalzheimer.R

class ConsejosAlzheimerActivity : Fragment() {

    override fun onCreateView(inflater : LayoutInflater, container: ViewGroup? , savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.activity_consejos_alzheimer,container,false)
    }
}
