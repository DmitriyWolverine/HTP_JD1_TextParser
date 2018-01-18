package by.htp.text;

import java.util.List;
import by.htp.text.consoleController.Controller;
import by.htp.text.symbols.Symbol;

public class TextTesting {

	public static void main(String[] args) {
		/*
		 * Blinov, Romanchik. page 195. And implementation for this "new text"
		 * all features from lesson 11
		 */
		//System.out.println();
		//reading book from console;
		List<Symbol> symbols = Controller.readSymobolsFromFile();
		
		//initialize list of sentences from symbols
		List<Sentence> sentences  = Controller.initializeSentences(symbols);
		
		//initialize paragraphs from sentences
		List<Paragraph> paragraphs = Controller.initializeParagraphs(sentences);
		
		//create and initialize text
		Text text = Controller.initializeText(paragraphs);
		
		Controller.writeSymobolsToFile(text);
	}
}
