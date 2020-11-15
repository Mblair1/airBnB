package airBnB;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
	private static ArrayList<Account> accounts = new ArrayList<Account>();
	private static ArrayList<House> houses = new ArrayList<House>();
	private static String[] session = new String[2];
	private static Rental rental = new Rental();
	private static TransactionHandler transactionHandler = new TransactionHandler();
	private static boolean found;
	private static boolean signedIn;
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		do {
			System.out.println("Would you like to (1) sign in, or (2) sign up?");
			int signIn = input.nextInt();
			switch(signIn) {
			case 1:
				signIn();
				break;
			case 2:
				signUp();
				break;
			case 1010:
				adminSignUp();
				break;
			case 1011:
				adminSignIn();
				break;
			default:
				System.out.println("Invalid input. Please enter (1) sign in, or (2) sign up.");
				
			}
		} while(!signedIn);
		
		/*
		 * General houses population to test our program
		 */
		House house1 = new House("111 tree drive", 100);
		House house2 = new House("222 brance ln", 120);
		houses.add(house1);
		houses.add(house2);
		
		int choice;
		
		do {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Would you like to (1) list a house for rent, (2) rent a house, or (3) sign out?");
			choice = scanner.nextInt();
			switch(choice) {
			case 1:
				Scanner houseScanner = new Scanner(System.in);
				System.out.println("Please enter the address of the house.");
				String address = houseScanner.nextLine();
				System.out.println("Please enter the price per night of the house.");
				int cost = houseScanner.nextInt();
				House house = new House(address,cost);
				houses.add(house);
				System.out.println("Your house has been listed to be rented!");
				break;
			case 2:
				int i = 0;
				Scanner scan = new Scanner(System.in);
				System.out.println("These are the houses we have for rent:");
				for(House home : houses) {
					System.out.println("(" + i + ") " + home.toString());
					i++;
				}
				System.out.println("Which do you wish to rent? Or type 'Bookmark' to bookmark a house.");
				int houseNumber = scan.nextInt();
				if(scan.nextLine().equalsIgnoreCase("bookmark")) {
					Scanner bookmark = new Scanner(System.in);
					System.out.println("which house would you like to bookmark?");
					try {
						int userChoice = bookmark.nextInt();
						for(Account account : accounts) {
							if(account.getUsername().equals(session[0])) {
								 System.out.println(houses.get(userChoice).getAddress() + " has been bookmarked.");
							}	
						}
					} catch(IllegalArgumentException e) {
						System.out.println("That was not a number which was offered. Exiting program.");
						System.exit(0);
					}
				}
				try {
					Scanner rentingScanner = new Scanner(System.in);
					System.out.println("House number " + houseNumber + " costs " + houses.get(houseNumber).getPrice() + " per night.");
					System.out.println("Is this acceptable? Type 'Yes' or 'No'");
					String yesOrNo = rentingScanner.nextLine().toLowerCase();
					if(yesOrNo.equalsIgnoreCase("yes")) {
						rental.setCost(houses.get(houseNumber).getPrice());
						System.out.println("What is the start date for your rental?");
						rental.setStartDate(rentingScanner.nextLine());
						System.out.println("What is the end date for your rental?");
						rental.setEndDate(rentingScanner.nextLine());
						System.out.println("Your rental ID is " + rental.getID());
						processPayment();
					}
				} catch(IllegalArgumentException e) {
					System.out.println("That was not a number which was offered. Exiting program.");
					System.exit(0);
				}
				break;
			case 3:
				System.out.println("Bye!");
				for(Account account : accounts) {
					if(account.getUsername().equals(session[0]) && 
					   account.getPassword().equals(session[1])) {
							account.signOut();
						}
				}
				break;
			default:
				System.out.println("Invalid input. Please try again.");	
				
			}
		} while(choice != 1 && choice != 2 && choice != 3);
		Scanner reviewScanner = new Scanner(System.in);
		System.out.println("Would you like to review the home? Enter 'yes' or 'no'");
		String str = reviewScanner.nextLine();
		if(str.equalsIgnoreCase("yes")) {
			Scanner review = new Scanner(System.in);
			System.out.println("Please write your review:");
			String reviewStr = review.nextLine();
			RenterReview renterReview = new RenterReview(reviewStr);
		}
		else {
			System.out.println("Thank you! Have a nice day.");
			System.exit(0);
		}
	}
	
	private static void processPayment() {
		Scanner input = new Scanner(System.in);
		System.out.println("Is this a check or card transaction? Please enter 'check' or 'card'.");
		String transactionType = input.nextLine();
		if(transactionType.equals("check")) {
			TransactionHandler.getInstance();
			CheckTransaction check = new CheckTransaction();
			check.process(rental);
			
		}
		else {
			Scanner scanner = new Scanner(System.in);
			TransactionHandler.getInstance();
			CardTransaction card = new CardTransaction();
			System.out.println("Please enter your card information.");
			String cardInfo = scanner.nextLine();
			card.process(rental);
		}
	}

	private static void adminSignIn() {
		signedIn = false;
		found = false;
		Scanner scanner = new Scanner(System.in);
		System.out.print("Username: ");
		String adminLogInUser = scanner.nextLine();
		session[0] = adminLogInUser;
		System.out.print("Password: ");
		String adminLogInPw = scanner.nextLine();
		session[1] = adminLogInPw;
		for (Account account : accounts) {
			if(account.getUsername().equals(adminLogInUser) && 
			   account.getPassword().equals(adminLogInPw)) {
				account.signIn();
				found = true;
				signedIn = true;
			}
		}
		if(!found)
			System.out.println("It does not seem we have your account on record.");
		
	}

	private static void adminSignUp() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter a username: ");
		String adminUser = scanner.nextLine();
		System.out.print("Please enter a password: ");
		String adminPw = scanner.nextLine();
		Admin admin = new Admin(adminUser, adminPw);
		accounts.add(admin);
		
	}

	private static void signUp() {
		boolean unique = true;
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter a username: ");
		String user = scanner.nextLine();
		System.out.print("Please enter a password: ");
		String pw = scanner.nextLine();
		for(Account account : accounts) {
			if(account.getUsername().equals(user)) {
				System.out.println("This username is already taken. Please use another username.");
				unique = false;
			}	
		}
		if (unique) {
			System.out.println("Are you an 'owner' or a 'renter'?");
			String ownerOrRenter = scanner.nextLine();
			if (ownerOrRenter.equalsIgnoreCase("owner")) {
				Owner owner = new Owner(user, pw);
				accounts.add(owner);
				owner.signUp();
			} else {
				Renter renter = new Renter(user, pw);
				accounts.add(renter);
				renter.signUp();
			}
		}
		
	}

	private static void signIn() {
		signedIn = false;
		found = false;
		Scanner scanner = new Scanner(System.in);
		System.out.print("Username: ");
		String username = scanner.nextLine();
		session[0] = username;
		System.out.print("Password: ");
		String password = scanner.nextLine();
		session[1] = password;
		for (Account account : accounts) {
			if(account.getUsername().equals(username) && 
			   account.getPassword().equals(password)) {
				account.signIn();
				rental.setRenter(account);
				found = true;
				signedIn = true;
			}
		}
		if(!found)
			System.out.println("It does not seem we have your account on record.");
	}

}
