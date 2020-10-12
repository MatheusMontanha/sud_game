package sud.models.items;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Orb extends Item {
    BuffType buffType;

    public Orb(String name, BuffType buffType, int power) {
        super(name, ItemType.BUFF, power);
        this.buffType = buffType;
    }
}