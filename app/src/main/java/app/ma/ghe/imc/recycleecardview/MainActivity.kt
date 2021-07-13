package app.ma.ghe.imc.recycleecardview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private val rv_list : RecyclerView by lazy {
        findViewById(R.id.rv_list)
    }

    private val adapter = ContactAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bindViews()
        updateList()
    }

    private fun bindViews(){
        rv_list.adapter = adapter
        rv_list.layoutManager = LinearLayoutManager(this)
    }

    private fun updateList(){
        adapter.updateList(
            arrayListOf(
                Contact(
                    "Rafael de Assis",
                    "(24)99296-4444",
                    "img/img"
                ),
                Contact(
                    "Rafael de Assis",
                    "(24)99296-4444",
                    "img/img"
                )
            )
        )
    }

    //encapsulando o TOAST
    private fun showToast(mensagem : String){
        Toast.makeText(this,mensagem, Toast.LENGTH_SHORT).show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //inflando menu option
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }
        //função quando for clickado em um item do menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
            //para saber qual menu do item está sendo clickado
        return when (item.itemId){
            //se clickar no item com id *** faça
            R.id.item_menu_1 ->{
            showToast("Menu 1")
                return true
            }

            R.id.item_menu_2 ->{
                showToast("Menu 2")
                return true
            }

            else -> super.onOptionsItemSelected(item)
        }

    }
}