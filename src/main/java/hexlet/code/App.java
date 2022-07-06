package hexlet.code;


import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.Gcd;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        String[] games = {"Exit", "Greet", "Even", "Calc", "GCD", "Progression", "Prime"};
        for (int i = 1; i < games.length; i++) {
            System.out.println(i + " - " + games[i]);
        }
        System.out.println("0 - " + games[0]);
        Scanner reader = new Scanner(System.in);
        int choice = reader.nextInt();
        System.out.println("Your choice: " + choice + "\n");
        switch (games[choice]) {
            case "Greet" -> Cli.greet();
            case "Even" -> Even.start();
            case "Calc" -> Calc.start();
            case "GCD" -> Gcd.start();
            case "Progression" -> Progression.start();
            case "Prime" -> Prime.start();
            default -> System.exit(0);
        }
    }
}
