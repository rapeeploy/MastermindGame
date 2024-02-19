package gameFolder;

import java.util.ArrayList;

public class GameLogic {
    protected static final int CODE_LENGTH = 5;
    protected static final int MAX_GUESSES = 7;

    int[] secretCode = generateSecretCode();

    int numGuesses = 0;
    boolean guessedCorrectly = false;
    int[] feedback;
    
    static ArrayList<Integer> codeInputArr = new ArrayList<>();

    //* 5 from 6 */
    protected static int[] generateSecretCode() {
        int[] code = new int[CODE_LENGTH];
        for (int i = 0; i < CODE_LENGTH; i++) {
            code[i] = (int) (Math.random() * 6); // Generates a random number between 0 and 5
        }
        printCode(code);
        return code;
    }

    protected void playGame() {
        if (!guessedCorrectly) {
            System.out.println("Enter your guess (e.g., 0 1 2 3 4):");
            ArrayList<Integer> guess = App.codeInputArr;
            System.out.println("your submitted "+guess);

            if (guess == null || guess.size() != 5) {
                System.out.println("Invalid input. Please enter " + CODE_LENGTH + " numbers.");
                return;
            }

            guessedCorrectly = checkGuess(secretCode, guess);
            feedback = generateFeedback(secretCode, guess);
            if (!guessedCorrectly) {
                System.out.println("Incorrect guess. Feedback: " + feedback[0] + " exact matches, " +
                feedback[1] + " color matches.");
                System.out.println("You have " + (MAX_GUESSES-1 - numGuesses) + " guesses left.");
            }
            numGuesses++;
        }

        if (guessedCorrectly) {
            System.out.println("Congratulations! You've guessed the secret code in " + numGuesses + " guesses!");
            return;
        } else if(MAX_GUESSES - numGuesses == 0) {
            System.out.println("Sorry, you've run out of guesses. The secret code was:");
            printCode(secretCode);
            return;
        }

    }

    protected static boolean checkGuess(int[] secretCode, ArrayList<Integer> guess) {
        for (int i = 0; i < CODE_LENGTH; i++) {
            if (secretCode[i] != guess.get(i)) {
                return false;
            }
        }
        return true;
    }

    protected static int[] generateFeedback(int[] secretCode, ArrayList<Integer> guess) {
        int exactMatches = 0;
        int colorMatches = 0;
        boolean[] visitedSecret = new boolean[CODE_LENGTH];
        boolean[] visitedGuess = new boolean[CODE_LENGTH];
    
        for (int i = 0; i < CODE_LENGTH; i++) {
            if (secretCode[i] == guess.get(i)) {
                exactMatches++;
                visitedSecret[i] = true;
                visitedGuess[i] = true;
            }
        }
    
        for (int i = 0; i < CODE_LENGTH; i++) {
            if (!visitedGuess[i]) {
                for (int j = 0; j < CODE_LENGTH; j++) {
                    if (!visitedSecret[j] && !visitedGuess[i] && secretCode[j] == guess.get(i)) {
                        colorMatches++;
                        visitedSecret[j] = true;
                        visitedGuess[i] = true;
                        break;
                    }
                }
            }
        }
    
        return new int[]{exactMatches, colorMatches};
    }

    protected static int calculatePoints(int numGuesses, boolean guessedCorrectly, int exactMatches, int colorMatches) {
        if (guessedCorrectly && numGuesses == 1) {
            // Guessed correctly in the first round
            return 30;
        } else if (guessedCorrectly && numGuesses > 1) {
            // Guessed correctly after the first round
            return 30 - 2 * (numGuesses - 1);
        } else {
            // Game ended without correct guess
            return (3 * exactMatches) + colorMatches;
            // return 0;
        }
    }
    
    protected static void printCode(int[] code) {
        for (int color : code) {
            System.out.print(color + " ");
        }
        System.out.println();
    }
}
