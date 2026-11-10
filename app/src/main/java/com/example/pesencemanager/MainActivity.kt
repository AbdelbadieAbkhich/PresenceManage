package com.example.pesencemanager

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.text.util.Linkify
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.btnCommencer)
        btn.setOnClickListener {

            val intent = Intent(this , DashboardActivity::class.java)
            startActivity(intent)
        }
        val footer = findViewById<TextView>(R.id.txtFooter)
        footer.setOnClickListener {
            afficherInfosDeveloppeur()

        }
    }
    private fun afficherInfosDeveloppeur(){
        val dialogue = AlertDialog.Builder(this)
            .setTitle("Information de developpeur")
            .setMessage("Application : PresenceManager\n" +
                    "Version : 1.0\n"+
                    "Developpeur :Mr ABKHICH_Abdelbadiae\n" +
                    "GitHub : https://github.com/AbdelbadieAbkhich/PresenceManage" )
            .setPositiveButton("ok",null)
            .show()
        dialogue.findViewById<TextView>(android.R.id.message)?.let{
                texte ->
            Linkify.addLinks(texte,Linkify.WEB_URLS)
            texte.movementMethod = LinkMovementMethod.getInstance()
        }
    }
}