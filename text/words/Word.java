package by.htp.text.words;

import java.util.ArrayList;
import java.util.List;

import by.htp.text.consoleController.Controller;
import by.htp.text.symbols.Letter;
import by.htp.text.symbols.Symbol;

public class Word {
	private List<Symbol> word;
	private boolean completed = false;
	
	public Word() {
		word = new ArrayList<Symbol>();
	}
	public void appendWordByLetterOrDigit(Symbol s) {
		if(s!=null) {	
			if(s instanceof Letter) {
				word.add(s);
			}
			else
			{
				if( word.size()>0 ) {
					completed = true;
				}
			}
		}
	}
	
	public Letter getLetter(int i) throws IllegalArgumentException{
		if( i > word.size() || i < 0) {
			throw new IllegalArgumentException();
		}
		return (Letter)word.get(i);
	}
	
	public void insertLetter( int i, Letter l ) throws IllegalArgumentException{
		if( i > word.size() || i < 0) {
			throw new IllegalArgumentException();
		}
		if(l == null) {
			return;
		}
		if( i == word.size()) {
			appendWordByLetterOrDigit(l);
		}
		else {
			word.add(i, l);
		}
	}
	
	public void replaceLetter (int i , Letter l) throws IllegalArgumentException{
		if( i > word.size() || i < 0) {
			throw new IllegalArgumentException();
		}
		if(l == null) {
			return;
		}
		else {
			word.set(i, l);
		}
	}
	
	public void removeOneLetter( int i ) throws IllegalArgumentException{
		if( i > word.size() || i < 0) {
			throw new IllegalArgumentException();
		}
		word.remove(i);
	}
	
	public void removeOneLetter(Letter l) {
		if(l == null) {
			return;
		}
		for (int i = 0 ; i < word.size() ; ++i ) {
			if(word.get(i).equals(l) ) {
				word.remove(i);
				break;
			}
		}
	}
	
	public void removeAllLetters(Letter l) {
		if(l == null) {
			return;
		}
		for (int i = 0 ; i < word.size() ; ++i ) {
			if(word.get(i).equals(l) ) {
				word.remove(i);
			}
		}
	}
	
	public List<Symbol> getWord() {
		return word;
	}
	
	public void setWord(ArrayList<Symbol> word) {
		this.word = word;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	
	public int wordLength() {
		if( completed ) {
			Controller.printMessageToConsole("Word is not finished!");
		}
		return word.size();
	}
	
	@Override
	public String toString() {
		StringBuilder result =  new StringBuilder("");
		if(completed == true)
		{
			for( int i = 0 ; i < word.size() ; ++i) {
				result.append(word.get(i));
			}
		}
		return result.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Word) {
			Word secondValue = (Word) obj;
			int temp=0;
			for(int i = 0 ; i < word.size(); ++i) {
				if(word.get(i).equals(secondValue.getWord().get(i)) ) {
					temp++;
				}
				else {
					return false;
				}
			}
			if(temp == word.size()) {
				return true;
			}
		}
		return false;
	}
}