package atm_Project;

import java.util.*;
import java.text.*;
import java.io.*;



//Account Class Starts...


class Account {

	Scanner input = new Scanner(System.in);
	DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

	public int setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
		return customerNumber;
	}

	public int getCustomerNumber() {
		return customerNumber;
	}

	public int setPinNumber(int pinNumber) {
		this.pinNumber = pinNumber;
		return pinNumber;
	}

	public int getPinNumber() {
		return pinNumber;
	}

	public double getCheckingBalance() {
		return checkingBalance;
	}

	public double getSavingBalance() {
		return savingBalance;
	}

	
	//method for calculating the amount remaining after the amount withdrawn from checking account
	public double calcCheckingWithdraw(double amount) {
		checkingBalance = (checkingBalance - amount);
		return checkingBalance;
	}

	//method for calculating the amount remaining after the amount withdrawn from savings account
	public double calcSavingWithdraw(double amount) {
		savingBalance = (savingBalance - amount);
		return savingBalance;
	}

	//method for calculating the amount remaining after the amount deposit in checking account
	public double calcCheckingDeposit(double amount) {
		checkingBalance = (checkingBalance + amount);
		return checkingBalance;
	}

	//method for calculating the amount remaining after the amount deposit in savings account
	public double calcSavingDeposit(double amount) {
		savingBalance = (savingBalance + amount);
		return savingBalance;
	}
 
	
	//method for taking the withdrawal amount from checking account
	public void getCheckingWithdrawInput() {
		System.out.println("Checking Account Balance: " + moneyFormat.format(checkingBalance));
		System.out.print("Amount you want to withdraw from Checking Account: ");
		double amount = input.nextDouble();

		if ((checkingBalance - amount) >= 0) {
			calcCheckingWithdraw(amount);
			try {
				Thread.sleep(1000);
			} catch (Exception e) {}
			System.out.println("New Checking Account Balance: " + moneyFormat.format(checkingBalance));
		} else {
			System.out.println("Balance Cannot be Negative." + "\n");
		}
	}

	
	//method for taking the withdrawal amount from savings account
	public void getsavingWithdrawInput() {
		System.out.println("Saving Account Balance: " + moneyFormat.format(savingBalance));
		System.out.print("Amount you want to withdraw from saving Account: ");
		double amount = input.nextDouble();

		if ((savingBalance - amount) >= 0) {
			calcSavingWithdraw(amount);
			try {
				Thread.sleep(1000);
			} catch (Exception e) {}
			System.out.println("New saving Account Balance: " + moneyFormat.format(savingBalance));
		} else {
			System.out.println("Balance Cannot be Negative." + "\n");
		}
	}

	//method for taking the deposit amount for checking account
	public void getCheckingDepositInput() {
		System.out.println("Checking Account Balance: " + moneyFormat.format(checkingBalance));
		System.out.print("Amount you want to Deposit from Checking Account: ");
		double amount = input.nextDouble();

		if ((checkingBalance + amount) >= 0) {
			calcCheckingDeposit(amount);
			try {
				Thread.sleep(1000);
			} catch (Exception e) {}
			System.out.println("New Checking Account Balance: " + moneyFormat.format(checkingBalance));
		} else {
			System.out.println("Balance Cannot be Negative." + "\n");
		}
	}

	//method for taking the deposit amount for savings account
	public void getSavingDepositInput() {
		System.out.println("Saving Account Balance: " + moneyFormat.format(savingBalance));
		System.out.print("Amount you want to Deposit from saving Account: ");
		double amount = input.nextDouble();

		if ((savingBalance + amount) >= 0) {
			calcSavingDeposit(amount);
			try {
				Thread.sleep(1000);
			} catch (Exception e) {}
			System.out.println("New saving Account Balance: " + moneyFormat.format(savingBalance));
		} else {
			System.out.println("Balance Cannot be Negative." + "\n");
		}
	}

	private int customerNumber;
	private int pinNumber;
	private double checkingBalance = 0;
	private double savingBalance = 0;
}


//Account Class Ends.



//Option Menu Class Starts....

 class OptionMenu extends Account 
 {
	Scanner menuInput = new Scanner(System.in);
	DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

	HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();

	public void getLogin() throws IOException {
		int x = 1;
		do {
			try {
				data.put(952141, 191904); //these two are the account number with respect to its account pin (acc. number, acc. pin);
				data.put(989947, 71976);


				System.out.println("\t\t  _________________________");
				System.out.println("\t\t |                         |");
				System.out.println("\t\t |      Welcome To ATM!    |");
				System.out.println("\t\t |_________________________|");
				for(int i =1;i<=10;i++)
				{
					Thread.sleep(200);
					System.out.print(".....");
				}
				
				System.out.println("\n------------ Enter your Account Number: ----------");
				setCustomerNumber(menuInput.nextInt());
                 Thread.sleep(500);
				System.out.print("---------- Enter your PIN Number: ---------- \n");
				setPinNumber(menuInput.nextInt());
				 Thread.sleep(500);
			} catch (Exception e) {
				System.out.println("\n" + "Invalid Character(s). Only Numbers." + "\n");
				x = 2;
			}
			
			int cn = getCustomerNumber();
			int pn = getPinNumber();
			if (data.containsKey(cn) && data.get(cn) == pn) {
				getAccountType();
			} else
				System.out.println("\n" + "Wrong Customer Number or Pin Number" + "\n");
		} while (x == 1);
	}

	public void getAccountType() {
		System.out.println("----------Welcome User----------");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {}
			
		System.out.println("Select the Account you Want to Access: ");
		System.out.println(" Type 1 - Checking Account");
		System.out.println(" Type 2 - Savings Account");
		System.out.println(" Type 3 - Exit");

		int selection = menuInput.nextInt();

		switch (selection) {
		case 1:
			getChecking();
			break;

		case 2:
			getSaving();
			break;

		case 3:
			System.out.println("Thank You for using this ATM. \nBye.  \n");
			System.exit(0);

		default:
			System.out.println("\n" + "Invalid Choice." + "\n");
			getAccountType();
		}
	}

	public void getChecking() {
		System.out.println("----------- Checking Account: ----------- ");
		System.out.println(" Type 1 - View Balance");
		System.out.println(" Type 2 - Withdraw Funds");
		System.out.println(" Type 3 - Deposit Funds");
		System.out.println(" Type 4 - Exit");
		System.out.print("Choice: ");

		int selection = menuInput.nextInt();

		switch (selection) {
		case 1:
			System.out.println("Checking Account Balance: " + moneyFormat.format(getCheckingBalance()));
			try {
				Thread.sleep(150);
			} catch (Exception e) {	}
			getChecking();
			break;

		case 2:
			getCheckingWithdrawInput();
			try {
				Thread.sleep(150);
			} catch (Exception e) {	}
			getChecking();
			break;

		case 3:
			getCheckingDepositInput();
			try {
				Thread.sleep(150);
			} catch (Exception e) {	}
			getChecking();
			break;

		case 4:
			System.out.println("Thank You for using this ATM. \nBye.  \n");
			System.exit(0);
			
		default:
			System.out.println("\n" + "Invalid Choice." + "\n");
			getChecking();
		}
	}

	public void getSaving() {
		System.out.println("----------- Savings Account: ----------");
		System.out.println(" Type 1 - View Balance");
		System.out.println(" Type 2 - Withdraw Funds");
		System.out.println(" Type 3 - Deposit Funds");
		System.out.println(" Type 4 - Exit");
		System.out.print("Choice: ");

		int selection = menuInput.nextInt();

		switch (selection) {
		case 1:
			System.out.println("Savings Account Balance: " + moneyFormat.format(getSavingBalance()));
			try {
				Thread.sleep(150);
			} catch (Exception e) {	}
			getSaving();
			break;

		case 2:
			getsavingWithdrawInput();
			try {
				Thread.sleep(150);
			} catch (Exception e) {	}
			getSaving();
			break;

		case 3:
			getSavingDepositInput();
			try {
				Thread.sleep(150);
			} catch (Exception e) {	}
			getSaving();
			break;
		case 4:
			System.out.println("Thank You for using this ATM. \nBye.  \n");
			System.exit(0);

		default:
			System.out.println("\n" + "Invalid Choice." + "\n");
			getChecking();
		}
	}

}
 
//Option Menu Class Ends..



public class ATM extends OptionMenu {

	public static void main(String[] args) throws IOException 
	{
		OptionMenu optionMenu = new OptionMenu();

		optionMenu.getLogin();
	}

}




