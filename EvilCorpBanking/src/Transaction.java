import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Transaction {

	private double amtwithdrawl, amtdeposit;
	private Date date;
	

	public double getAmtwithdrawl() {
		return amtwithdrawl;
	}
	public void setAmtwithdrawl(double amtwithdrawl) {
		this.amtwithdrawl = amtwithdrawl;
	}
	public double getAmtdeposit() {
		return amtdeposit;
	}
	public void setAmtdeposit(double amtdeposit) {
		this.amtdeposit = amtdeposit;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;

	}

}
