package sud.map;

import lombok.val;
import sud.screen.Interface;
import sud.utils.Random;

import java.util.Arrays;

import static sud.constants.Configurations.MAP_HORIZONTAL_SIZE;
import static sud.constants.Configurations.MAP_VERTICAL_SIZE;

public class Map {
    private static Map instance;
    private Room[][] rooms;

    private Map() {
        rooms = new Room[MAP_VERTICAL_SIZE][MAP_HORIZONTAL_SIZE];
        rooms[0][0] = new InitialRoom();
        val bossRoomX = Random.randomize(4, MAP_HORIZONTAL_SIZE - 1);
        val bossRoomy = Random.randomize(4, MAP_VERTICAL_SIZE - 1);
        rooms[bossRoomX][bossRoomy] = new BossRoom(bossRoomX, bossRoomy);
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                if (rooms[i][j] == null)
                    rooms[i][j] = Room.randomRoom(i, j);
            }
        }
    }

    public static Map getInstance() {
        if (instance == null)
            instance = new Map();
        return instance;
    }

    public Room[][] getRooms() {
        return rooms;
    }
}
