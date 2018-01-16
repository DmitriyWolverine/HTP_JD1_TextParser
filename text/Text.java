package by.htp.text;

import java.util.ArrayList;

public class Text {
	private String title;
	private ArrayList<Paragraph> paragraphs;
	
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

	public ArrayList<Paragraph> getParagraphs() {
		return paragraphs;
	}

	public void setParagraphs(ArrayList<Paragraph> paragraphs) {
		this.paragraphs = paragraphs;
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
