package by.htp.text.symbols;

public class Letter extends Symbol{
	public Letter(char value) throws IllegalArgumentException{
		super(value);
		if( !super.isDigitOrLetter() ) {
			throw new IllegalArgumentException();
		}
	}
	
	public boolean isLetter() {
		if( Character.isLetter(super.getValue())) {
			return true;
		}
		return false;
	}
	
	public boolean isDigit() {
		if( Character.isDigit(super.getValue())) {
			return true;
		}
		return false;
	}
}
