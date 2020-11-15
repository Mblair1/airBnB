package airBnB;


public class Rental {
	public String startDate;
	public String endDate;
	private double cost;
	private Account renter;
	private int ID = (int) (Math.random() * 10000) + 1;
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
		System.out.println("Start date is " + startDate);
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		System.out.println("End date is " + endDate);
		this.endDate = endDate;
	}
	public Rental() {
		
	}
	public Account getRenter() {
		return renter;
	}
	public void setRenter(Account renter) {
		this.renter = renter;
	}
	public int getID() {
		return ID;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
}
