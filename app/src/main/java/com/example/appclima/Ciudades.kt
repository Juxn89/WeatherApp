 package com.example.appclima

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

 class Ciudades : AppCompatActivity() {

     val TAG = "com.example.appclima.Ciudades.CIUDAD"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ciudades)

        val bNicaragua = findViewById<Button>(R.id.bNicaragua)
        val bMadrid = findViewById<Button>(R.id.bMadrid)

        bNicaragua.setOnClickListener(View.OnClickListener {
            //Toast.makeText(this, "Nicaragua", Toast.LENGTH_LONG).show()

            // INTENT EXPLÍCITO
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(TAG, "3617763")
            startActivity(intent)
        })

        bMadrid.setOnClickListener(View.OnClickListener {
            //Toast.makeText(this, "Madrid", Toast.LENGTH_LONG).show()

            // INTENT EXPLÍCITO
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(TAG, "3117735")
            startActivity(intent)
        })

        val bShanghai = findViewById<Button>(R.id.bShanghai)
        bShanghai.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(TAG, "1796236")
            startActivity(intent)
        })
    }
}
