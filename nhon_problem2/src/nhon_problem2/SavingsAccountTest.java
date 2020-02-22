package nhon_problem2;

public class SavingsAccountTest {

	public static void main(String[] args) {
		SavingsAccount saver1 = new SavingsAccount(2000);
		SavingsAccount saver2 = new SavingsAccount(3000);
		System.out.println("Saver 1 Account");
		System.out.println("========================");
		saver1.modifyInterestRate(0.04);
		saver1.calculateMonthlyInterest();
			
		System.out.println("Saver 2 Account");
		System.out.println("========================");
		saver2.modifyInterestRate(0.04);
		saver2.calculateMonthlyInterest();
		
	}

}
