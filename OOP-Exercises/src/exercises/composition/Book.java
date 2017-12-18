package exercises.composition;

public class Book {
	private final String name;
	private final Author[] authors;
	private double price;
	private int quantity = 0;
	
	public Book(String name, Author[] authors, double price) {
		this.name = name;
		this.authors = authors;
		this.price = price;
	}
	
	public Book(String name, Author[] authors, double price, int quantity) {
		this(name, authors, price);
		this.quantity = quantity;
	}
	
	public Book(String name, Author author, double price) {
		Author[] authors = new Author[1];
		authors[0] = author;
		this.price = price;
		this.name = name;
		this.authors = authors;
	}
	
	public Book(String name, Author author, double price, int quantity) {
		this(name, author, price);
		this.quantity = quantity;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Author[] getAuthors() {
		return this.authors;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public int getQuantity() {
		return this.quantity;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getAuthorNames() {
		String rt = "";
		for(Author author: this.authors) {
			rt += author.getName() + ",";
		}
		return rt.substring(0, rt.length()-1);
	}
	
	public String toString() {
		String rt = String.format("Book[name=%s,authors={", this.name);
		for(int i = 0; i < this.authors.length; ++i) {
			rt += authors[i].toString();
			if(i != this.authors.length - 1) rt += ",";
		}
		rt += String.format("},price=%.2f,quantity=%d]", this.price, this.quantity);
		return rt;
	}
}
