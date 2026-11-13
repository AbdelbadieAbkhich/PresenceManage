package com.example.pesencemanager

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.text.util.Linkify
import android.util.Log
import android.view.GestureDetector
import android.view.Menu
import android.view.MenuItem
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.ActionMode
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
        val cab = findViewById<Button>(R.id.btncab)
        val popup = findViewById<Button>(R.id.btnPopUp)

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

        cab.setOnClickListener {
            if (actionMode == null){
                actionMode = startSupportActionMode(cabCallback)
            }
        }

        //utilise botton Pop-up
        popup.setOnClickListener {
            val popMenu = PopupMenu(this,popup)
            popMenu.menuInflater.inflate(R.menu.popup , popMenu.menu)

            popMenu.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.action_ouvrir_groupes ->{
                        startActivity(Intent(this , GroupeActivity::class.java)
                        )
                        true
                    }
                    R.id.action_informations -> {
                        AlertDialog.Builder(this)
                            .setTitle("PrésenceManager")
                            .setMessage(
                                "Menu contextuel flottant du tableau de bord."
                            )
                            .setPositiveButton("OK", null)
                            .show()
                        true
                    }
                    else -> false
                }
            }
            popMenu.show()
        }
    }
    private  var actionMode : ActionMode? =null
    private val cabCallback= object : ActionMode.Callback {
        override fun onCreateActionMode(mode: ActionMode , menu: Menu) : Boolean{
                mode.menuInflater.inflate(R.menu.menu_cab , menu)
                mode.title = "Actions contextuelles"
            return true
        }


        override fun onActionItemClicked(mode: ActionMode, item: MenuItem): Boolean {
           when(item.itemId){
               R.id.action_afficher -> {
                   AlertDialog.Builder(this@DashboardActivity)
                       .setTitle("CAB")
                       .setMessage("Action Afficher exécutée.")
                       .setPositiveButton("OK", null)
                       .show()
                   true
               }
               R.id.action_search -> Toast.makeText(this@DashboardActivity, "Recherche", Toast.LENGTH_SHORT).show()
               R.id.action_share -> Toast.makeText(this@DashboardActivity, "Partager" , Toast.LENGTH_SHORT).show()
               R.id.action_delete -> Toast.makeText(this@DashboardActivity,"Supprimer" , Toast.LENGTH_SHORT).show()
               R.id.action_terminer -> {
                   mode.finish()
                   true
               }
               else -> false
           }
            mode.finish()
            return true
        }
        override fun onDestroyActionMode(mode: ActionMode) {
            actionMode = null
        }

        override fun onPrepareActionMode(
            mode: ActionMode,
            menu: Menu
        ): Boolean = false
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
