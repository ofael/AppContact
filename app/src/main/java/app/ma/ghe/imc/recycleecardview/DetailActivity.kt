package app.ma.ghe.imc.recycleecardview

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity: AppCompatActivity() {
    private var contact : Contact? = null
    override fun onCreate(saveInstanceState: Bundle?) {
        super.onCreate(saveInstanceState)
        setContentView(R.layout.contact_detail)

        initToolbar()
        getExtras()
        bindViews()
    }

    private fun initToolbar(){
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbars)
        setSupportActionBar(toolbar)
        //metodo para exibir o botão voltar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun getExtras(){
        contact = intent.getParcelableExtra(EXTRA_CONTACT)
    }
//transferindo os dados dos contatos para a tela de detalhes
    private fun bindViews(){
        findViewById<TextView>(R.id.nomeContato).text = contact?.nome
        findViewById<TextView>(R.id.numberContact).text = contact?.fone
    }

    companion object{
        const val EXTRA_CONTACT : String = "EXTRA_CONTACT"
    }
//aplicando click no botão voltar
    override fun onSupportNavigateUp() : Boolean {
        finish()
        return true
    }
}