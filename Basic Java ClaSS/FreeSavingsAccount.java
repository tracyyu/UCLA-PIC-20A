public class FreeSavingsAccount extends BankAccount {
	
	 int nominalWithdrawals;		// Total amount of withdrawals including free withdrawals including free withdrawals
	 double amount;
	 double interestRate;
	final double fee = 2.50;
	 int feeCount;					// number of times the fee occurs after two free withdrawals
	
	//A constructor that takes in a rate. It sets the initial balance to $0.00.
	public FreeSavingsAccount(double rate){
		super();
		interestRate = rate;
	}
	
	//A constructor that takes in a rate and an initial balance.
	public FreeSavingsAccount(double rate, double  balance){
		super(balance);
		interestRate = rate;
	}
	
	/*A deposit method.  The first two free withdrawals are also resets (the number of withdrawals in 
	 * the period resets back to 0) when a deposit of $100 or more is made to the account.
	 */
	public void deposit(double amount)
	{
		if( amount >= 100){
			nominalWithdrawals = 0;
		}
		super.deposit(amount);
	}
	
	/*A withdraw method. This method should add a fee when applicable that is deducted at the end of the month.
	 * Deduct $2.50 from the third withdrawal of the month.
	 */
	public void withdraw(double amount){
		nominalWithdrawals++;	
		if(nominalWithdrawals > 2)
			feeCount++;									
		super.withdraw(amount);
	}
	
	public double getBalance(){
		return super.getBalance();
	}
	
	/*A transfer method. (From the point of view of withdrawal charges, a transfer counts as a withdrawal 
	 * from the account being transferred from.)
	 */
	public void transfer(double amount, BankAccount other){
		super.transfer(amount, other);
	}
	
	/*A displayAccount method, which return String 
	 * e.g. 
	 * "FreeSavingsAccount[balance=10000.0][interestRate=5.0][withdrawalCount=3]"
	 */
	public void displayAccount(){
		System.out.println("FreeSavingsAccount[balance="+getBalance()+"][interestRate="+ interestRate 
							+ "][withdrawalCount="+ (nominalWithdrawals) + "]");
	}
	
	/*An addPeriodicInterest method. 
	 * Along with adding the interest, this method also performs the deductions for having more than two withdrawals in the period. 
	 * (First add interest, then deduct all fees.) Of course, it also resets the number of withdrawals in the period back to 0.
	 * Calling addPeriodicInterest for an account will simulate the end on a month.
	 */
	public void addPeriodicInterest(){
		double balance = getBalance();
		super.withdraw(getBalance());
		double totalFee = fee * feeCount;
		balance = balance + (balance * (interestRate/100));
		balance -= totalFee;
		super.deposit(balance);
		nominalWithdrawals = 0;
		/*
		double balance;
		balance = getBalance();
		double totalFee;
		totalFee = fee * feeCount;
		balance= balance - (balance *(interestRate/100));
		balance-=totalFee;
		nominalWithdrawals = 0;
		freeWithdrawals = 0;
		*/
	}
	
	public int getFeeCount(){
		return feeCount;
	}
}
