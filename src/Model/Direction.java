package Model;

public enum Direction {
    NORD, SUD, EST, OUEST, NORD_EST, NORD_OUEST, SUD_EST, SUD_OUEST;

    public static Direction getRandomDirection() {
        return switch ((int) (Math.random() * 4)) {
            case 0 -> NORD; case 1 -> SUD; case 2 -> EST; default -> OUEST;
        };
    }

    public static Direction[] getTempetevalues() { return new Direction[] {NORD, SUD, EST, OUEST}; }

    public static Direction getOpposite(Direction dir) {
        return switch (dir) {
            case NORD -> SUD; case SUD -> NORD; case EST -> OUEST; case OUEST -> EST; default -> null;
        };
    }
}