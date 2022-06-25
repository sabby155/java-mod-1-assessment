import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;

public class NumbersGame {
    public static void main(String[] args) {
        // your code here
        System.out.println("Running...");

        // Introduce the Game
        printGameIntro();
        printGameOptions();

        // Get the initial user feedback on difficulty and tell user
        int decisionDifficulty = getUserInput();

        String levelExplanations[] = {
                "Easy: You will win if your number is higher or the same than mine.",
                "Medium: You will win if your number is higher than mine.",
                "Hard : You will win only win if your number is the same as mine.",
                "Exit : Gone so soon?",
        };

        // Play the game - incorporate difficulty and range
        if (decisionDifficulty <= 0 || decisionDifficulty >= 5) {
            System.out.println("Wrong selection. Exiting game. . .");
            return;
        } else {
            System.out.println("You selected: " + levelExplanations[decisionDifficulty - 1]);
            switch (decisionDifficulty) {
                case 1:
                    System.out.println("Easy game initializing. . .");

                    int easyGameFinalNum = getUserRangeReturnNum();

                    System.out.println("What do you think the magic number is?");

                    int easyUserFinalNum = getUserInput();

                    if (easyUserFinalNum >= easyGameFinalNum) {
                        printGameWin();
                        revealRandomNum(easyGameFinalNum);
                    } else {
                        printGameLost();
                        revealRandomNum(easyGameFinalNum);
                    }

                    break;
                case 2:
                    System.out.println("Medium game initializing. . .");

                    int mediumGameFinalNum = getUserRangeReturnNum();

                    System.out.println("What do you think the magic number is?");

                    int mediumUserFinalNum = getUserInput();

                    if (mediumUserFinalNum > mediumGameFinalNum) {
                        printGameWin();
                        revealRandomNum(mediumGameFinalNum);
                    } else {
                        printGameLost();
                        revealRandomNum(mediumGameFinalNum);
                    }

                    break;
                case 3:
                    System.out.println("Hard game initializing. . .");

                    int hardGameFinalNum = getUserRangeReturnNum();

                    System.out.println("What do you think the magic number is?");

                    int hardUserFinalNum = getUserInput();

                    if (hardUserFinalNum == hardGameFinalNum) {
                        printGameWin();
                        revealRandomNum(hardGameFinalNum);
                    } else {
                        printGameLost();
                        revealRandomNum(hardGameFinalNum);
                    }

                    break;
                default:
                    System.out.println("Better luck next time. Goodbye. . .");
                    break;
            }
        }

    }

    private static void revealRandomNum(int num) {
        System.out.println("(My number was: " + num);
    }

    private static int getUserRangeReturnNum() {
        System.out.println("Select a number where you'd like to start your range");
        int decisionInputOrigin = getUserInput();

        System.out.println("Okay. You're starting your range at " + decisionInputOrigin);
        System.out.println("Please choose where you'd like to end your range.");
        int decisionInputBound = getUserInput();

        System.out.println("Great! I thought of a number from " + decisionInputOrigin + " to "
                + decisionInputBound + ".");

        System.out.println("Can you guess what that is?. . .");

        int magicNumber = generateRandomNumber(decisionInputOrigin, decisionInputBound);
        return magicNumber;
    }

    private static int getUserInput() {
        try {
            Scanner newScanner = new Scanner(System.in);
            int userInput = newScanner.nextInt();
            return userInput;
        } catch (InputMismatchException e) {
            System.out.println("Are you sure you chose a number?");
            return 0;
        }
    }

    private static void printGameOptions() {
        System.out.println("Please choose your difficulty level");
        System.out.println("+---~~~+-------------------------~~~---+");
        System.out.println("| 1. | EASY                             |");
        System.out.println("| 2. | MEDIUM                           |");
        System.out.println("| 3. | HARD                             |");
        System.out.println("| 4. | Exit Program.                    |");
        System.out.println("+---~~~+-------------------------~~~---+");
    }

    private static void printGameIntro() {
        System.out.println("*** --- ### WELCOME TO ### --- ***");
        System.out.println("---*( THE MAGIC NUMBERS GAME )*---");
        System.out.println("***---### *--&&-$%$-&&-* ###---***");
    }

    public static int generateRandomNumber(int origin, int bound) {
        Random rand = new Random();
        int number = rand.nextInt(origin, bound);
        return number;
    }

    private static void printGameWin() {
        System.out.println("*** --- !!! --- ***");
        System.out.println("Yay! You got it.");
        System.out.println("*** --- !!! --- ***");
    }

    private static void printGameLost() {
        System.out.println("*** --- !!! --- ***");
        System.out.println("Sorry. try again.");
        System.out.println("*** --- !!! --- ***");
    }
}
