package app.ma.ghe.imc.recycleecardview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import app.ma.ghe.imc.recycleecardview.DetailActivity.Companion.EXTRA_CONTACT

class MainActivity : AppCompatActivity(), ClickItemContactListener {
    private val rvlist : RecyclerView by lazy {
        findViewById(R.id.rv_list)
    }

    private val adapter = ContactAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.drawer_menu)

        initDrawer()
        bindViews()
        updateList()
    }

    private fun initDrawer(){
        val drawerLayouts = findViewById<View>(R.id.drawerLayout) as DrawerLayout
        val toolbar = findViewById<Toolbar>(R.id.toolbars)
        setSupportActionBar(toolbar)
        //ação de abrir e fechar o drawer layout
        val toggle = ActionBarDrawerToggle(this,drawerLayouts,toolbar,R.string.open_drawer,R.string.close_drawer)
        drawerLayouts.addDrawerListener(toggle)
        //iniciar a sincronização do toggle
        toggle.syncState()

    }

    private fun bindViews(){
        rvlist.adapter = adapter
        rvlist.layoutManager = LinearLayoutManager(this)
    }

    private fun updateList(){
        adapter.updateList(
            arrayListOf(
                Contact(
                    "Ghessica",
                    "(24)99216-2000",
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

    /*override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //inflando menu option
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }*/
        //função quando for clickado em um item do menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //para saber qual menu do item está sendo clickado
        return when (item.itemId) {
            //se clickar no item com id *** faça
            R.id.item_menu_1 -> {
                showToast("Menu 1")
                return true
            }

            R.id.item_menu_2 -> {
                showToast("Menu 2")
                return true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    override  fun clickItemContact(contact: Contact) {
        val intent = Intent(this,DetailActivity::class.java)
        intent.putExtra(EXTRA_CONTACT, contact)
        startActivity(intent)
    }
}
