package sud.models;

import lombok.Data;

@Data
public class Character {

    private int hp;
    private int mp;
    private int force;
    private int defense;
    private CharacterElement elementPersonage;

    public Character(int hp, int mp, int force, int defense, CharacterElement elementPersonage) {
        this.hp = hp;
        this.mp = mp;
        this.force = force;
        this.defense = defense;
        this.elementPersonage = elementPersonage;
    }
}
