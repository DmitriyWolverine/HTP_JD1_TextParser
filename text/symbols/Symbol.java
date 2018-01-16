package by.htp.text.symbols;

public class Symbol {
	private char value;

	public Symbol(char value) {
		this.value = value;
	}

	public Symbol(String value) {
		if(value!= null && value.length()>=1)
			this.value = value.charAt(0);
	}
	
	public char getValue() {
		return value;
	}

	public void setValue(char value) {
		this.value = value;
	}

	@Override
	public int hashCode() {
		return (int)value;
	}

	@Override
	public boolean equals(Object obj) throws IllegalArgumentException{
		if(obj instanceof Character) {
			Character secondValue = (Character) obj;
			if(value == secondValue.charValue() ) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return ""+value;
	}
	
	public boolean isDigitOrLetter() {
		if( Character.isLetterOrDigit(value) ) {
			return true;
		}
		return false;
	}
	
	public void replaceSymbol(Symbol s) {
		setValue(s.getValue());
	}
	
}