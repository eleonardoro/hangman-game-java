package br.com.eleonardoro.hangman.game;

import br.com.eleonardoro.hangman.core.Dictionary;
import br.com.eleonardoro.hangman.core.Word;

public class Game {

	public void start() {
		
		Dictionary d = Dictionary.getInstance();
				
		
		System.out.println(d.nextWord().getOriginalWord());
		
	}

}
