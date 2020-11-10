package com.edwinacubillos.misdeudores.ui.lista

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.edwinacubillos.misdeudores.MisDeudores
import com.edwinacubillos.misdeudores.R
import com.edwinacubillos.misdeudores.data.database.entities.Deudor
import com.edwinacubillos.misdeudores.databinding.FragmentListaBinding

class ListaFragment : Fragment() {

    private lateinit var binding : FragmentListaBinding
    var listDeudores: MutableList<Deudor> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lista, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentListaBinding.bind(view)

        binding.deudoresRecyclerview.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        binding.deudoresRecyclerview.setHasFixedSize(true)


        val deudoresRVadapter = DeudoresRVadapter(listDeudores as ArrayList<Deudor>)

        binding.deudoresRecyclerview.adapter = deudoresRVadapter
        var deudorDAO = MisDeudores.database.DeudorDAO()
        listDeudores = deudorDAO.getDeudores()


        deudoresRVadapter.notifyDataSetChanged()

    }
}