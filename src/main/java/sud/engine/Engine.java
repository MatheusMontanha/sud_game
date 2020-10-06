package sud.engine;

import lombok.val;
import sud.map.BossRoom;
import sud.map.Map;
import sud.map.Room;
import sud.screen.Interface;

public class Engine {
    private int xPosition = 0;
    private int yPosition = 0;

    Room currentRoom = Map.getInstance().getRooms()[xPosition][yPosition];

    public void runGame() {
        do {
            val nextRoom = currentRoom.nextRoom();
            xPosition += nextRoom.getHorizontalSteps();
            yPosition += nextRoom.getVerticalSteps();
            currentRoom = Map.getInstance().getRooms()[xPosition][yPosition];
            Interface.printText("you're at [" + xPosition + "][" + yPosition + "]");

        } while (!(currentRoom instanceof BossRoom));
        Interface.printText("cheogu na boss room");
    }
}
