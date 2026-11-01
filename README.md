# PresenceManage
# PrésenceManager

Application Android de gestion des présences des stagiaires.

> **Module M203** — Interfaces utilisateurs Android
> **Apprentissage A.1** — Éléments graphiques · **Durée** : 4 heures
> **TP N° 01** — Création de l'interface d'accueil

---

## Description

**PrésenceManager** a pour but de faciliter la gestion des présences dans un établissement de formation. À terme, l'application permettra aux formateurs de :

- sélectionner un groupe ;
- consulter la liste des stagiaires ;
- enregistrer les présences et les absences ;
- visualiser un récapitulatif.

Dans ce premier TP, seule l'**interface graphique de la page d'accueil** (`activity_main.xml`) est réalisée. Le bouton « Commencer l'appel » sera rendu fonctionnel lors des prochains TP.

## Technologies

| Élément | Choix |
|---|---|
| Langage | Kotlin |
| Interface | XML (Views) |
| Modèle de projet | Empty Views Activity |
| IDE | Android Studio |

## Écran d'accueil

`MainActivity` affiche, de haut en bas :

1. le logo (`logo_presence`, 110dp × 110dp) ;
2. le titre **PrésenceManager** ;
3. la description *« Application de gestion des présences des stagiaires »* ;
4. le bouton **Commencer l'appel** ;
5. le pied de page *« PrésenceManager - Version 1.0 »*.

### Structure du layout

```
LinearLayout (layoutAccueil)        vertical, match_parent, padding 24dp, fond #F8FAFC
├── LinearLayout                    vertical, centré, height 0dp, weight 1
│   ├── ImageView   imgLogo         110dp × 110dp
│   ├── TextView    txtTitre
│   ├── TextView    txtDescription
│   └── Button      btnCommencer
└── TextView        txtFooter
```

### Identifiants des composants

| Composant | Identifiant XML |
|---|---|
| LinearLayout principal | `layoutAccueil` |
| ImageView — Logo | `imgLogo` |
| TextView — Titre | `txtTitre` |
| TextView — Description | `txtDescription` |
| Button — Commencer l'appel | `btnCommencer` |
| TextView — Pied de page | `txtFooter` |

### Styles appliqués

| Composant | Taille | Couleur | Style |
|---|---|---|---|
| Fond (layout principal) | — | `#F8FAFC` | — |
| Titre | 28sp | `#1E3A5F` | gras |
| Description | 16sp | `#64748B` | normal |
| Bouton | 16sp | texte `#FFFFFF`, fond `#2563EB` | gras, hauteur 56dp |
| Pied de page | 12sp | `#94A3B8` | normal |

### Marges et espacements

| Élément | Propriété XML | Valeur |
|---|---|---|
| Layout principal | `android:padding` | 24dp |
| Titre | `android:layout_marginTop` | 30dp |
| Description | `android:layout_marginTop` | 12dp |
| Bouton | `android:layout_marginTop` | 40dp |
| Bouton | `android:layout_height` | 56dp |
| Pied de page | `android:layout_marginBottom` | 12dp |

> **Margin** : espace à l'extérieur des limites d'un widget.
> **Padding** : espace entre les limites d'un widget et son contenu.

Conformément aux consignes, les textes et les couleurs sont définis directement dans `activity_main.xml`, sans `strings.xml` ni `colors.xml`.

## Structure du projet

```
PresenceManager/
├── app/
│   └── src/main/
│       ├── java/.../MainActivity.kt
│       └── res/
│           ├── layout/activity_main.xml
│           └── drawable/logo_presence.png
├── build.gradle.kts
└── README.md
```

## Installation et exécution

1. Cloner le dépôt :
   ```bash
   git clone https://github.com/badiebakch90-ops/PresenceManage.git
   ```
2. Ouvrir le dossier dans **Android Studio**.
3. Attendre la synchronisation Gradle.
4. Choisir un émulateur (ex. *Pixel 8*) ou un appareil physique.
5. Cliquer sur **Run ▶** et comparer le résultat à la capture de référence.

## Aperçu

<!-- Ajouter une capture d'écran de l'émulateur :
![Écran d'accueil](screenshots/home.png) -->

## Feuille de route

- [x] TP 01 — Interface d'accueil
- [ ] Sélection d'un groupe
- [ ] Liste des stagiaires
- [ ] Enregistrement des présences et des absences
- [ ] Récapitulatif des présences

## Auteur

**ABKHICH Abdelbadiae** — Stagiaire, Module M203

---

*PrésenceManager — Version 1.0*