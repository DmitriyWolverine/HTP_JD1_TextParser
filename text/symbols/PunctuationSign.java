package by.htp.text.symbols;

public class PunctuationSign extends Symbol {
	public PunctuationSign(char value) throws IllegalArgumentException{
		super(value);
		if( super.isDigitOrLetter() == true) {
			throw new IllegalArgumentException();
		}
	}

	public boolean isSpace() {
		if( Character.isWhitespace(getValue()) ) {
			return true;
		}
		return false;
	}
	
	public void changeToSingleSpace() {
		if(isSpace()) {
			replaceSymbol(new PunctuationSign(' '));
		}
	}
	
	public boolean isEndOfTheSentence() {
		if( super.getValue() == '!' ||  super.getValue() == '?' || super.getValue() == '.' || super.getValue() == ':') {
			return false;
		}
		return true;
	}
}