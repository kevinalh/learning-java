package exercises.composition;

public class BookTest {
	public static void main(String[] args) {
		Author[] authors = new Author[2];
		authors[0] = new Author("Bert Bates", "bert@example.com", 'm');
		authors[1] = new Author("Kathy Sierra", "kathy@example.com", 'f');
		Book book = new Book("Head First Java", authors, 21.88, 44);
		System.out.println(book);
		System.out.println("Authors: " + book.getAuthorNames());
		System.out.println("There are " + Author.getAmount() + " authors right now");
		Author another = new Author("Dross", "dross@example.com", 'm');
		System.out.println("And now, " + Author.getAmount() + " authors");
		Book newbook = new Book("Pluto Moon", another, 15.99, 100);
		System.out.println(newbook);
	}
}
