import java.util.ArrayList;

public class BankAccount {
	private String name;
	private double balance;
	private int accountno;
	private ArrayList<Transaction> transactions;
	
	public BankAccount()
	{
		transactions = new ArrayList<Transaction>();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public int getAccountno() {
		return accountno;
	}
	public void setAccountno(int accountno) {
		this.accountno = accountno;
	}
	public ArrayList<Transaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(ArrayList<Transaction> transactions) {
		this.transactions = transactions;
	}
	public void addItemToArray (Transaction transaction)
	{
		transactions.add(transaction);
	}
	
}