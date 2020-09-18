package br.com.eleonardoro.hangman.core;

public class InvalidCharacterException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidCharacterException (String message) {
		super(message);
	}
}
