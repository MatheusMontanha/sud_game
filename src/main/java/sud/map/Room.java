package sud.map;

import lombok.AllArgsConstructor;
import lombok.val;
import sud.screen.Interface;

import java.util.ArrayList;

import static sud.constants.Configurations.MAP_HORIZONTAL_SIZE;
import static sud.constants.Configurations.MAP_VERTICAL_SIZE;

@AllArgsConstructor
public class Room {
    private int xPosition;
    private int yPosition;

    public static Room randomRoom(int xPosition, int yPosition) {
        return new Room(xPosition, yPosition);
    }

    public RoomDirections nextRoom() {
        val directions = new ArrayList<RoomDirections>();
        if (xPosition != 0) directions.add(RoomDirections.LEFT);
        if (xPosition != MAP_HORIZONTAL_SIZE - 1) directions.add(RoomDirections.RIGHT);
        if (yPosition != 0) directions.add(RoomDirections.TOP);
        if (yPosition != MAP_VERTICAL_SIZE - 1) directions.add(RoomDirections.DOWN);

        Interface.printText("Para onde você deseja ir?");
        for (int i = 0; i < directions.size(); i++) {
            Interface.printText(i + " - " + directions.get(i));
        }
        RoomDirections nextRoom = null;
        do {
            val selectedRoom = Interface.readIntInput();
            Interface.printText("Selected ROOM: " + selectedRoom);
            try {
                nextRoom = directions.get(selectedRoom);
            } catch (Exception e) {
                Interface.printText("Por favor, selecione um valor entre 0 e " + (directions.size() - 1));
            }
        } while (nextRoom == null);
        return nextRoom;
    }


}
