package Model;

import java.util.ArrayList;

public enum PlayerClass {
    EXPLORATEUR(5),
    ARCHEOLOGUE(4),
    ALPINISTE(4),
    PORTEUSE_EAU(6),
    NAVIGATRICE(5),
    METEOROLOGUE(5);

    private int niveauEau;

    public int getNiveauEau() { return niveauEau; }

    PlayerClass(int niveauEau) { this.niveauEau = niveauEau; }

    public static PlayerClass getRandomClass() {
        return switch ((int) (Math.random() * 6)) {
            case 0 -> EXPLORATEUR; case 1 -> ARCHEOLOGUE; case 2 -> ALPINISTE;
            case 3 -> PORTEUSE_EAU; case 4 -> NAVIGATRICE; case 5 -> METEOROLOGUE;
            default -> null;
        };
    }

    public static ArrayList<PlayerClass> getClasses() {
        ArrayList<PlayerClass> classes = new ArrayList<>();
        classes.add(EXPLORATEUR);
        classes.add(ARCHEOLOGUE);
        classes.add(ALPINISTE);
        classes.add(PORTEUSE_EAU);
        classes.add(NAVIGATRICE);
        classes.add(METEOROLOGUE);
        return classes;
    }

    public static PlayerClass fromString(String s) {
        return switch (s) {
            case "Explorateur" -> EXPLORATEUR;
            case "Archéologue" -> ARCHEOLOGUE;
            case "Alpiniste" -> ALPINISTE;
            case "Porteuse d'eau" -> PORTEUSE_EAU;
            case "Navigatrice" -> NAVIGATRICE;
            case "Météorologue" -> METEOROLOGUE;
            default -> null;
        };
    }

    public String toSting() {
        return switch (this) {
            case EXPLORATEUR -> "Explorateur";
            case ARCHEOLOGUE -> "Archéologue";
            case ALPINISTE -> "Alpiniste";
            case PORTEUSE_EAU -> "Porteuse d'eau";
            case NAVIGATRICE -> "Navigatrice";
            case METEOROLOGUE -> "Météorologue";
        };
    }
}
