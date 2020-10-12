package sud.models;

import lombok.Getter;
import lombok.val;
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
    private static Player instance;

    public static Player getInstance() {
        if (instance == null) {
            instance = new Player();
        }
        return instance;
    }

    private Player() {
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

    public boolean openInventory() {
        if (inventory.size() == 0) {
            Interface.printText("Você não possui itens");

            return false;
        }
        Interface.printText("Que item deseja usar?");
        for (int i = 0; i < inventory.size(); i++) {
            val item = inventory.get(i);
            Interface.printText("%s - %s (%s%S)", i, item.getName(), item.getType().getAbreviation(), item.getPower());
        }
        Interface.printText("%s - Voltar", inventory.size());

        do {
            val selectedItemIndex = Interface.readIntInput();
            if (selectedItemIndex == inventory.size())
                return false;
            try {
                val item = inventory.get(selectedItemIndex);
                switch (item.getType()) {
                    case LIFE_POTION:
                        actualLife = Math.min(actualLife + item.getPower(), maxLife);
                    case MANA_POTION:
                        actualMana = Math.min(actualMana + item.getPower(), maxLife);
                }
                Interface.printText("Você utilizou o item %s", item.getName());
                return true;
            } catch (Exception e) {
                Interface.printText("Por favor, selecione um valor entre 0 e %s", (inventory.size() - 1));
            }
        } while (true);
    }

    public void setElement(Element element) {
        this.element = element;
    }
}
