package br.com.eleonardoro.hangman.game;

import java.util.HashSet;
import java.util.Set;

import br.com.eleonardoro.hangman.core.Config;
import br.com.eleonardoro.hangman.core.Dictionary;
import br.com.eleonardoro.hangman.core.InvalidCharacterException;
import br.com.eleonardoro.hangman.core.Word;
import br.com.eleonardoro.hangman.ui.UI;

public class Game {

	public void start(String[] args) throws InvalidCharacterException {

		UI.print("Welcome to the Hangman Game!");

		Dictionary dictionary = Dictionary.getInstance();
		Word word = dictionary.nextWord();

		UI.print("The word has " + word.size() + " letters");

		char c;
		Set<Character> usedChars = new HashSet<>();
		int errorCount = 0;
		
		int maxErrors = 0;
		UI.printNewLine();
		if(args.length > 0) {
			Config.setMaxErrors(args[0]);
			maxErrors = Integer.parseInt(args[0]);
		}else {
			maxErrors = Integer.parseInt(Config.get("maxErrors"));
		}
		
		UI.print("You can make mistakes at most " + maxErrors + " times");
		UI.printNewLine();

		while (true) {
			UI.print(word);
			UI.printNewLine();

			try {
				c = UI.readChar("Type a Letter: ");

				if (usedChars.contains(c))
					throw new InvalidCharacterException("This letter has already been typed!");

				usedChars.add(c);

				if (word.hasChar(c))
					UI.print("You hit a letter!");
				else {
					errorCount += 1;

					if (errorCount < maxErrors)
						UI.print("You missed! You can still make " + (maxErrors - errorCount) + " mistake(s)");
				}
			} catch (InvalidCharacterException e) {
				UI.print("Error: " + e.getMessage());
				UI.printNewLine();
			}

			UI.printNewLine();

			if (word.discovered()) {
				UI.print("Congratulations! You hit the full word: " + word.getOriginalWord());
				UI.print("End of the game!");
				break;
			}

			if (errorCount == maxErrors) {
				UI.print("You lost the game! The correct word was: " + word.getOriginalWord());
				UI.print("End of the game!");
				break;
			}
		}

	}

}
