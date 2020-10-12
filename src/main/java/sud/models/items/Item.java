package sud.models.items;

import lombok.*;
import sud.utils.Random;

@Getter
@Setter
public abstract class Item {
    private String name;
    private ItemType type;
    private int power;

    public Item(String name, ItemType type, int power) {
        this.name = name;
        this.type = type;
        this.power = power;
    }

    public static Item randomItem() {
        val randomized = Random.randomize(0, 8);
        switch (randomized) {
            case 0:
                return new SmallLife();
            case 1:
                return new SmallMana();
            case 2:
                return new MediumLife();
            case 3:
                return new MediumMana();
            case 4:
                return new GreatLife();
            case 5:
                return new GreatMana();
            case 6:
                return new LifeOrb();
            case 7:
                return new ManaOrb();
            case 8:
                return new ElementalOrb();
            default:
                return null;
        }
    }

    public static Item randomMediumItem() {
        val randomized = Random.randomize(1, 2);
        return randomized == 1 ? new MediumLife() : new MediumMana();
    }

    public static Item randomGreatItem() {
        val randomized = Random.randomize(1, 2);
        return randomized == 1 ? new GreatLife() : new GreatMana();
    }

    public static Item randomSmallItem() {
        val randomized = Random.randomize(1, 2);
        return randomized == 1 ? new SmallLife() : new SmallMana();
    }
}
