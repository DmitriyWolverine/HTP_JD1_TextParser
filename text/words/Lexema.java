package by.htp.text.words;

import java.util.ArrayList;

import by.htp.text.consoleController.Controller;
import by.htp.text.symbols.Letter;
import by.htp.text.symbols.Symbol;

public class Lexema extends Word{
	
	@Override
	public void insertLetter(int i, Letter l) {
		if(l.isLetter()) {
			super.insertLetter(i, l);
		}
	}

	@Override
	public void replaceLetter(int i, Letter l) {
		if(l.isLetter()) {
			super.replaceLetter(i, l);
		}
	}

	@Override
	public void removeOneLetter(Letter l) {
		if(l.isLetter()) {
			super.removeOneLetter(l);
		}
	}

	@Override
	public void removeAllLetters(Letter l) {
		if(l.isLetter()) {
			super.removeAllLetters(l);
		}
	}

	@Override
	public void setWord(ArrayList<Symbol> word) {
		for(int i = 0 ; i < word.size() ; ++i) {
			Letter curLetter = (Letter)word.get(i);
			if(!curLetter.isLetter() ) {
				Controller.printMessageToConsole("Lexema should consist only of letters(no numbers) ");
				return;
			}
		}
		super.setWord(word);
	}

	@Override
	public void appendWordByLetterOrDigit(Symbol s) {
		if(s!=null) {	
			if(s instanceof Letter ) {
				Letter l = (Letter)s;
				if(l.isLetter()) {
					super.appendWordByLetterOrDigit(l);
				}
			}
			else
			{
				super.setCompleted(true);
			}
		}
	}

	@Override
	public String toString() {
		return super.toString().toLowerCase();
	}
}