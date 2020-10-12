package sud.models.items;

import lombok.Getter;

public enum ItemType {
    LIFE_POTION("HP"),
    MANA_POTION("MP"),
    BUFF("BUFF");
    @Getter
    private final String abreviation;

    ItemType(String abreviation) {
        this.abreviation = abreviation;
    }
}
