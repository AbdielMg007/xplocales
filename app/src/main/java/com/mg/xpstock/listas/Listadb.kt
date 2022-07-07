package com.mg.xpstock.listas

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

class listadb(var idCelular: String, var datoRequerido: String)  {


    operator fun invoke(): String {
        val idC = idCelular
        val datoR = datoRequerido
        return stock(idC, datoR)
    }

    public fun stock(idC: String, datoR: String):String{

        val id = idC
        val dato = datoR
        var datoQueSeManda = "0"
        var auxDatoRequerido = 0
        var auxFirebase = 0
        val db = FirebaseFirestore.getInstance()

        val producto = Array(4) { arrayOfNulls<String>(1000) }


        producto[0][0] = "id"//id
        producto[1][0] = "modelo"
        producto[2][0] = "precio"
        producto[3][0] = "disponibilidad"


        producto[0][1] = "1"//id
        producto[1][1] = "DISP | 1 BLACK or"
        producto[2][1] = "700"
        producto[3][1] = "10"

        producto[0][2] = "2"//id
        producto[1][2] = "DISP | 2 BLACK or"
        producto[2][2] = "600"
        producto[3][2] = "11"

        producto[0][3] = "3"//id
        producto[1][3] = "DISP | 2 BLACK or"
        producto[2][3] = "500"
        producto[3][3] = "12"

        /**for (i in 0 until 1000) {
            db.collection("products").document(i.toString()).get().addOnSuccessListener {
                producto[0][auxFirebase] = auxFirebase.toString()
                producto[1][auxFirebase] = it.get("name") as String?
                producto[2][auxFirebase] = it.get("price") as String?
                producto[3][auxFirebase] = it.get("stock") as String?
            }
        }*/



        for (i in 0 until 4) {
            if(dato == producto[i][0].toString()){
                auxDatoRequerido = i
            }
        }
        for (i in 0 until 1000) {
            if(id == producto[0][i].toString()){
                datoQueSeManda = producto[auxDatoRequerido][i].toString()
            }

        }

        return datoQueSeManda
    }

}