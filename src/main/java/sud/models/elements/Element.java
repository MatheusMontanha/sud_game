package sud.models.elements;

import lombok.Getter;
import lombok.val;
import sud.utils.Random;

import java.util.List;

@Getter
public abstract class Element {

    private final String name;
    private final ElementType elementType;
    private List<ElementType> weakness;
    private List<ElementType> strongness;


    protected Element(String name, ElementType elementType, List<ElementType> weakness, List<ElementType> strongness) {
        this.name = name;
        this.weakness = weakness;
        this.strongness = strongness;
        this.elementType = elementType;
    }

    public static Element randomElement() {
        val randomized = Random.randomize(0, 3);
        switch (randomized) {
            case 0:
                return WaterElement.getInstance();
            case 1:
                return FireElement.getInstance();
            case 2:
                return NatureElement.getInstance();
            case 3:
                return AirElement.getInstance();
            default:
                return null;
        }
    }

    public boolean hasWeaknessTo(Element element) {
        return weakness.contains(element.getElementType());
    }
    public boolean isStrongAgainst(Element element) {
        return strongness.contains(element.getElementType());
    }
}
