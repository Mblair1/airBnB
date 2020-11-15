package airBnB;

public class TransactionHandler implements Transaction {
	private static TransactionHandler INSTANCE = new TransactionHandler();
	
	public TransactionHandler() {
		
	}
	public static TransactionHandler getInstance() {
		return INSTANCE;
	}
	public void process(Rental rental) {
		
	}
	public void cancel(Rental rental) {
		
	}
	public void addCharge(Rental rental, int charge) {
		
	}
}
