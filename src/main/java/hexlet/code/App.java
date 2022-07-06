package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.Gcd;
import hexlet.code.games.Progression;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        String[] games = {"Greet", "Even", "Calc", "GCD", "Progression"};
        for (int i = 0; i < games.length; i++) {
            int gameNumber = i + 1;
            System.out.println(gameNumber + " - " + games[i]);
        }
        System.out.println("0 - Exit");
        Scanner reader = new Scanner(System.in);
        int choice = reader.nextInt();
        System.out.println("Your choice: " + choice + "\n");
        System.out.println("Welcome to the Brain Games!");
        switch (choice) {
            case 1 -> Cli.greet();
            case 2 -> Even.start();
            case 3 -> Calc.start();
            case 4 -> Gcd.start();
            case 5 -> Progression.start();
            default -> System.exit(0);
        }
    }
}
