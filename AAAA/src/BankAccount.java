/**
 * 
 * @author Drew Stagnaro
 * Period 6
 * Creates a Super Class BankAccount
 *
 */
public abstract class BankAccount 
{
	//Fields
	private double balance;
	private String name;
	private int actNum;	
	private int count;
	//Constructors
	/**
	 * 
	 * @param n = name
	 */
	public BankAccount(String n)
	{
		name = n;
		balance = 0;
		actNum = count++;
	}
	/**
	 * 
	 * @param n = name
	 * @param b = balance
	 */
	public BankAccount(String n, double b)
	{
		name = n;
		balance = b;
		actNum = count++;		
	}
	//Methods
	/**
	 * allows the person to take money from their account
	 * @param amt takes the amount of the withdrawal and subtracts it from the balance
	 */
	public void withdraw(double amt)
	{
		balance -= amt;
	}
	/**
	 *  allows the person to add money to their account
	 * @param amt takes the amount of the deposit and adds it to the balance
	 */
	public void deposit(double amt)
	{
		balance += amt;
	}
	/**
	 * 
	 * @return returns the balance
	 */
	public double getBalance()
	{
		return balance;
	}
	/**
	 * 
	 * @return returns the name of the person who holds the account
	 */
	public String getName()
	{
		return name;
	}
	/**
	 * 
	 * @param other the account in which the money is being 
	 * @param amt the amount of money being transferred
	 */
	public void transfer(BankAccount other, double amt)
	{
		withdraw(amt);
		other.deposit(amt);
	 }
	/**
	 * returns “acctNum<tab>name<tab>$balance”
	 */
	public String toString()
	{
		return "Account Number: " + actNum + "Name: " + getName() + "Balance: " + getBalance();
	}
}

