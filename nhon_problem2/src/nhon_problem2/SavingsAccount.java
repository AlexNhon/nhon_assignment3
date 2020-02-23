package nhon_problem2;
import java.text.DecimalFormat;

public class SavingsAccount {
	private static double annualInterestRate;
	private double savingsBalance;
	DecimalFormat dfbal = new DecimalFormat("$0.00");
	DecimalFormat dfrate = new DecimalFormat("0%");
	
	public SavingsAccount() {
		annualInterestRate = 0.0;
		savingsBalance = 0.0;
	}
	public SavingsAccount(double balance) {
		annualInterestRate = 0.0;
		savingsBalance = balance;
	}
	
	public void calculateMonthlyInterest() {
		double monthlyInterest = 0.0;
		
		System.out.println("Initial Balance: $" + savingsBalance);
		System.out.format("%-6s %-15s %1.15s \n", "Month", "Interest Rate", "Balance");
		
		for(int i = 0; i <= 12; i++) {
			if(i == 12) {
				modifyInterestRate(0.05);
				monthlyInterest = (savingsBalance * annualInterestRate) / 12.0;
				savingsBalance = savingsBalance + monthlyInterest;
				System.out.format("%-6s %-15s %1.15s \n", (i + 1), dfrate.format(annualInterestRate), dfbal.format(savingsBalance));
				break;
			}
			monthlyInterest = (savingsBalance * annualInterestRate) / 12.0;
			savingsBalance = savingsBalance + monthlyInterest;
			System.out.format("%-6s %-15s %1.15s \n", (i + 1), dfrate.format(annualInterestRate), dfbal.format(savingsBalance));
		}
		
		System.out.println("");
	}

	public void modifyInterestRate(double rate) {
		setInterestRate(rate);
	}
	private void setInterestRate(double rate) {
		annualInterestRate = rate;
	}

}
