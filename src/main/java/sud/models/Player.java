package sud.models;

import lombok.Getter;
import sud.models.elements.Element;
import sud.models.items.Item;
import sud.screen.Interface;


import java.util.ArrayList;


public class Player extends Targetable {

    @Getter
    private int maxLife = 100;
    @Getter
    private int maxMana = 100;
    @Getter
    private float manaUsage = 1;
    ArrayList<Item> inventory = new ArrayList<>();
    @Getter
    // TODO REMOVE RANDOM ELEMENT
    private static Player instance;

    public static Player getInstance() {
        if (instance == null) {
            instance = new Player();
        }
        return instance;
    }

    private Player(){
        element =  Element.randomElement();
    }

    public void addItem(Item item) {
        Interface.printText("Você guardou %s no inventário", item.getName());
        inventory.add(item);
    }

    public void reduceManaUsage(int power) {
        Interface.printText("Agora você gasta menos mana em suas habilidades");
        this.manaUsage = manaUsage - (float) power / 100;
    }

    public void addMaxMana(int power) {
        Interface.printText("Agora você tem uma mana maxima maior");
        this.maxMana = maxMana + power;
    }

    public void addMaxLife(int power) {
        Interface.printText("Agora você tem uma vida maxima maior");
        this.maxLife = maxLife + power;
    }
}
