package by.htp.text;

import java.util.ArrayList;

import by.htp.text.consoleController.Controller;
import by.htp.text.symbols.Letter;
import by.htp.text.symbols.PunctuationSign;
import by.htp.text.symbols.Symbol;
import by.htp.text.words.Word;

public class Sentence {
	private ArrayList<Symbol> sentence ;
	private boolean finished;
	
	public Sentence() {
		sentence = new ArrayList<>();
	}
	
	public Sentence(ArrayList<Symbol> sentence ) {
		this.sentence = sentence;
	}
	
	public int lengthOfSentence() {
		return sentence.size();
	}
	
	public void addSymbol(Symbol s) {
		if ( finished ) {
			if(s.getValue() == '\n'){
				sentence.add(s);
			}
			Controller.printMessageToConsole("The sentence if finished!");
			return;
		}
		if(s instanceof PunctuationSign ) {
			PunctuationSign sign = (PunctuationSign) s;
			if(sign.isEndOfTheSentence()) {
				sentence.add(s);
				finished = true;
			}
			else {
				sentence.add(s);
			}
		}
		else {
			sentence.add(s);
		}
	}
	
	public void replaceSymbol(int i, Symbol s) throws IllegalArgumentException{
		if( i > sentence.size() || i < 0) {
			throw new IllegalArgumentException();
		}
		if( s == null) {
			return ;
		}
		sentence.set(i, s);
	}
	
	public void deleteSymbol(int i) throws IllegalArgumentException{
		if( i > sentence.size() || i < 0) {
			throw new IllegalArgumentException();
		}
		sentence.remove(i);
	}
	
	public Symbol getSymbol(int i)throws IllegalArgumentException{
		if( i > sentence.size() || i < 0) {
			throw new IllegalArgumentException();
		}
		return sentence.get(i);
	}
	
	public Letter getLetter(int i) throws IllegalArgumentException{
		if( i > sentence.size() || i < 0) {
			throw new IllegalArgumentException();
		}
		if( this.getSymbol(i) instanceof Letter) {
			return (Letter)sentence.get(i);
		}
		else {
			Controller.printMessageToConsole("There is no letter at " +i+" position");
			return null;
		}
	}
	
	public void addWord(Word w) {
		if ( finished ) {
			Controller.printMessageToConsole("The sentence if finished!");
			return;
		}
		for(int i = 0 ; i < w.wordLength() ; ++i) {
			addSymbol(w.getWord().get(i));
		}
	}
	
	public int findWord(Word w) {
		if( w == null) {
			Controller.printMessageToConsole("Null pointer. Couldn't find word");
			return -1;
		}
		for(int i = 0 ; i < sentence.size(); ++i ) {
			int tempFlag = 0;
			for(int j = 0 ; j < w.wordLength() ; ++j) {
				if( (i+j) < sentence.size() && w.getLetter(j).equals(sentence.get(i+j) ) ) {
					tempFlag++;
				}
				else {
					break;
				}
				if(tempFlag == w.wordLength()) {
					return i;
				}
			}
		}
		return -1;
	}
	
	public void replaceWord(Word oldWord, Word newWord) {
		if( oldWord == null || newWord == null) {
			return ;
		}
		int index = findWord(oldWord);
		if ( index >=0 ) {
			for(int i = 0 ; i < oldWord.wordLength(); ++i) {
				sentence.remove(index);
			}
			for(int i = 0 ; i < oldWord.wordLength(); ++i) {
				sentence.add(index+i, newWord.getLetter(i));
			}
		}
	}
	
	public void deleteWord(Word deletingWord) {
		if( deletingWord == null ) {
			return ;
		}
		int index = findWord(deletingWord);
		if ( index >=0 ) {
			for(int i = 0 ; i < deletingWord.wordLength(); ++i) {
				sentence.remove(index);
			}
		}
	}
	
	public void deleteWord(int index) throws IllegalArgumentException{
		if( index > this.getWords().length || index < 0) {
			throw new IllegalArgumentException();
		}
		deleteWord( getWords()[index] );
	}
	
	public Word[] getWords() {
		ArrayList<Word> words = new ArrayList<Word>();
		Word curWord;
		for(int i = 0 ; i < lengthOfSentence() ; ) {
			curWord = new Word();
			while(!curWord.isCompleted())
			{
				curWord.appendWordByLetterOrDigit(sentence.get(i));
				i++;
			}
			words.add(curWord);
			i++;
		}
		return words.toArray(new Word[words.size()]);
	}
	
	public void removeExtraSpaces() {
		for(int i = 0 ; i < sentence.size() ; ++i) {
			if(sentence.get(i) instanceof PunctuationSign) {
				PunctuationSign sign = (PunctuationSign) sentence.get(i);
				sign.changeToSingleSpace();
				sentence.set(i, sign);
			}
		}
		for(int i = 0 ; i < sentence.size() ; ++i) {
			if(sentence.get(i) instanceof PunctuationSign) {
				PunctuationSign firstSign = (PunctuationSign) sentence.get(i);
				for ( int j = i + 1  ; j < sentence.size() ; ) {
					PunctuationSign secondSign = (PunctuationSign) sentence.get(j);
					if(firstSign.equals(secondSign)) {
						sentence.remove(j);
					}
				}
			}
		}
	}

	@Override
	public boolean equals(Object obj) {
		Sentence second = (Sentence)obj;
		for(int i = 0 ; i < sentence.size() ; ++i ) {
			if(!this.getSymbol(i).equals(second.getSymbol(i))) {
				return false;
			}
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for(int i = 0 ; i < sentence.size() ; ++i) {
			builder.append(sentence.get(i));
		}
		return builder.toString();
	}
}