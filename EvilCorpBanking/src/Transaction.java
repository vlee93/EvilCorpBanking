import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Transaction implements Comparable<Transaction> {

	private double amount;
	private Date date;
	private boolean isDeposit = true;
	

	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;

	}
	
	
	public boolean isDeposit() {
		return isDeposit;
	}
	public void setDeposit(boolean isDeposit) {
		this.isDeposit = isDeposit;
	}
	
	@Override
	public int compareTo(Transaction otherTransaction) {
		// TODO Auto-generated method stub
		return getDate().compareTo(otherTransaction.getDate());
	}

}
