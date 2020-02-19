package com.example.appclima

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast

import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson

import java.lang.Exception

class MainActivity : AppCompatActivity() {

    var tvCiudad:TextView? = null
    var tvGrados:TextView? = null
    var tvEstatus:TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvCiudad = findViewById(R.id.tvCiudad)
        tvGrados = findViewById(R.id.tvGrados)
        tvEstatus = findViewById(R.id.tvEstado)

        val ciudad = intent.getStringExtra("com.example.appclima.Ciudades.CIUDAD")


        if(Network.hayRed(this)){
            // 45a657dd262dc1ca3a246dda90a3072d
            // 3617763
            solicidHHTPVolley("http://api.openweathermap.org/data/2.5/weather?id=${ciudad}&appid=45a657dd262dc1ca3a246dda90a3072d&units=metric&lang=es")
        }
        else {
            Toast.makeText(this, "No hay red", Toast.LENGTH_LONG).show()
        }

        /*
        val nicaragua = Ciudad("Nicaragua", 23, "Soleado")
        val madrid = Ciudad("Msdrid", 15, "Despejado")

        //Toast.makeText(this, ciudad, Toast.LENGTH_SHORT).show()

        if (ciudad == "Nicaragua") {
            tvGrados?.text = "${nicaragua.gradas.toString()}°"
            tvEstatus?.text = nicaragua.estatus
        }
        else if (ciudad == "Madrid"){
            tvGrados?.text = "${madrid.gradas.toString()}°"
            tvEstatus?.text = madrid.estatus
        }
        else {
            tvGrados?.text = "0°"
            tvEstatus?.text = "No hay información para la ciudad"
        }
        */
    }

    //Médodo para Volley
    private fun solicidHHTPVolley(url:String){
        val queue = Volley.newRequestQueue(this)

        val solicitud = StringRequest(Request.Method.GET, url, Response.Listener<String>{
            response ->
                try {
                    val gson = Gson()
                    val ciudadGSON = gson.fromJson(response, Ciudad::class.java)
                    tvCiudad?.text = ciudadGSON.name
                    tvEstatus?.text = ciudadGSON.weather?.get(0)?.description
                    tvGrados?.text = ciudadGSON.main?.temp.toString() + "°"
                }
                catch (e:Exception){

                }
        }, Response.ErrorListener { error -> error(error) })

        queue.add(solicitud)
    }
}
