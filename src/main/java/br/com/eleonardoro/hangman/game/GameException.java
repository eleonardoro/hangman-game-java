package br.com.eleonardoro.hangman.game;

public class GameException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public GameException(String message) {
		super(message);
	}

}
