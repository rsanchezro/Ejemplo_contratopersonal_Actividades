package com.example.ejemplo_contratopersonal_actividades

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejemplo_contratopersonal_actividades.contratos_actividades.*
class MainActivity : AppCompatActivity() {
    //Defino el launcher, registerForActivityResult retorna un objeto
    //ActivityResultLauncher parametrizado, en función del contrato que le pase
    //y se utiliza indirectamente para arrancar la acción que se defina dentro del
    //intent del contrato
    var milauncher=registerForActivityResult(Contrato_Cadenas(Segunda_Activity::class.java)){
        dato:String->
        texto.text=dato
    }
    lateinit var texto:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        texto=findViewById(R.id.texto_principal)

        texto.setOnClickListener{
            //Arranco la 2ª actividad
            milauncher.launch("Texto que aparece en la 2ª actividadd")
        }

    }
}