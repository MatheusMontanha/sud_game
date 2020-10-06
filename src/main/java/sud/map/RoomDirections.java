package sud.map;

import lombok.Getter;

public enum RoomDirections {

    TOP("Norte", -1, 0),
    DOWN("Sul", 1, 0),
    LEFT("Oeste", 0, -1),
    RIGHT("Leste", 0, 1);

    @Getter
    private final String text;
    @Getter
    private final int verticalSteps;
    @Getter
    private final int horizontalSteps;

    RoomDirections(String text, int verticalSteps, int horizontalSteps) {
        this.text = text;
        this.verticalSteps = verticalSteps;
        this.horizontalSteps = horizontalSteps;
    }

    @Override
    public String toString() {
        return text;
    }
}
