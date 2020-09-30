package sud;

import lombok.val;
import sud.engine.Engine;
import sud.map.Map;
import sud.screen.Interface;

import static sud.constants.Texts.HISTOTY_INTRO;

public class App {
    public static void main(String[] args) {
        val map = Map.getInstance();
        Interface.printTexts(HISTOTY_INTRO);
        val engine = new Engine(map);
        engine.runGame();
    }
}
