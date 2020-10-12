package sud.models.elements;

import java.util.Arrays;
import java.util.Collections;

public class WaterElement extends Element {
    public WaterElement() {
        super("Agua", ElementType.WATER, Arrays.asList(ElementType.AIR, ElementType.DEATH), Collections.singletonList(ElementType.FIRE));
    }

    private static WaterElement instance;

    public static WaterElement getInstance() {
        if (instance == null)
            instance = new WaterElement();
        return instance;
    }
}
