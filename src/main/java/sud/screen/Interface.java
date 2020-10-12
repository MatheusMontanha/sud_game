package sud.screen;

import lombok.val;

import java.util.Scanner;

public class Interface {
    private Interface() {
    }

    private static Interface instance;

    public static Interface getInstance() {
        if (instance == null)
            instance = new Interface();
        return instance;
    }

    public static void printText(String text) {
        getInstance().print(text);
    }

    public static String readInput() {
        return getInstance().read();
    }

    public static int readIntInput(){
        return getInstance().readInt();
    }

    private static int readInt() {
        Integer num = null;
        do {
            try {
                val scanner = new Scanner(System.in);
                num = scanner.nextInt();
            } catch (Exception ex) {
                System.out.println("Por favor, digite um numero");
            }
        } while (num == null);
        return num;
    }


    public static void printText(String text, Object... varargs) {
        Interface.printText(String.format(text, varargs));
    }

    public static void printTexts(String[] texts) {
        for (val text : texts) {
            printText(text);
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void print(String text) {
        System.out.println(text);
    }

    private String read() {
        val scanner = new Scanner(System.in);
        return scanner.next() + " " + scanner.nextLine();
    }

}
