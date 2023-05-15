package com.example.appanotaciones2.model

class TareasProvider {

    companion object{
        fun getTareas():TareasModel{
            val pos:Int = 0
            return Tareas[pos]
        }

        private val Tareas = listOf<TareasModel>(
            TareasModel("Ejemplo",Finalizado = true)
        )
    }



}