package com.edwinacubillos.misdeudores.ui.lista

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.edwinacubillos.misdeudores.R
import com.edwinacubillos.misdeudores.data.database.entities.Deudor
import com.edwinacubillos.misdeudores.databinding.DeudoresItemBinding

class DeudoresRVadapter(var deudoresList: ArrayList<Deudor>) :
    RecyclerView.Adapter<DeudoresRVadapter.DeudoresViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeudoresViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.deudores_item, parent, false)
        return DeudoresViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: DeudoresViewHolder, position: Int) {
        val deudor = deudoresList[position]
        holder.bindDeudor(deudor)
    }

    override fun getItemCount(): Int {
        return deudoresList.size
    }

    class DeudoresViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = DeudoresItemBinding.bind(itemView)

        fun bindDeudor(deudor: Deudor) {
            binding.nombreTextView.text = deudor.nombre
            binding.valorTextView.text = deudor.valor.toString()
        }
    }
}