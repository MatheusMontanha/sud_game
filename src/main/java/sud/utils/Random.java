package sud.utils;

import java.util.concurrent.ThreadLocalRandom;

public class Random {
    public static int randomize(int min, int max){
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}
