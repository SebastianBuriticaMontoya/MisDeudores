package com.edwinacubillos.misdeudores.ui.actualizar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.edwinacubillos.misdeudores.MisDeudores
import com.edwinacubillos.misdeudores.R
import com.edwinacubillos.misdeudores.data.database.entities.Deudor
import com.edwinacubillos.misdeudores.databinding.FragmentActualizarBinding
import kotlinx.android.synthetic.main.fragment_actualizar.*

class ActualizarFragment : Fragment() {

    private lateinit var binding : FragmentActualizarBinding
    private var isSearching = true
    private var idDeudor = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_actualizar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentActualizarBinding.bind(view)

        binding.modificarBoton.setOnClickListener{
            val nombre = binding.nombreBuscarEditText.text.toString()
            val telefono = binding.telefonoEditText.text.toString()
            val valor = binding.valorEditText.text.toString()

            val deudorDAO = MisDeudores.database.DeudorDAO()
            var deudor = deudorDAO.searchDeudor(nombre)

            if (deudor!=null){
                binding.telefonoEditText.setText(deudor.telefono)
                binding.valorEditText.setText(deudor.valor?.toString())
            }

            if(isSearching){//buscando
                var deudor = deudorDAO.searchDeudor(nombre)
                if (deudor!=null){
                    isSearching=false
                    binding.modificarBoton.text = getString(R.string.actualizar)
                    idDeudor = deudor.id
                    binding.telefonoEditText.setText(deudor.telefono)
                    binding.valorEditText.setText(deudor.valor?.toString())
                }else{
                    Toast.makeText(context,"no existe", Toast.LENGTH_SHORT).show()
                }

            }else{//actualizar
                var deudor = Deudor(idDeudor,nombre,telefono,valor.toLong())

                deudorDAO.updateDeudor(deudor)
                isSearching = true
                binding.modificarBoton.text=getString(R.string.buscar)
            }
        }
    }

    companion object {

    }
}