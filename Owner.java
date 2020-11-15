package airBnB;

public class Owner extends Account {
	

	private int ID;
	private String cardInfo;
	private String address;
	
	public Owner(String username, String password) {
		super(username, password);
	}
	

	private void bookmark(House house) {
		System.out.println(house.toString() + " has been bookmarked.");
	}

}
