/**
 * 
 * @author Drew Stagnaro
 * period 6.
 * Creates a sub class of BankAccount that makes a savings account
 */
public class SavingsAccount extends BankAccount
{
	
	private double intRate;
	private final double MIN_BAL, MIN_BAL_FEE;
	/**
	 * 
	 * @param n = name
	 * @param b = balance
	 * @param r = interest rate
	 * @param mb = minimum balance
	 * @param mbf = minimum balance fee
	 */
	public SavingsAccount(String n, double b, double r, double mb, double mbf)
	{
		super(n,b);
		intRate = r;
		MIN_BAL = mb;
		MIN_BAL_FEE = mbf;
	}
	/**
	 * 
	 * @param n = name
	 * @param r = interest rate
	 * @param mb = minimum balance
	 * @param mbf = minimum balance fee
	 */
	public SavingsAccount(String n, double r, double mb, double mbf)
	{
		super(n);
		intRate = r;
		MIN_BAL = mb;
		MIN_BAL_FEE = mbf;
	}
	/**
	 * withdraws only if the balance doesn't go under 0
	 */
	public void withdraw(double amt)
	{
		if(amt <= 0)
		{
			throw new IllegalArgumentException();
		}
		else
		{
			if(super.getBalance() < amt)
			{
				throw new IllegalArgumentException();
			}
			super.withdraw(amt);
			if(super.getBalance() <= MIN_BAL)
			{
				super.withdraw(MIN_BAL_FEE);
			}
		}
	}
	/**
	 * transfers money to the other account only if under the other account it under the same name	 * 
	 */
	public void transfer(BankAccount other, double amt)
	{
		if(this.getName().equals(other.getName()))
		{
			super.transfer(other, amt);
		}
		else
		{
			throw new IllegalArgumentException();
		}
	}
	/**
	 * calculates the interest rate for the account
	 */
	public void addInterest()
	{
		super.deposit((super.getBalance() * intRate) - super.getBalance());
	}
	/**
	 * Adds interest at the end of the month
	 */
	public void endOfMonthUpdate()
	{
		addInterest();
	}
	/**
	 * if transaction is not allowed to occur, throws and illegal argument exception
	 */
	public void deposit(double amt)
	{
		if(amt <= 0)
		{
			throw new IllegalArgumentException();
		}
			super.deposit(amt);
	}
}