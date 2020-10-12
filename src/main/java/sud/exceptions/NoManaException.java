package sud.exceptions;

public class NoManaException extends Exception{
    public NoManaException() {
        super("Você não tem mana o suficiente para usar esse ataque. Selecione outro");
    }
}
