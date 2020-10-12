package sud.models.elements;

import java.util.Arrays;
import java.util.Collections;

public class NatureElement extends Element {
    private NatureElement() {
        super("Natureza", ElementType.NATURE, Arrays.asList(ElementType.FIRE, ElementType.DEATH), Collections.singletonList(ElementType.AIR));
    }

    private static NatureElement instance;

    public static NatureElement getInstance() {
        if (instance == null)
            instance = new NatureElement();
        return instance;
    }
}
