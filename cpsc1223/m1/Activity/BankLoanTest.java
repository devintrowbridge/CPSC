import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 * Test class for BankLoan class.
 *
 * @author Devin Trowbridge CPSC-1223-AO1
 * @version 2020-08-18
 */
public class BankLoanTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }

   /**
    * Test case for interest charging.
    *
    */
   @Test public void chargeInterestTest() {
      BankLoan loan1 = new BankLoan("Jane", .10);
      loan1.borrowFromBank(1000.00);
      loan1.chargeInterest();
      Assert.assertEquals(" ", 1100, loan1.getBalance(), .000001);
   }
   
   /**
    * Test case for total number of loans created.
    *
    */
   @Test public void loansCreatedTest() {
      BankLoan.resetLoansCreated();
      Assert.assertEquals(" ", 0, BankLoan.getLoansCreated());
      BankLoan jane = new BankLoan("Jane", .10);
      BankLoan bob  = new BankLoan("Bob", .10);
      Assert.assertEquals(" ", 2, BankLoan.getLoansCreated());
      bob = new BankLoan("Bob Parker", 0.02);
      Assert.assertEquals(" ", 3, BankLoan.getLoansCreated());
   }
}
