package sud.map;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Room {
    private int xPosition;
    private int yPosition;

    public static Room randomRoom(int xPosition, int yPosition) {
        return new Room(xPosition, yPosition);
    }
}
