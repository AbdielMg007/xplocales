package com.mg.xpstock.adapters

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mg.xpstock.R
import com.mg.xpstock.listas.listadb

class adapterTarget(private val activity: Activity, var datoMarca: String) : RecyclerView.Adapter<adapterTarget.ViewHolder>(){

    val newModelo: Array<String?> = llenarModelo(datoMarca)
    val newPrecio: Array<String?> = llenarPrecio(datoMarca)
    val newDisponibilidad: Array<String?> = llenarDisponibilidad(datoMarca)
    val tamanoArreglos = newModelo.size
    val newImages: Array<Int?> = llenarImages(datoMarca, tamanoArreglos)




    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        var iImage: ImageView
        var iPrecios: TextView
        var iModelo: TextView
        var iDisponibilidad: TextView





        init {
            iImage = itemView.findViewById(R.id.itemImage)
            iModelo = itemView.findViewById(R.id.itemModelo)
            iPrecios = itemView.findViewById(R.id.itemPrecio)
            iDisponibilidad = itemView.findViewById(R.id.itemDisponible)

        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.target_buscador, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {

        newImages[i]?.let { viewHolder.iImage.setImageResource(it) }
        viewHolder.iModelo.text = newModelo[i]
        viewHolder.iPrecios.text = newPrecio[i]
        viewHolder.iDisponibilidad.text = newDisponibilidad[i]


    }

    override fun getItemCount() =  newModelo.size
}

    fun llenarModelo(marca: String): Array<String?> {
        var modeloDb = arrayOfNulls<String?>(427)
        var aux = 0
        modeloDb = revisar(marca)
        aux = modeloDb.size
        for(i in 0 until aux){
            val modeloMandar = listadb(modeloDb[i].toString(), "modelo")
            val modeloMandarString: String = modeloMandar()
            modeloDb[i] = modeloMandarString
        }
        val modelosMandar = arrayOfNulls<String?>(aux)
        for (i in 0 until aux) {
            modelosMandar[i] = modeloDb[i]
        }
        return modelosMandar
    }

    fun llenarPrecio(marca: String): Array<String?> {
        var modeloDb = arrayOfNulls<String?>(427)
        var aux = 0
        modeloDb = revisar(marca)
        aux = modeloDb.size
        for(i in 0 until aux){
            val modeloMandar = listadb(modeloDb[i].toString(), "precio")
            val modeloMandarString: String = modeloMandar()
            modeloDb[i] = modeloMandarString
        }
        val modelosMandar = arrayOfNulls<String?>(aux)
        for (i in 0 until aux) {
            modelosMandar[i] = "$" + modeloDb[i]
        }
        return modelosMandar
    }

    fun llenarDisponibilidad(marca: String): Array<String?> {
        var modeloDb = arrayOfNulls<String?>(427)
        var aux = 0
        modeloDb = revisar(marca)
        aux = modeloDb.size
        for(i in 0 until aux){
            val modeloMandar = listadb(modeloDb[i].toString(), "disponibilidad")
            var modeloMandarString: String = modeloMandar()
            if(modeloMandarString == "0" || modeloMandarString.contains("-")){
                modeloMandarString = "No"
            }else if(modeloMandarString == "5" || modeloMandarString == "4" || modeloMandarString == "3" || modeloMandarString == "2" || modeloMandarString == "1"){
                modeloMandarString = "Pocos"
            }else{
                modeloMandarString = "Si"
            }
            modeloDb[i] = modeloMandarString
        }
        val modelosMandar = arrayOfNulls<String?>(aux)
        for (i in 0 until aux) {
            modelosMandar[i] = modeloDb[i]
        }
        return modelosMandar
    }

    fun llenarImages(marca: String, tamano: Int):Array<Int?>{
        val imagesDb = arrayOfNulls<Int?>(tamano)
        val listaAuxiliar = revisar(marca)
        for(i in 0 until tamano){

        }
    return imagesDb
    }



