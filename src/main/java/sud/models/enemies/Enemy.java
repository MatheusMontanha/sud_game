package sud.models.enemies;

import lombok.Getter;
import lombok.Setter;
import sud.models.elements.Element;
import sud.models.Targetable;

@Getter
@Setter
public class Enemy extends Targetable {
    public Enemy() {
        element = Element.randomElement();
    }
}

