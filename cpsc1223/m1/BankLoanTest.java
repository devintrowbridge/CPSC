import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class BankLoanTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }

   @Test public void chargeInterestTest() {
      BankLoan loan1 = new BankLoan("Jane", .10);
      loan1.borrowFromBank(1000.00);
      loan1.chargeInterest();
      Assert.assertEquals(" ", 1100, loan1.getBalance(), .000001);
   }
   
   @Test public void loansCreatedTest() {
      BankLoan.resetLoansCreated();
      Assert.assertEquals(" ", 0, BankLoan.getLoansCreated());
      BankLoan jane = new BankLoan("Jane", .10);
      BankLoan bob  = new BankLoan("Bob" , .10);
      Assert.assertEquals(" ", 2, BankLoan.getLoansCreated());
      bob = new BankLoan("Bob Parker", 0.02);
      Assert.assertEquals(" ", 3, BankLoan.getLoansCreated());
   }
}
