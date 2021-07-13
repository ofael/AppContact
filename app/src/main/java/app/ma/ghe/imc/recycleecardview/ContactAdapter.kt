package app.ma.ghe.imc.recycleecardview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter (var listener : ClickItemContactListener):
    RecyclerView.Adapter<ContactAdapter.ContactAdapterViewHolder>() {
//lista de contato<modelo da class>
    private val list : MutableList<Contact> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactAdapterViewHolder {
     //responsavel pelo layout de cada card
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_item, parent, false)
        return ContactAdapterViewHolder(view,list,listener)
    }
//metodo que é passado a cada item do rycleview
    override fun onBindViewHolder(holder: ContactAdapterViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        //pede o tamanho da lista
        return list.size
    }

    fun updateList(list : List<Contact>){
        //limpar a lista
        this.list.clear()
        //apos limpar, popular a lista
        this.list.addAll(list)
        //notifica adapter que a lista foi modificada
        notifyDataSetChanged()
    }
//responsavel por gerenciar cada item
    class ContactAdapterViewHolder(itemView : View, var list : List<Contact>, var listener: ClickItemContactListener) :
        RecyclerView.ViewHolder(itemView){

    private val tvName : TextView = itemView.findViewById(R.id.tv_nome)
    private val tvFone : TextView = itemView.findViewById(R.id.tv_fone)
    private val ivFoto : ImageView = itemView.findViewById(R.id.iv_foto)

    init {
        itemView.setOnClickListener{
            listener.clickItemContact(list[adapterPosition])
        }
    }

    fun bind(contact: Contact){
            tvName.text = contact.nome
            tvFone.text = contact.fone
        }
}
}