/**
 * 
 * @author Drew Stagnaro
 *
 */
import java.util.ArrayList;
import java.util.Scanner;
public class Main 
{
	private ArrayList<BankAccount> BankAccounts = new ArrayList<BankAccount>();
	private final double OVER_DRAFT_FEE = 15;
	private final double RATE = .0025;
	private final double TRANSACTION_FEE = 1.5;
	private final double MIN_BAL = 300;
	private final double MIN_BAL_FEE = 10;
	private final double FREE_TRANSACTIONS = 10;
	
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("would you like to add an account(type: add), make a transaction(type: make), or terminate the program(type: end)");
		String str = scan.nextLine();
		while(!str.equals("add") && !str.equals("make") && !str.equals("end")) 
		{
		System.out.println("would you like to add an account(type: add), make a transaction(type: make), or terminate the program(type: end)"); 
		scan.nextLine();
		if(str.equals("add"))
		{
		System.out.println("To add a savings account type (Save). To add a checking account type (Check). To go back type (Back)");
		str = scan.nextLine();
			if(str.equals("Save"));
			{
				System.out.println("Please type your name");
				str = scan.nextLine();
				
			}
		}
		if(str.equals("make"))
		{
			System.out.println("please enter your account name and number.");
			str = scan.nextLine();
			
		}
	
		if(str.equals("end"))
		{
			System.exit(1);
		}		
		}
	}
	
	private static boolean isNumeric(String str)
	{
	try
	{
		Double.parseDouble(str);
		return true;
	}
			catch(IllegalArgumentException i)
			{
				return false;
			}
			
	}
	
}
