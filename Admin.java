package airBnB;

public class Admin extends Account {
	

	private int ID;
	private String cardInfo;
	private String address;
	
	public Admin(String username, String password) {
		super(username, password);
	}
	

	public void ban(Account account) {
		System.out.println(account.getUsername() + "has been banned.");
	}

}
