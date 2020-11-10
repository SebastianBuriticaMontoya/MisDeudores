package com.edwinacubillos.misdeudores.ui.buscar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.edwinacubillos.misdeudores.MisDeudores
import com.edwinacubillos.misdeudores.R
import com.edwinacubillos.misdeudores.data.database.dao.DeudorDAO
import com.edwinacubillos.misdeudores.databinding.FragmentBuscarBinding

class BuscarFragment : Fragment() {

    private lateinit var binding : FragmentBuscarBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_buscar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
      binding = FragmentBuscarBinding.bind(view)
        binding.botonBuscar.setOnClickListener{
            val nombre = binding.nombreBuscarTextView.text.toString()
            val deudorDAO : DeudorDAO = MisDeudores.database.DeudorDAO()
            val deudor = deudorDAO.searchDeudor(nombre)

            if (deudor!= null){
                binding.telefonoTextView.text = deudor.telefono
                binding.valorTextView.text = deudor.valor.toString()
            }else{
                Toast.makeText(context, "no existe", Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object {

    }
}