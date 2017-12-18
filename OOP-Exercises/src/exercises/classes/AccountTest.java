package exercises.classes;

class AccountTest {
	public static void main(String[] args) {
		Account account1 = new Account("101", "Peter", 1000);
		Account account2 = new Account("102", "Maria");
		System.out.println("Start:");
		System.out.println(account1);
		System.out.println(account2);
		account1.transferTo(account2, 300);
		System.out.println("After transfer:");
		System.out.println(account1);
		System.out.println(account2);
		account1.transferTo(account2, 800);
	}
}
