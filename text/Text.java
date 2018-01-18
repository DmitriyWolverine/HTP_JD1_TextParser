package by.htp.text;

import java.util.ArrayList;
import java.util.List;

public class Text {
	private String title;
	private List<Paragraph> paragraphs;
	//private List<Sentence> sentences;
	
	public Text() {
		title = "Empty title";
		this.paragraphs = new ArrayList<Paragraph>();
	}
	
	public Text(ArrayList<Paragraph> paragraphs) {
		super();
		if(paragraphs!=null)
			this.paragraphs = paragraphs;
	}

	public Text(String title, ArrayList<Paragraph> paragraphs) {
		super();
		if(paragraphs!=null && title !=null)
		this.title = title;
		this.paragraphs = paragraphs;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Paragraph> getParagraphs() {
		return paragraphs;
	}

	public void setParagraphs(List<Paragraph> paragraphs) {
		this.paragraphs = paragraphs;
	}
	
	public int getLengthInSentences() {
		int res = 0;
		for(int i = 0 ; i < paragraphs.size() ; ++i ) {
			res += paragraphs.get(i).sentencesNumber();
		}
		return res;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for(int i = 0 ; i < paragraphs.size() ; ++i) {
			builder.append(paragraphs.get(i));
		}
		return builder.toString();
	}
	
}
