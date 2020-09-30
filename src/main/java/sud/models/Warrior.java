package sud.models;

import lombok.Data;

@Data
public class Warrior extends Character {

    public Warrior(int hp, int mp, int force, int defense, CharacterElement elementPersonage) {
        super(hp, mp, force, defense, elementPersonage);
    }
}
