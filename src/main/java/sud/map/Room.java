package sud.map;

import lombok.AllArgsConstructor;
import lombok.val;
import sud.screen.Interface;
import sud.utils.Random;

import java.util.ArrayList;

import static sud.constants.Configurations.MAP_HORIZONTAL_SIZE;
import static sud.constants.Configurations.MAP_VERTICAL_SIZE;

public abstract class Room {
    private final int xPosition;
    private final int yPosition;
    protected RoomState roomState = RoomState.UNTOUCHED;

    public Room(int xPosition, int yPosition) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    public static Room randomRoom(int xPosition, int yPosition) {
        return new MonsterRoom(xPosition, yPosition);
    }

    public RoomState onRoomEnter(){
        return roomState;
    };

    public abstract RoomResult nextAction();

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
            try {
                nextRoom = goToRoom(directions.get(selectedRoom), directions);
            } catch (Exception e) {
                e.printStackTrace();
                Interface.printText("Por favor, selecione um valor entre 0 e %s", (directions.size() - 1));
            }
        } while (nextRoom == null);
        return nextRoom;
    }

    private RoomDirections goToRoom(RoomDirections selectedRoom, ArrayList<RoomDirections> directions) {
        RoomDirections room = selectedRoom;
        Interface.printText("Você escolheu ir para o %s", room.getText());
        val needed = Random.rollDice20();
        val diceResult = Random.rollDice20();
        Interface.printText("Você precisa tirar %s para ir para o lugar escolhido", needed);
        Interface.printText("Você tirou %s", diceResult);
        if (diceResult < needed) {
            val currentRoom = room;
            do {
                room = directions.get(Random.randomize(0, directions.size() - 1));
            } while (room == currentRoom);
            Interface.printText("Uma forte força impediu você de avançar para onde desejaria.");
        }
        Interface.printText("Você foi para o %s", room.getText());
        return room;
    }
}
