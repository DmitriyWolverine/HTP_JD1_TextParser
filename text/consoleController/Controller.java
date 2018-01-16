package by.htp.text.consoleController;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

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
	
	public static ArrayList<Symbol> readSymobolsFromFile() {
		printMessageToConsole("Enter name of file with text");
		String fileName = getStringFromConsole();
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
}
