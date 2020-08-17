package cl.desafiolatam

import ListaAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var lista: ArrayList<Ciclovia>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        setupCiclovias()
        lista_ciclovias.layoutManager = LinearLayoutManager(this)
        val listaAdapter = ListaAdapter(this)
        lista_ciclovias.adapter = listaAdapter
        listaAdapter.setupData(lista!!)

        button_filtrar.setOnClickListener{
                val listaAux: ArrayList<Ciclovia>? = ArrayList()
                lista!!.forEach {
                    when (it.comuna) {
                        "Las Condes" -> listaAux!!.add(it)
                    }
                }
                listaAdapter.setupData(listaAux!!)
            }

        button_no_filtrar.setOnClickListener{
                listaAdapter.setupData(lista!!)
            }
        buttonInverso.setOnClickListener{
            val asReversed = lista!!.reversed()
            listaAdapter.setupData(asReversed)

        }
        }

    private fun setupCiclovias() {
        val setupCiclovias = SetupCiclovias()
        lista = setupCiclovias.init()
    }
}
