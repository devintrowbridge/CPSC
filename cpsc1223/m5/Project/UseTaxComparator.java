import java.lang.Double;
import java.util.Comparator;

/**
* Comparator class for comparing vehicles on their use tax.
*
* @author Devin Trowbridge CPSC-1223-AO1
* @version 2020-09-13
*/
public class UseTaxComparator implements Comparator<Vehicle> {
   
   public int compare(Vehicle v1, Vehicle v2) {
      return Double.compare(v1.useTax(), v2.useTax());
   } 
}