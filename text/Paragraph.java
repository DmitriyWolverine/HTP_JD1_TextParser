package by.htp.text;

import java.util.ArrayList;
import java.util.List;

import by.htp.text.symbols.Symbol;

public class Paragraph {
	private List<Sentence> paragraph ;
	private boolean finished;
	
	public Paragraph() {
		super();
		this.paragraph = new ArrayList<Sentence>();
	}
	
	public Paragraph(ArrayList<Sentence> paragraph) {
		super();
		Sentence lastSentence = this.getSentence(paragraph.size() - 1 );
		if( lastSentence.getSymbol(lastSentence.lengthOfSentence()-1).getValue() == '\n') {
			finished = true;
		}
		this.paragraph = paragraph;
	}
	
	public void addSentence(Sentence s) {
		if(finished) {
			return;
		}
		if (s != null) {
			paragraph.add(s);
		}
		if(s.getSymbol(s.lengthOfSentence()-1).getValue() == '\n') {
			finished = true;
		}
	}
	
	public Sentence getSentence(int i) throws IllegalArgumentException{
		if( i > paragraph.size() || i < 0) {
			throw new IllegalArgumentException();
		}
		return paragraph.get(i);
	}
	
	public void deleteSentence(int i) throws IllegalArgumentException{
		if( i > paragraph.size() || i < 0) {
			throw new IllegalArgumentException();
		}
		paragraph.remove(i);
	}
	
	public ArrayList<Symbol> toSymbols() {
		ArrayList<Symbol> res = new ArrayList<Symbol>();
		for(int i = 0 ; i < paragraph.size() ; ++i) {
			for(int j = 0 ; j < paragraph.get(i).lengthOfSentence() ; ++j ) {
				res.add(paragraph.get(i).getSymbol(j));
			}
		}
		return res;
	}

	public List<Sentence> getParagraph() {
		return paragraph;
	}

	public void setParagraph(ArrayList<Sentence> paragraph) {
		this.paragraph = paragraph;
	}

	public boolean isFinished() {
		return finished;
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
	}
	
	public int sentencesNumber() {
		return paragraph.size();
	}

	@Override
	public boolean equals(Object obj) {
		Paragraph second = (Paragraph)obj;
		for(int i = 0 ; i < paragraph.size() ; ++i ) {
			if(!this.getSentence(i).equals(second.getSentence(i))) {
				return false;
			}
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for(int i = 0 ; i < paragraph.size() ; ++i) {
			builder.append(paragraph.get(i));
		}
		return builder.toString();
	}
	
}
