package Model;

public enum Equipement {
    JETPACK, // Pouvoir de "voler" à n'importe quelle case en emenant un autre joueur
    BOUCLIER, // Défense contre les vagues de chaleur pour 1 joueur
    BLASTER, // Enlever en 1 action tous les sables d'une case
    APPAREILVUE, // Explorer une case sans faire d'action
    ACCELERATEURTEMPS, // Donne 2 action en plus
    RESERVE_EAU; //Donne 2 portion d'eau aux joueurs sur la case de la personne qui a activé cette option

    public String toString(){
        return  switch (this) {
            case BLASTER -> "BLASTER";
            case JETPACK -> "JETPACK";
            case BOUCLIER -> "BOUCLIER";
            case APPAREILVUE -> "APPAREILVUE";
            case ACCELERATEURTEMPS -> "ACCELERATEURTEMPS";
            case RESERVE_EAU -> "RESERVE_EAU";
        };
    }
}
