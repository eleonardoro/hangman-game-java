package br.com.eleonardoro.hangman;

import br.com.eleonardoro.hangman.core.InvalidCharacterException;
import br.com.eleonardoro.hangman.game.Game;

public class Main {

	public static void main(String[] args) throws InvalidCharacterException {

		Game game = new Game();
		game.start(args);
	}

}
