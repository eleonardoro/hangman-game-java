package br.com.eleonardoro.hangman.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.eleonardoro.hangman.game.GameException;
import br.com.eleonardoro.hangman.utils.RandomUtils;

public class FileDictionary extends Dictionary{

	private static final String FILE_NAME = "dictionary.txt";
	
	private List<String> words = new ArrayList<>(); 
	
	public FileDictionary() { load(); }
	
	
	private void load() {
		
		try(Scanner scanner = new Scanner(getClass().getResourceAsStream("/" + FILE_NAME))){
			
			while(scanner.hasNextLine()) {
				String word = scanner.nextLine().trim();
				words.add(word);
			}
			
			if(words.size() == 0)
				throw new GameException("The word list cannot be empty");
		}
	}
	
	@Override
	public Word nextWord() {
		return new Word(words.get(RandomUtils.newRanomNumber(0, words.size())));
	}


	@Override
	public String getName() {
		return ("File " + FILE_NAME);
	}
}
