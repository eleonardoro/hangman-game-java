package br.com.eleonardoro.hangman.game;

import br.com.eleonardoro.hangman.core.Dictionary;
import br.com.eleonardoro.hangman.core.Word;

public class Game {

	public void start() {
		
		Dictionary d = new Dictionary();
		
		
		
		System.out.println(d.nextWord().getOriginalWord());
		
	}

}
