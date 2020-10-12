package sud.map;

public class InitialRoom extends Room {
    public InitialRoom() {
        super(0, 0);
    }

    @Override
    public RoomState onRoomEnter() {
        return RoomState.CLEAN;
    }

    @Override
    public RoomResult nextAction() {
        return RoomResult.ROOM_DONE;
    }
}
