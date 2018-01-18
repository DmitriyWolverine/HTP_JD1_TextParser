package by.htp.text.consoleController;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import by.htp.text.Paragraph;
import by.htp.text.Sentence;
import by.htp.text.Text;
import by.htp.text.symbols.Letter;
import by.htp.text.symbols.PunctuationSign;
import by.htp.text.symbols.Symbol;

public class Controller {
	
	public static void printMessageToConsole(String s) {
		System.out.println(s);
	}
	
	@SuppressWarnings("resource")
	public static String getStringFromConsole() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}
	
	public static List<Symbol> readSymobolsFromFile() {
		//printMessageToConsole("Enter name of file with text");
		//String fileName = getStringFromConsole();
		String fileName = "d:\\book\\Maugham.txt";
		try (FileReader reader = new FileReader(fileName) ){
			ArrayList<Symbol> symbols = new ArrayList<Symbol>();
			while ( reader.ready() ) {
				symbols.add( new Symbol( (char) reader.read() ) ) ;
			}
			return symbols;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ArrayList<Symbol>();
	}
	
	public static void writeSymobolsToFile(Text text) {
		//printMessageToConsole("Enter name of file to write the text");
		//String fileName = getStringFromConsole();
		String fileName = "d:\\book\\Maugham1.txt";
		try (FileWriter writer = new FileWriter(fileName) ){
			String textStr = text.toString();
			writer.append(textStr);
			writer.flush();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//initialize list of sentences from symbols
	public static List<Sentence> initializeSentences(List<Symbol> symbols) throws IllegalArgumentException{
		if(symbols == null) {
			throw new IllegalArgumentException();
		}
		List<Sentence> sentences = new ArrayList<>();
		for(int i = 0 ; i < symbols.size() ; ++i) {
			Sentence curSentence = new Sentence();
			while(i <  symbols.size())
			{
				if( !symbols.get(i).isDigitOrLetter()   ) {
					PunctuationSign sign = new PunctuationSign(symbols.get(i).getValue());
					curSentence.addSymbol(sign);
					if ( curSentence.isFinished() ) {
						/*i++;
						curSentence.addSymbol(symbols.get(i));*/
						break;
					}
				}
				else {
					Letter letter =  new Letter(symbols.get(i).getValue());
					curSentence.addSymbol(letter);
				}
				i++;
			}
			printMessageToConsole(curSentence.toString());
			sentences.add(curSentence);
		}
		return sentences;
	}
	
	//initialize paragraphs from sentences
		public static List<Paragraph> initializeParagraphs(List<Sentence> sentences) throws IllegalArgumentException{
			if(sentences == null) {
				throw new IllegalArgumentException();
			}
			List<Paragraph> paragraphs = new ArrayList<>();
			for(int i = 0 ; i < sentences.size() ; ++i) {
				Paragraph curParagraph = new Paragraph();
				while(i <  sentences.size())
				{
					curParagraph.addSentence(sentences.get(i));
						if ( curParagraph.isFinished() ) {
							i++;
							break;
						}
					i++;
				}
				paragraphs.add(curParagraph);
			}
			return paragraphs;
	}
		
	//create and initialize text
	public static Text initializeText(List<Paragraph> paragraphs) throws IllegalArgumentException{
		if(paragraphs == null) {
			throw new IllegalArgumentException();
		}
		Text text = new Text();
		text.setParagraphs(paragraphs);
		return text;
	}
	
	public void removeExtraSpacesInText(List<Symbol> symbols) {
		for(int i = 0 ; i < symbols.size() ; ++i) {
			if(symbols.get(i) instanceof PunctuationSign) {
				PunctuationSign sign = (PunctuationSign) symbols.get(i);
				sign.changeToSingleSpace();
				symbols.set(i, sign);
			}
		}
		for(int i = 0 ; i < symbols.size() ; ++i) {
			if(symbols.get(i) instanceof PunctuationSign) {
				PunctuationSign firstSign = (PunctuationSign) symbols.get(i);
				for ( int j = i + 1  ; j < symbols.size() ; ) {
					PunctuationSign secondSign = (PunctuationSign) symbols.get(j);
					if(firstSign.equals(secondSign)) {
						symbols.remove(j);
					}
				}
			}
		}
	}	
}