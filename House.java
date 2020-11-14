package airBnB;

public class House implements Property{

	private int price;
	
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

}
