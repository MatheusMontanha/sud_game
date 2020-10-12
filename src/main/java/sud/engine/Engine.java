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
    }

    private boolean processRoomResult(RoomResult roomResult) {
        return roomResult == RoomResult.GAME_OVER || roomResult == RoomResult.GAME_SUCCESS;
    }

    public void runGame() {
        boolean isGameFinished = false;
        do {
            val roomState = currentRoom.onRoomEnter();
            if (roomState == RoomState.CLEAN) {
                Interface.printText("Parece que você já esteve aqui");

                executeNextRoomCommand();
            } else {
                RoomResult roomResult;
                do {
                    roomResult = currentRoom.nextAction();

                } while (roomResult == RoomResult.CONTINUE_ON_ROOM);
                isGameFinished = processRoomResult(roomResult);
                if (!isGameFinished) {
                    executeNextRoomCommand();
                }
            }

        } while (!isGameFinished);
    }
}
