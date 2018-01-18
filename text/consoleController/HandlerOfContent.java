package by.htp.text.consoleController;

import java.util.HashMap;
import java.util.List;

import by.htp.text.Paragraph;
import by.htp.text.Sentence;
import by.htp.text.Text;
import by.htp.text.symbols.Symbol;

public class HandlerOfContent {
	private Text text;
	
	public HandlerOfContent(List<Symbol> symbols) throws IllegalArgumentException{
		if(symbols == null) {
			throw new IllegalArgumentException();
		}
		//initialize list of sentences from symbols
		List<Sentence> sentences  = Controller.initializeSentences(symbols);
		//initialize paragraphs from sentences
		List<Paragraph> paragraphs = Controller.initializeParagraphs(sentences);
		//create and initialize text
		this.text = Controller.initializeText(paragraphs);
	}
	
	public HandlerOfContent(Text text) {
		this.text = text;
	}
	
	public HashMap<String, Integer> countWordsFrequency(){
		String [] textInWords = text.toString().split("['\",;:.!?\\s]+");
		HashMap<String, Integer> map = new HashMap<>();
		for(int i = 0 ; i < textInWords.length; ++i) {
			if(map.containsKey(textInWords[i])) {
				map.put(textInWords[i],  map.get(textInWords[i]) + 1 );
			}
			else {
				map.put(textInWords[i],  1 );
			}
		}
		return map;
	}
	
	/*private String findLongestSubstring() {
		HashMap<Character,Integer> mapInRightOrder = new HashMap<>();
		for(int i = 0 ; i < text.length() ; ++i) {
			for(int j = text.length() - 1 ; j>=i; j--) {
				if(text.charAt(i) == text.charAt(j) && !mapInRightOrder.containsKey(text.charAt(i)) ) {
					mapInRightOrder.put(
							text.charAt(i), text.lastIndexOf(text.charAt(j)) - text.indexOf(text.charAt(i)) );
					break;
				}
			}
		}
		int maxLength = 0;
		char maxlengthSymbol = '~';
		for(HashMap.Entry<Character, Integer> pair: mapInRightOrder.entrySet()) {
			if(pair.getValue() > maxLength) {
				maxLength = pair.getValue();
				maxlengthSymbol = pair.getKey();
			}
		}
		return text.substring(text.indexOf(maxlengthSymbol), text.lastIndexOf(maxlengthSymbol) +1);
	}
	
	public String cutString() {
		return text.replaceAll(findLongestSubstring(), "");
	}
	 	*/
}
