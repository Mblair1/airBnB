package airBnB;

public class Account {

	public String username;
	private String password;
	private String firstName;
	private String lastName;
	
	private void signIn() {
		System.out.println(this.username + " is signed in.");
	}
	
	private void signOut() {
		System.out.println(this.username + " is signed out.");
	}
}
