package sud.models.elements;

import java.util.Arrays;
import java.util.Collections;

public class FireElement extends Element {
    private FireElement(){
        super("Fogo", ElementType.FIRE, Arrays.asList(ElementType.WATER, ElementType.DEATH), Collections.singletonList(ElementType.NATURE));

    }

    private static FireElement instance;

    public static FireElement getInstance() {
        if (instance == null)
            instance = new FireElement();
        return instance;
    }
}
