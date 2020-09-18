package br.com.eleonardoro.hangman.game;

import br.com.eleonardoro.hangman.core.Word;

public class Game {

	public void start() {
		
		Word word = new Word("casa");
		word.hasChar('a');
		word.hasChar('c');
		System.out.println(word.discovered());
		word.hasChar('s');
		System.out.println(word.discovered());
		
		System.out.println(word);
		
	}

}
