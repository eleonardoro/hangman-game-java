package br.com.eleonardoro.hangman.core;

import java.util.HashSet;
import java.util.Set;

public class Word {
	
	private static final char SECRECT_CHAR = '_';
	
	private String originalWord;
	private Set<Character> foundChars = new HashSet<Character>();
	private Set<Character> wordChars = new HashSet<>();

	public Word(String originalWord) {
		this.originalWord = originalWord.toUpperCase();
		
		for(char c : this.originalWord.toCharArray())
			wordChars.add(c);
	}

	public String getOriginalWord() {return originalWord;}

	public void setOriginalWord(String originalWord) {this.originalWord = originalWord;}
	
	public int size() {return originalWord.length();}
	
	public boolean hasChar(char c) {
		c = Character.toUpperCase(c);
		
		if (originalWord.indexOf(c) > -1) {
			foundChars.add(c);
			return true;
		}
		
		return false;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for(char c : originalWord.toCharArray()) {
			
			if(foundChars.contains(c)) sb.append(c);
			else sb.append(SECRECT_CHAR); 
			
			sb.append(" ");
		}
		
		return sb.toString();
	}
	
	public boolean discovered() {
		return foundChars.equals(wordChars);
	}

}
