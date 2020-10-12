package sud;

import lombok.val;
import sud.engine.Engine;

public class App {
    public static void main(String[] args) {
        val engine = new Engine();
        engine.runGame();
    }
}
