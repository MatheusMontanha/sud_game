package sud.utils;

public class Random {
    public static int randomize(int min, int max) {
        java.util.Random rand = new java.util.Random();
        return rand.nextInt((max - min) + 1) + min;
    }

    public static int rollDice20() {
        return randomize(1, 20);
    }
}
