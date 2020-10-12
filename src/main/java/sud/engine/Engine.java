package sud.engine;

import lombok.val;
import sud.map.*;
import sud.screen.Interface;

public class Engine {
    private int xPosition = 0;
    private int yPosition = 0;

    Room currentRoom = Map.getInstance().getRooms()[xPosition][yPosition];

    private void executeNextRoomCommand() {
        val nextRoom = currentRoom.nextRoom();
        xPosition += nextRoom.getHorizontalSteps();
        yPosition += nextRoom.getVerticalSteps();
        currentRoom = Map.getInstance().getRooms()[xPosition][yPosition];
        Interface.printText("you're at [" + xPosition + "][" + yPosition + "]");
    }

    private void processRoomResult(RoomResult roomResult) {

    }

    public void runGame() {
        do {
            val roomState = currentRoom.onRoomEnter();
            if (roomState == RoomState.CLEAN) {
                executeNextRoomCommand();
            } else {
                RoomResult roomResult;
                do {
                    roomResult = currentRoom.nextAction();

                } while (roomResult == RoomResult.CONTINUE_ON_ROOM);
                processRoomResult(roomResult);
            }

        } while (!(currentRoom instanceof BossRoom));
        Interface.printText("cheogu na boss room");
    }
}
