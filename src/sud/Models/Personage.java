package sud.Models;

public class Personage {

    private int hp;
    private int mp;
    private int force;
    private int defense;
    private ElementPersonage elementPersonage;

    public Personage(int hp, int mp, int force, int defense, ElementPersonage elementPersonage) {
        this.hp = hp;
        this.mp = mp;
        this.force = force;
        this.defense = defense;
        this.elementPersonage = elementPersonage;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public int getForce() {
        return force;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public ElementPersonage getElementPersonage() {
        return elementPersonage;
    }

    public void setElementPersonage(ElementPersonage elementPersonage) {
        this.elementPersonage = elementPersonage;
    }
}
