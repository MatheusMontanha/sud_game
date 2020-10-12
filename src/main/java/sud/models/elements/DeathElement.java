package sud.models.elements;

import java.util.Arrays;
import java.util.Collections;

public class DeathElement extends Element {

    private DeathElement() {
        super("Morte", ElementType.DEATH, Collections.emptyList(), Arrays.asList(ElementType.WATER, ElementType.FIRE, ElementType.NATURE, ElementType.AIR));
    }

    private static DeathElement instance;

    public static DeathElement getInstance() {
        if (instance == null)
            instance = new DeathElement();
        return instance;
    }
}
