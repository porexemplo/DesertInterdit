# DÉSERT INTERDIT

Désert Interdit est un jeu de société coopératif pour 2 à 5 joueurs, dans lequel vous incarnez des aventuriers perdus dans un désert mystérieux. Votre mission est de trouver les pièces manquantes d'un vaisseau spatial écrasé et de vous enfuir avant que la tempête de sable ne vous submerge. Le jeu est conçu pour les joueurs âgés de 10 ans et plus et dure environ 45 minutes.

<img width="512" alt="Screenshot_2023-04-24_102657" src="https://github.com/redyummybread/DesertInterdit/assets/62790552/1573acd8-2d2a-4f6d-a0cd-0600a7d3b8a3">

## PARTIES TRAITÉES

Le projet a été codé entièrement par nos soins. Nous avons construit les cartes de tempêtes, carte d'équipements, rôle (personnage) du joueur, faire les tuiles et ce readme détail la manière dont on a traité les différents challenges de ce projet.

### Objectif

Le but de Desert Interdit est de collecter les quatre pièces du machine volante et de se rendre au point de départ avec tous les joueurs en vie avant que la tempête de sable ne recouvre complètement la carte.

### Matériel
Le jeu comprend les éléments suivants :

- 12 Cartes d'equipements
- 31 Cartes Tempête de sable
- 6 Personnages de joueurs
- 4 Jetons de pièces de vaisseau
- 24 Tuile de sable
- 1 Tuile Tempête de sable

### Préparation

Chaque joueur est assigné un personnage et la place sur la case correspondante sur la carte qui est la case du crache du vaisseau. Les jetons de pièces de vaisseau sont mélangés et placés sur les tuiles spéciales correspondantes sur la carte. Les cartes Tempête de sable sont mélangées et placées face cachée sur la case correspondante sur la carte. Les cartes d'équipements sont mélangées.

### Tour de jeu

Les joueurs commencent au point du crache de l'hélicoptère sur la carte, et doivent se déplacer de tuile en tuile pour collecter des cartes permettant de trouver les pièces de la machine spatiale. Chaque tour, les joueurs doivent tirer des cartes Tempête de sable, qui peuvent les empêcher de se déplacer ou même les faire perdre le jeu.
<br>

Les joueurs peuvent également utiliser des cartes équipements pour se déplacer plus vite, récupérer des objets ou aider les autres joueurs. Mais attention, si un joueur meurt ou si la tempête de sable atteint le niveau maximum, la partie est perdue !
<br>

Chaque tour de jeu se déroule en 3 phases :
<br>
1. Le joueur commence ses actions.
2. Le joueur tire 2 cartes Tempête de sable.
3. Le joueur peut aussi piocher des cartes équipements.

#### Phase 1 : Jouer des actions.
Le joueur actif peut jouer autant de cartes équipements qu'il le souhaite, à condition qu'elles soient valides dans sa position actuelle sur la carte, mais il a droit qu'à 4 actions par tour.

Les différentes actions du joueur sont:
* Se déplacer d'une case adjacente.
* Enlever du sable
* Explorer la tuile

Les cartes équipements peuvent être utilisées pour :
* Se déplacer sur une case très éloigné sur la carte.
* Explorer une case adjacente sans enlever son sable. 
* Boire de l'eau et en donner à un autre jouer dans la même case.
* Enlever tout le sable sur une case sans tenir compte de ses actions
* Protection contre la vague de chaleur.

#### Phase 2 : Tirer deux cartes Tempête de sable
Le joueur actif tire deux cartes Tempête de sable et applique ses effets. Les cartes Tempête de sable peuvent :
* Augmenter du sable dans les cases de la carte en se déplaçant.
* Augmenter le niveau de tempête de sable.
* Oblige au joueur de boire de l'eau en envoyant des vagues de chaleur.


#### Phase 3 : Piocher des cartes d'équipement
Le joueur actif pioche une des cartes équipements par rapport à une instruction donner et les ajoute à sa main.


### Fin du jeu
Le jeu se termine de trois manières différentes :
1. Si tous les joueurs se trouvent sur la case de départ avec les quatre pièces de vaisseau.
2. Si un joueur est mort.
3. Si le niveau de tempête est arrivé au maximum.

## Choix du design pattern

Nous avons décidé de suivre le design patter Model-View-Controller / Observer. Ce modèle nous à aider à diviser les différents rôles de notre programme.
Nous avons opté pour la séparation totale des parties logiques du jeu et les parties du projet qui gèrent l’affichage. Le démarrage du jeu se fait par une méthode `start()` du contrôleur qui initialise la vue et le modèle.

NB : On ne passera pas le modèle en argument à la vue, car selon nous, ceci donne accès direct au modèle, ce qui est normalement le rôle du contrôleur.

### Le Model:
Nous avons créé un package Model et dedans, nous avons créé des différentes classes où nous avons organisé en class et class énuméré. Dans ce package, nous avons créé aussi une class générale qui regroupe toutes les différentes classes et qui créer le model.
     
### La View :
Nous avons créé le package View qui contient la fenêtre et qui initialise toutes nos interfaces graphiques et qui contient toutes les fenêtres et boutons qui s'affichent sur la fenêtre principale. Ce package contient aussi différent classe uniquement et aussi, il contient des vues pour l’affichage du jeu. Dans ce package, nous avons aussi une classe générale qui regroupe toutes les différentes classes.
    
### Le Controller:
Nous avons aussi créé le package Controller qui gère toutes les actions du jeu. Le Controller contient une classe principale qui contrôle toutes les actions qui se passe dans le jeu en récupérant le modèle général dans la classe model et la View générale dans le package View de telle de sorte que, quand une action est effectuée, elle est bien visible dans la View et établit dans le modèle. Le Controller se charge aussi de la mise-à-jour du View.
        
### Utils:
C'est un package supplémentaire où nous avons chargé les différentes images et icônes dans des classes pour avoir accès plus facilement et d'une manière organisée.
        
Nous pouvons constater qu'il n'y a pas de communication directe entre le modèle et la vue, mais c'est le controller qui les réunissent et cela créent une harmonie et une fluidité dans le code et dans la visualisation du jeu. La vue ne peut pas modifier le Model et réciproquement du coup ça évite des modifications non contrôlées, mais le controller s'assure que si le model est modifié la vue aussi est modifiée.
 
# CRÉDITS
Désert Interdit a été créé par Matt Leacock et édité par GameWright. Ce jeu numérique Desert Interdit a été conçue par Redwane HAMMAS et Alida NANA SUNJI K.
La méthode `getImageScaled()` qui réduit la taille (qualité des images) a été publié par Ocracoke sur StackOverFlow.
Ce Projet a été encadré par M. Fred Gruau.
