
/**
 * Bank loan class for keeping track of loan balance and 
 * processing transactions.
 *
 * Activity 1
 * @author Devin Trowbridge CPSC-1223-AO1
 * @version 2020-08-18
 */
public class BankLoan {
	// constant fields
   private static final int MAX_LOAN_AMOUNT = 100000;

   // instance variables (can be used within the class)
   private String customerName;
   private double balance, interestRate;
   private static int loansCreated = 0;

   /**
    * Class constructor.
    * 
    * @param customerNameIn customer name
    * @param interestRateIn interest rate
    */
   public BankLoan(String customerNameIn, double interestRateIn) { 
      customerName = customerNameIn;
      interestRate = interestRateIn;
      balance = 0;
      loansCreated++;
   }

   /**
    * Reset the loans created.
    *
    */
   public static void resetLoansCreated() {
      loansCreated = 0;
   }
   
   /**
    * Get the loans created.
    *
    * @return the loans created
    */
   public static int getLoansCreated() {
      return loansCreated;
   }

   /**
    * Set the amount of money to borrow from the bank.
    * 
    * @param amount amount to borrow
    * @return true if successful
    */
   public boolean borrowFromBank(double amount) {
      
      boolean wasLoanMade = false;
      
      if (balance + amount < MAX_LOAN_AMOUNT) {
         wasLoanMade = true;
         balance += amount;
      }
   
      return wasLoanMade;
   }

   /**
    * Pay bank for the loan.
    * 
    * @param amountPaid amount to pay
    * @return the new loan balance after payment
    */
   public double payBank(double amountPaid) {
      double newBalance = balance - amountPaid;
      if (newBalance < 0) {
         balance = 0;
         // paid too much, return the overcharge
         return Math.abs(newBalance);
      }
      else {
         balance = newBalance;
         return 0;
      }
   }
   
   /**
    * Get the loan balance.
    *
    * @return the loan balance
    */
   public double getBalance() {
      return balance;
   }
   
   /**
    * Set the loan interest rate.
    *
    * @param interestRateIn new interest rate
    * @return true if successful
    */
   public boolean setInterestRate(double interestRateIn) {
   
      if (interestRateIn >= 0 && interestRateIn <= 1) {
         interestRate = interestRateIn;
         return true;
      }
      else {
         return false;
      }
   }
   
   /**
    * Get the loan interest rate.
    *
    * @return the loan interest rate
    */
   public double getInterestRate() {
      return interestRate;
   }
   
   /**
    * Charges interest against the loan.
    *
    */
   public void chargeInterest() {
      balance = balance * (1 + interestRate);
   }
   
   /**
    * Converts BankLoan object into a string.
    *
    * @return string representation of bank loan
    */
   public String toString() {
      String output = "Name: " + customerName + "\r\n" 
         + "Interest rate: " + interestRate + "%\r\n" 
         + "Balance: $" + balance + "\r\n";
      return output;
   }

   /**
    * Makes sure the loan is a positive amount.
    *
    * @param amount amount to check
    * @return true if valid 
    */
   public static boolean isAmountValid(double amount) {
      return (amount >= 0);
   }
   
   /**
    * Determines if the loan is in debt.
    *
    * @param loan bank loan to check
    * @return true if in debt
    */
   public static boolean isInDebt(BankLoan loan) {
      if (loan.getBalance() > 0) {
         return true;
      }
      return false;
   }
}
