package sud.engine;

import lombok.AllArgsConstructor;
import sud.map.Map;
import sud.screen.Interface;

@AllArgsConstructor
public class Engine {
    private Map map;
    public void runGame(){
        Interface.printText("ACABO");
    }
}
