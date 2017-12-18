package exercises.composition;

public class Author {
	static private int amountAuthors;
	private final String name;
	private String email;
	private final char gender;
	
	public Author(String name, String email, char gender) {
		this.name = name;
		this.email = email;
		this.gender = gender;
		amountAuthors++;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String getName() {
		return this.name;
	}
	
	public char getGender() {
		return this.gender;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String toString() {
		return String.format("Author[name=%s,email=%s,gender=%c]", this.name, this.email, this.gender);
	}
	
	static public int getAmount() {
		return amountAuthors;
	}
}
