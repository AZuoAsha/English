package cdut.cn;

public class Word {

	private String ID;
	private String words;
	private String book;
	private String section;
	private String chinese;
	/**
	 * @param ID
	 * @param words
	 * @param grade
	 * @param section
	 * @param chinese
	 */
	public Word(String ID, String words, String book, String section, String chinese) {
		super();
		this.ID = ID;
		this.words = words;
		this.book = book;
		this.section = section;
		this.chinese = chinese;
	}
	/**
	 * 
	 */
	public Word() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getID() {
		return ID;
	}
	public void setID(String ID) {
		this.ID = ID;
	}
	public String getWords() {
		return words;
	}
	public void setWords(String words) {
		this.words = words;
	}
	public String getBook() {
		return book;
	}
	public void setGrade(String book) {
		this.book = book;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getChinese() {
		return chinese;
	}
	public void setChinese(String chinese) {
		this.chinese = chinese;
	}
	@Override
	public String toString() {
		return "Word [ID=" + ID + ", words=" + words + ", book=" + book + ", section=" + section + ", chinese=" + chinese
				+ "]";
	}
	
}
