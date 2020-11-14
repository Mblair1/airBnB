package airBnB;

public class Renter extends Account {
	private int ID;
	private String cardInfo;
	private String address;
	
	private void bookmark(House house) {
		System.out.println(house.toString() + " has been bookmarked.");
	}

}
