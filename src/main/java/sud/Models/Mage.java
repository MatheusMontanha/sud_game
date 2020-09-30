package sud.Models;

import lombok.Data;

@Data
public class Mage extends Character {

    public Mage(int hp, int mp, int force, int defense, CharacterElement elementPersonage) {
        super(hp, mp, force, defense, elementPersonage);
    }
}
