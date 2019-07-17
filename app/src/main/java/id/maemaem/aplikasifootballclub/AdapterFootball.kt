package id.maemaem.aplikasifootballclub

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class AdapterFootball (private val context: Context, private val items: List<ItemFootball>, private val listener: (ItemFootball) -> Unit)
    : RecyclerView.Adapter<AdapterFootball.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ViewHolder(LayoutInflater.from(context).inflate(R.layout.adapter_football, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position], listener)
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){

        private val nama = view.findViewById<TextView>(R.id.txt_nama)
        private val gambar = view.findViewById<ImageView>(R.id.image_football)

        fun bindItem(items: ItemFootball, listener: (ItemFootball) -> Unit) {
            nama.text = items.name
            Glide.with(itemView.context).load(items.image).into(gambar)
            itemView.setOnClickListener { listener(items) }
        }
    }
}