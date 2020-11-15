package airBnB;

public class House implements Property{

	private int price;
	private String address;
	Account owner = new Account();
	
	public House(String address, int price) {
		this.address = address;
		this.price = price;
	}
	
	public void list(Rental rental) {
		System.out.println(rental.toString() + " has been listed.");
	}

	public void rent(Rental rental) {
		System.out.println(rental.toString() + " has been rented.");
	}
	private void setPrice(int newPrice) {
		this.price = newPrice;
		System.out.println("New price has been set to: " + newPrice);
	}
	public String toString() {
		return this.address;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPrice() {
		return price;
	}

	public Account getOwner() {
		return owner;
	}

}
