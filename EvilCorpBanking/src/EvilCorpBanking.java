import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class EvilCorpBanking 
{

	public static void main(String[] args) {
		
		//get filename
		String filename = (System.getProperty("user.dir") + File.separatorChar + "EvilCorp.txt");
		System.out.println(filename);
		
		//initializing objects
		Scanner sc = new Scanner(System.in);
		Date myDate = new Date();
		SimpleDateFormat f = new SimpleDateFormat("MM/dd/yyyy");
		HashMap<Integer, BankAccount> myHashMap = new HashMap<Integer, BankAccount>();
	
		//Prompt user to enter account information and store it
		System.out.println("Welcome to Evil Corp Savings and Loan");
		System.out.println("Please create the user account(s)");
		
		
		myHashMap = getBankAccount(myHashMap);
		
		System.out.println("\r\r");
		
		System.out.print("Please enter the account number that you would like to make a transaction for : ");
		Integer getAccountNo = (Integer)sc.nextInt();
		sc.nextLine();
		
		if (!myHashMap.containsKey(getAccountNo))
		{
			System.out.println("The account number you entered does not exist. Please create a new account. \r\r");
			myHashMap = getBankAccount(myHashMap);
		}
		System.out.println("\r\r");
		
		BankAccount getBankAccount = new BankAccount();
		
		System.out.print("Enter a transaction type (Deposit or Withdrawal) or -1 to finish : ");
		String transactiontype = sc.next();
		sc.nextLine();
		
		while (!transactiontype.equalsIgnoreCase("-1"))
		{	
			Transaction myTransaction = new Transaction();
			double getWithdrawalAmount = 0;
			double getDepositAmount = 0;
			if (transactiontype.equalsIgnoreCase("Withdrawal"))
			{
				myTransaction.setDeposit(false);
				getBankAccount = myHashMap.get(getAccountNo);
				System.out.print("Enter the amount of the Withdrawal : ");
				getWithdrawalAmount = sc.nextDouble();
				
				try {
					System.out.print("Enter the date of the check (mm/dd/yyyy) : ");
					String datestring = sc.next();
					sc.nextLine();
					myDate = f.parse(datestring);
				} catch (ParseException e) {
					System.out.println("Please enter valid date");
					continue;
				}
				
				//Setting Transactions and adding to Array List
				myTransaction.setAmount(getWithdrawalAmount);
				myTransaction.setDate(myDate);
				getBankAccount.addItemToArray(myTransaction);

			}
			else if (transactiontype.equalsIgnoreCase("Deposit"))
			{
				getBankAccount = myHashMap.get(getAccountNo);
				System.out.print("Enter the amount of deposit : ");
				getDepositAmount = sc.nextDouble();

				try {
					System.out.print("Enter the date of the check (mm/dd/yyyy): ");
					String datestring = sc.next();
					sc.nextLine();
					myDate = f.parse(datestring);
				} catch (ParseException e) {
					System.out.println("Please enter valid date");
					continue;
				}
				
				//Setting Transactions and adding to Array List
				myTransaction.setAmount(getDepositAmount);
				myTransaction.setDate(myDate);
				getBankAccount.addItemToArray(myTransaction);	
			}
			
			System.out.println();
			System.out.println();
			System.out.print("Enter a transaction type (Deposit or Withdrawal) or -1 to finish : ");
			transactiontype = sc.next();
			sc.nextLine();
		}
		
		Collections.sort(getBankAccount.getTransactions());
		for (Transaction transaction : getBankAccount.getTransactions())
		{
			if(transaction.isDeposit())
			{
				getBankAccount.setBalance(transaction.getAmount() + getBankAccount.getBalance()); 
			}
			else
			{
				getBankAccount.setBalance(getBankAccount.getBalance() - transaction.getAmount());
				if (getBankAccount.getBalance() < 0)
				{
					getBankAccount.setBalance(getBankAccount.getBalance() - 35);
				}
			}
			
		}

		
		String formatstring = "%-50s%-50s\r";
			
		System.out.println("------------------------------------------------------Transactions Reciept------------------------------------------------------");
		System.out.println("For Bank Account No : " + getAccountNo);
		System.out.println("Name: " + getBankAccount.getName() + "\r");
		System.out.format(formatstring, "Date", "Amount");
		System.out.format(formatstring, "-----", "--------");
		
		for (int i = 0; i<getBankAccount.getTransactions().size(); i++)
		{
			String formatteddate = f.format(getBankAccount.getTransactions().get(i).getDate());
			System.out.format(formatstring, formatteddate, getBankAccount.getTransactions().get(i).getAmount());
		}
		System.out.println("\r\r");
		System.out.format ("%-100s","Total Balance : " + getBankAccount.getBalance());
		
		
	}
	
	
	
	
	public static HashMap<Integer, BankAccount> getBankAccount (HashMap<Integer, BankAccount> myHashMap)
	{
		BankAccount myBankAccount = new BankAccount();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Please enter an account number: ");
		int accountno = sc.nextInt();
		
		while (accountno != -1)
		{
			if (!myHashMap.containsKey(accountno))
			{
				myBankAccount.setAccountno(accountno);
				System.out.print("Enter the name for account number " + accountno + " : ");
				sc.nextLine();
				String name = sc.nextLine();
				myBankAccount.setName(name);
				System.out.print("Enter the balance for account number " + accountno + " : ");
				double balance = sc.nextDouble();
				myBankAccount.setBalance(balance);
				System.out.print("Account has been created.");
				System.out.println("\r\r\r");
			}
			else
			{
				System.out.print("Bank Account already exists. \r");
			}
			
			System.out.print("Enter a account # to create another account, or -1 to stop entering accounts : ");
			accountno = sc.nextInt();
			sc.nextLine();
			
			myHashMap.put(myBankAccount.getAccountno(),myBankAccount);
		}
		
		return myHashMap;
	}
	
	public void writeToFile ()
	
}