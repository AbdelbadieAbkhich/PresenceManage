package com.example.pesencemanager

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.text.util.Linkify
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DashboardActivity: AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dashboard)
        Log.d("TP03", "Tableau de bord affiché")
        val cardGroupes= findViewById<View>(R.id.groupes)
        val cardAppel= findViewById<View>(R.id.FaireApple)
        val cardHistorique= findViewById<View>(R.id.historique)
        val cardstatistique= findViewById<View>(R.id.statisque)

        cardGroupes.setOnClickListener {
            Log.d("TP03", "Clic simple sur Groupes")
            startActivity(Intent(this , GroupeActivity::class.java ))
        }
        cardAppel.setOnClickListener {
            startActivity(Intent(this , AppelActivity::class.java))
        }
        cardHistorique.setOnClickListener {
            startActivity(Intent(this , HistoriqueActivity::class.java))
        }
        cardstatistique.setOnClickListener {
            startActivity(Intent(this , StatistiqueActivity::class.java))
        }
        cardGroupes.setOnLongClickListener {
            Toast.makeText(this,
                "Groupes : sélectionner ou consulter les groupes",
                Toast.LENGTH_SHORT).show()
            true
        }
        cardAppel.setOnLongClickListener {
            Toast.makeText(this,
                "Faire l'appel : démarrer une séance",
                Toast.LENGTH_SHORT).show()
            true
        }
        val imgProfil = findViewById<ImageView>(R.id.imgProfil)
        val detecteur = GestureDetector(
            this,
            object : GestureDetector.SimpleOnGestureListener() {
                override fun onDown(e: MotionEvent): Boolean = true
                override fun onDoubleTap(e: MotionEvent): Boolean {
                    AlertDialog.Builder(this@DashboardActivity)
                        .setTitle("À propos de PrésenceManager")
                        .setMessage(
                            "Application de gestion des présences — Version 1.0"
                        )
                        .setPositiveButton("OK", null)
                        .show()
                    return true
                }
            }
        )
        imgProfil.setOnTouchListener { _, evenement ->
            detecteur.onTouchEvent(evenement)
            true
        }
        val footer = findViewById<TextView>(R.id.txtFooterDashboard)

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
