package airBnB;

public interface Transaction {
	public void process(Rental rental);
	public void cancel(Rental rental);
	public void addCharge(Rental rental, int charge);
}
