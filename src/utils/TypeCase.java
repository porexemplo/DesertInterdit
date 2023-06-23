package utils;

public enum TypeCase {
    MOTEUR_H, MOTEUR_V,
    TURBINE_H, TURBINE_V,
    LAUNCHER_H, LAUNCHER_V,
    WHEEL_H, WHEEL_V,
    ENGRENNAGE, TUNNEL, OASIS, PISTE;

    public static TypeCase fromString(String s) {
        return switch (s) {
            case "MOTEUR_H" -> MOTEUR_H; case "MOTEUR_V" -> MOTEUR_V;
            case "TURBINE_H" -> TURBINE_H; case "TURBINE_V" -> TURBINE_V;
            case "LAUNCHER_H" -> LAUNCHER_H; case "LAUNCHER_V" -> LAUNCHER_V;
            case "WHEEL_H" -> WHEEL_H; case "WHEEL_V" -> WHEEL_V;
            case "ENGRENNAGE" -> ENGRENNAGE; case "TUNNEL" -> TUNNEL;
            case "OASIS" -> OASIS; case "PISTE" -> PISTE;
            default -> null;
        };
    }

    public static String toString(TypeCase t) {
        return switch (t) {
            case MOTEUR_H -> "MOTEUR_H"; case MOTEUR_V -> "MOTEUR_V";
            case TURBINE_H -> "TURBINE_H"; case TURBINE_V -> "TURBINE_V";
            case LAUNCHER_H -> "LAUNCHER_H"; case LAUNCHER_V -> "LAUNCHER_V";
            case WHEEL_H -> "WHEEL_H"; case WHEEL_V -> "WHEEL_V";
            case ENGRENNAGE -> "ENGRENNAGE"; case TUNNEL -> "TUNNEL";
            case OASIS -> "OASIS"; case PISTE -> "PISTE";
        };
    }
}
