/**
 * 
 * @author Drew Stagnaro
 * period 6.
 * creates a subclass of BankAccount which makes a savings account
 *
 */
public class CheckingAccount extends BankAccount
{
	private final double OVER_DRAFT_FEE, TRANSACTION_FEE, FREE_TRANS;
	private int numTransactions;
	/**
	 * 
	 * @param n = name
	 * @param b = balance
	 * @param odf = overdraft fee
	 * @param tf = transaction fee
	 * @param freeTrans = free transactions
	 */
	public CheckingAccount(String n, double b, double odf, double tf, double freeTrans)
	{
		super(n,b);
		OVER_DRAFT_FEE = odf;
		TRANSACTION_FEE = tf;
		FREE_TRANS = freeTrans;
	}
	/**
	 * 
	 * @param n = name
	 * @param odf = over draft fee
	 * @param tf = transaction fee
	 * @param freeTrans = free transactions
	 */
	public CheckingAccount(String n, double odf, double tf, double freeTrans)
	{
		super(n);
		OVER_DRAFT_FEE = odf;
		TRANSACTION_FEE = tf;
		FREE_TRANS = freeTrans;
	}
	/**
	 * if a transaction is not allowed, throws an IllegalArgumentException
	 * Increases numTransactions and deducts fees only if transaction is allowed
	 * to occur.
	 */
	public void deposit(double amt)
	{
		if(amt <= 0)
		{
			throw new IllegalArgumentException();
		}
		else
		{
			numTransactions++;
			if(numTransactions > FREE_TRANS)
			{
				withdraw(TRANSACTION_FEE);
			}
			super.deposit(amt);
		}
	}
	/**
	 * If a withdraw is not allowed, throws an IllegalArgumentException
	 * An account can be overdrawn if the balance is not already negative
	 */
	public void withdraw(double amt)
	{
		if(amt <= 0)
		{
			throw new IllegalArgumentException();
		}
		else
		{
			numTransactions++;
			if(numTransactions > FREE_TRANS)
			{
				super.withdraw(TRANSACTION_FEE);
			}
			super.withdraw(amt);
		}	
		if(super.getBalance() < 0)
		{
			super.withdraw(OVER_DRAFT_FEE);
		}
	}
	/**
	 * transfers money to other account if the accounts are both in the same name
	 * Transaction fee would apply, but balance cannot go negative
	 * if a transaction is not allowed, throws an IllegalArgumentException
	 */
	public void transfer(BankAccount other, double amt)
	{
		if(getBalance() - amt < 0)
		{
			throw new IllegalArgumentException();
		}
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
	 * resets the number of transactions back to 0
	 */
	public void endOfMonthUpdate()
	{
		numTransactions = 0;
	}
}
