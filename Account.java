package airBnB;

public class Account {

	public String username;
	private String password;
	private String firstName;
	private String lastName;
	
	
	public Account(String username, String password) {
		this.username = username;
		this.password = password;
	}
	public Account() {
		
	}
	public void signUp() {
		System.out.println(this.username + " has signed up!");
	}
	public void signIn() {
		System.out.println(this.username + " is signed in.");
	}
	
	public void signOut() {
		System.out.println(this.username + " is signed out.");
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
