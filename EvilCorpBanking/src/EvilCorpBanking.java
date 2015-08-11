import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class EvilCorpBanking {

	public static void main(String[] args){
		
		//initializing objects
		Scanner sc = new Scanner(System.in);
		BankAccount myBankAccount = new BankAccount();
		Transaction myTransaction = new Transaction();
		Date myDate = new Date();
		SimpleDateFormat f = new SimpleDateFormat("MM/dd/yyyy");
		HashMap<Integer, BankAccount> myHashMap = new HashMap<Integer, BankAccount>();
		int accountno = 0;
		
		//Prompt user to enter account information and store it
		System.out.println("Welcome to Evil Corp Savings and Loan");
		System.out.println("Please create the user account(s)");
	
		
		
		
		System.out.print("Enter an account # or -1 to stop entering accounts : ");
		accountno = sc.nextInt();
		
		while (accountno != -1)
		{
			if (!myHashMap.containsKey(accountno))
			{
				myBankAccount.setAccountno(accountno);
				System.out.print("Enter the name for accout number " + accountno + " : ");
				String name = sc.nextLine();
				sc.nextLine();
				myBankAccount.setName(name);
				System.out.print("Enter the balance for account number " + accountno + " : ");
				double balance = sc.nextDouble();
				myBankAccount.setBalance(balance);
				myHashMap.put(accountno, myBankAccount);
				System.out.println("\r\r\r");
			}
			else
			{
				System.out.println("Bank Account already exists. \r");
			}
			
			System.out.println("Enter an account # or -1 to stop entering accounts : ");
			accountno = sc.nextInt();
			sc.nextLine();
			
		}	
		
		System.out.println("\r\r");

		System.out.print("Enter a transaction type (Deposit or Withdrawal) or -1 to finish : ");
		String transactiontype = sc.next();
		sc.nextLine();

		BankAccount getBankAccount = new BankAccount();
		
		while (!transactiontype.equalsIgnoreCase("-1"))
		{	
			if (transactiontype.equalsIgnoreCase("Withdrawal"))
			{
				System.out.print("Enter the account # : ");
				int getAccountNo = sc.nextInt();
				sc.nextLine();
				getBankAccount = myHashMap.get(getAccountNo);
				System.out.print("Enter the amount of the check : ");
				double getCheckAmount = sc.nextDouble();
				
				getBankAccount.setBalance(getBankAccount.getBalance() - getCheckAmount);
				
				try {
					System.out.print("Enter the date of the check : ");
					String datestring = sc.next();
					sc.nextLine();
					myDate = f.parse(datestring);
				} catch (ParseException e) {
					System.out.println("Please enter valid date");
					continue;
				}
				myTransaction.setDate(myDate);

				if (getBankAccount.getBalance() < 0)
				{
					getBankAccount.setBalance(getBankAccount.getBalance() - 35);
				}
				System.out.println("Current Balance: " + getBankAccount.getBalance());
				
			}
			else if (transactiontype.equalsIgnoreCase("Deposit"))
			{
				System.out.print("Enter the account # : ");
				int getAccountNo = sc.nextInt();
				sc.nextLine();
				getBankAccount = myHashMap.get(getAccountNo);
				System.out.print("Enter the amount of deposit : ");
				double getCheckAmount = sc.nextDouble();
				getBankAccount.setBalance(getBankAccount.getBalance() + getCheckAmount);
				try {
					System.out.print("Enter the date of the check (mm/dd/yyyy): ");
					String datestring = sc.next();
					sc.nextLine();
					myDate = f.parse(datestring);
				} catch (ParseException e) {
					System.out.println("Please enter valid date");
					continue;
				}

				System.out.println("Current Balance: " + getBankAccount.getBalance());
			}

			System.out.println();
			System.out.println();
			System.out.print("Enter a transaction type (Deposit or Withdrawal) or -1 to finish : ");
			transactiontype = sc.next();
			sc.nextLine();
		}
		
		
	}
	
}
