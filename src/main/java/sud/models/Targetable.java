package sud.models;

import lombok.Getter;
import lombok.val;
import sud.exceptions.NoManaException;
import sud.models.elements.Element;
import sud.screen.Interface;

public abstract class Targetable {
    @Getter
    private int actualLife = 100;
    @Getter
    private int actualMana = 100;
    @Getter
    protected Element element;

    public int takeDamage(double baseDamage, Element attackerElement) {
        double damagePercentage = 1;
        if (attackerElement != null) {
            if (element.hasWeaknessTo(attackerElement)) {
                Interface.printText("O ataque foi super efetivo");
                damagePercentage = 1.5;
            }
            if (element.isStrongAgainst(attackerElement)) {
                Interface.printText("O ataque foi pouco efetivo");
                damagePercentage = 0.5;
            }
        }
        val takenDamage = (int) Math.ceil(baseDamage * damagePercentage);
        actualLife -= takenDamage;
        return takenDamage;
    }

    public void wasteMana(int mp) throws NoManaException {
        if (actualMana < mp)
            throw new NoManaException();
        actualMana -= mp;
    }
}
