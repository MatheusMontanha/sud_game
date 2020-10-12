package sud.map;

import lombok.val;
import sud.models.Player;
import sud.models.items.Item;
import sud.models.items.ItemType;
import sud.models.items.Orb;
import sud.screen.Interface;
import sud.utils.Random;

public class ItemRoom extends Room {

    Item roomItem;

    public ItemRoom(int xPosition, int yPosition) {
        super(xPosition, yPosition);
        this.roomItem = Item.randomItem();
    }

    @Override
    public RoomResult nextAction() {
        Interface.printText("Para entrou em um local e achou um armazem espiritual.");
        val needed = Random.rollDice20();
        Interface.printText("Para abrir o armazem, você precisa tirar %s", needed);
        val diceResult = Random.rollDice20();
        Interface.printText("Você tirou %s", diceResult);

        if (diceResult < needed) {
            Interface.printText("Você tentou abrir o armazem, mas ele desapareceu misteriosamente");
        } else {
            Interface.printText("Você abriu o armazem e achou um %s", roomItem.getName());
            if (roomItem.getType() == ItemType.BUFF) {
                val buffItem = (Orb) roomItem;
                switch (buffItem.getBuffType()) {
                    case LIFE:
                        Player.getInstance().addMaxLife(buffItem.getPower());
                        break;
                    case MANA:
                        Player.getInstance().addMaxMana(buffItem.getPower());
                        break;
                    case MANA_COST:
                        Player.getInstance().reduceManaUsage(buffItem.getPower());
                        break;
                }
            } else {
                Player.getInstance().addItem(roomItem);
            }
        }
        this.roomState = RoomState.CLEAN;
        return RoomResult.ROOM_DONE;
    }
}
