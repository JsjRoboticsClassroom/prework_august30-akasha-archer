package nyc.c4q;

public class Main {

    public static void main(String[] args) {
        Hangman hangman = new Hangman();
        boolean notDone = true;
        while (notDone) {
            while (hangman.getMisses() < 5) {
                hangman.printCurrentWord();
                hangman.promptPlayer("Enter a letter: ");
                hangman.readLetter();
                hangman.checkLetter();
                if (hangman.guessedSuccessfully()) {
                    break;
                }
                System.out.println(Drawing.get(hangman.getMisses()));
                System.out.println("Misses -> " + hangman.getMisses());
            }
            if (hangman.guessedSuccessfully()) {
                System.out.println("Success");
            } else {
                System.out.println("The answer was " + hangman.getSecretWord());
            }

            //  /***************************/
            // prompt("Do you Want to play again?");
            boolean isValidInput;      //control isValidInput inside the loop to decide if loop runs again
            do {
                hangman.promptPlayer("Would you like to play again?");
                String userAnswer = hangman.readString();
                if (userAnswer.equalsIgnoreCase("yes") || userAnswer.equalsIgnoreCase("y")) {
                    notDone = true;

                } else if (userAnswer.equalsIgnoreCase("no") || userAnswer.equalsIgnoreCase("n")) {
                    System.out.println("Thank you for playing. See you next time!");
                    break;

                } else {
                    isValidInput = false;
                    hangman.promptPlayer("Please enter a valid response!");
                    hangman.readString();
                }
                while (isValidInput = false) ;
            }
            // IntelliJ is asking me to place the "while" outside of the loop. Doing that allows the program to begin, but also immediately end without the user having the ability to play even 1 game.
        }
    }
}
