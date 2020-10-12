package sud.models.enemies;

import lombok.Getter;
import lombok.Setter;
import sud.models.Targetable;
import sud.models.elements.DeathElement;
import sud.models.elements.Element;

@Getter
@Setter
public class Boss extends Enemy {
    public Boss() {
        element = DeathElement.getInstance();
    }
}

