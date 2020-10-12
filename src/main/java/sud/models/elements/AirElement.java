package sud.models.elements;

import java.util.Arrays;
import java.util.Collections;

public class AirElement extends Element {
    private AirElement() {
        super("Ar", ElementType.AIR, Arrays.asList(ElementType.NATURE, ElementType.DEATH), Collections.singletonList(ElementType.WATER));
    }

    private static AirElement instance;

    public static AirElement getInstance() {
        if (instance == null)
            instance = new AirElement();
        return instance;
    }
}
