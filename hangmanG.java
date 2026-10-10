import java.util.Random;
import java.util.Scanner;
public class hangmanG {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Random random = new Random();
		 String[] words = {"school", "work", "house", "money", "college"};

		 int number = random.nextInt(words.length);
		 String secretWord = words[number];

		 String guessedLetters = "";
		 int WrongGuesses = 0;
		 int MaxAttempts = 6;
		 boolean WordGuessed = false;

		 System.out.println("Welcome to Hangman Game!");
		 while (WrongGuesses < MaxAttempts && !WordGuessed) {
		   String hiddenWord = "";
		   for (int i = 0; i < secretWord.length(); i++) {
			   String letter = secretWord.substring(i, i+1);
			   if (guessedLetters.contains(letter)) {
				   hiddenWord = hiddenWord + letter;
			   } else {
				   hiddenWord = hiddenWord +"_";
			   }
		   }
		   System.out.println("\nWord: " + hiddenWord);
		   System.out.printf("Incorrect guesses: %d%n", WrongGuesses);
		   System.out.printf("Attempts remaining: %d%n",
				   MaxAttempts - WrongGuesses);
		   System.out.print("guess one letter: ");
		   String guess = input.nextLine().toLowerCase();

		   if (guess.length() != 1) {
			   System.out.println("Please enter one letter");
			   continue;
		   }
		   if (guessedLetters.contains(guess)) {
			   System.out.println("You already guessed that letter.");
			   continue;
		   }
		   guessedLetters = guessedLetters + guess;
		   if (secretWord.contains(guess)) {
			   System.out.println("Correct guess!");
		   }else {
			   System.out.println("wrong guess.");
			   WrongGuesses++;
		   }
		   String currentWord = "";
		   for (int i = 0; i < secretWord.length(); i++) {
			   String letter = secretWord.substring(i, i + 1);

			   if (guessedLetters.contains(letter)) {
				   currentWord = currentWord + letter;
			   } else {
				   currentWord = currentWord + "_";
			   }
		   }
		   if (currentWord.equals(secretWord)) {
			   WordGuessed = true;
		   }
		 }
		 if (WordGuessed) {
			 System.out.println("\nCongratulations! You guessed the word!");
		 } else {
			 System.out.println("\nGame over!");
		 }
		System.out.println("The secret word was: " + secretWord);
		int score = (int) Math.max(0, MaxAttempts - WrongGuesses);
		System.out.printf("Your remaining-attempt score: %d%n", score);
		input.close();
	}
}
