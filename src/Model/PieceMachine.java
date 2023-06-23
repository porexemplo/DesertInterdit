package Model;

public enum PieceMachine {
    MOTEUR, TURBINE, LAUNCHER, WHEEL;

    public static PieceMachine getPart(int i) {
        return switch (i) {
            case 1 -> MOTEUR; case 2 -> TURBINE; case 3 -> LAUNCHER; case 4 -> WHEEL;
            default -> null;
        };
    }

    public static String getPartName(int i) {
        return switch (i) {
            case 1 -> "Moteur"; case 2 -> "Turbine"; case 3 -> "Launcher"; case 4 -> "Wheel";
            default -> null;
        };
    }

    public static PieceMachine getPart(String s) {
        return switch (s) {
            case "Moteur" -> MOTEUR; case "Turbine" -> TURBINE; case "Launcher" -> LAUNCHER; case "Wheel" -> WHEEL;
            default -> null;
        };
    }
}
