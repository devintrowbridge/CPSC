import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
* Test class for spherocylinder class.
*
* @author Devin Trowbridge CPSC-1223-AO1
* @version 2020-09-03
*/
public class SpherocylinderTest {

   /**
    * Setup function.
    *
    */ 
   @Before public void setUp() {
      // empty
   }

   /**
    * Test the label setter/getter.
    *
    */ 
   @Test public void labelTest() {
      Spherocylinder d = new Spherocylinder("Test", 1.0, 1.0);
   
      d.setLabel("New Label ");
      Assert.assertEquals(d.getLabel(), "New Label");
      
      d.setLabel(null);
      Assert.assertEquals(d.getLabel(), "New Label");
   }
   
   /**
    * Test the radius setter/getter.
    *
    */ 
   @Test public void radiusTest() {
      Spherocylinder d = new Spherocylinder("Test", 1.0, 1.0);
   
      d.setRadius(2.5);
      Assert.assertEquals(d.getRadius(), 2.5, .000001);
      
      d.setRadius(-2.5);
      Assert.assertEquals(d.getRadius(), 2.5, .000001);
   }
   
   /**
    * Test the cylinder height setter/getter.
    *
    */ 
   @Test public void cylinderHeightTest() {
      Spherocylinder d = new Spherocylinder("Test", 1.0, 1.0);
   
      d.setCylinderHeight(2.5);
      Assert.assertEquals(d.getCylinderHeight(), 2.5, .000001);
      
      d.setCylinderHeight(-2.5);
      Assert.assertEquals(d.getCylinderHeight(), 2.5, .000001);
   }
   
   /**
    * Test the circumference calc.
    *
    */ 
   @Test public void circumferenceTest() {
      Spherocylinder d = new Spherocylinder("Test", 1.0, 1.0);
      Assert.assertEquals(d.circumference(), 6.283185, .000001);
   }
   
   /**
    * Test the surface area calc.
    *
    */ 
   @Test public void surfaceAreaTest() {
      Spherocylinder d = new Spherocylinder("Test", 1.0, 1.0);
      Assert.assertEquals(d.surfaceArea(), 18.849556, .000001);
   } 
   
   /**
    * Test the volume calc.
    *
    */ 
   @Test public void volumeTest() {
      Spherocylinder d = new Spherocylinder("Test", 1.0, 1.0);
      Assert.assertEquals(d.volume(), 7.330383, .000001);
   }
   
    /**
    * Test the string summary.
    *
    */  
   @Test public void toStringTest() {
      Spherocylinder d = new Spherocylinder("Test", 1.0, 1.0);
      d.toString();
   }
   
   /**
    * Test the static members.
    *
    */  
   @Test public void countTest() {
      Spherocylinder.resetCount();
      Assert.assertEquals(Spherocylinder.getCount(), 0);
      Spherocylinder a = new Spherocylinder("Test1", 1.0, 1.0);
      Spherocylinder b = new Spherocylinder("Test2", 1.0, 1.0);
      Spherocylinder c = new Spherocylinder("Test3", 1.0, 1.0);
      Assert.assertEquals(Spherocylinder.getCount(), 3);
   }
   
   /**
    * Test the comparison interface.
    *
    */  
   @Test public void equalsTest() {
      Spherocylinder thing1 = new Spherocylinder("Test", 1.0, 1.0);
      Spherocylinder thing2 = new Spherocylinder("Test", 1.0, 1.0);         
      Assert.assertEquals(thing1, thing2);
   
      thing2.setCylinderHeight(2.0);
      Assert.assertNotEquals(thing1, thing2);
      
      thing2.setRadius(2.0);
      Assert.assertNotEquals(thing1, thing2);
      
      thing2.setLabel("Label");
      Assert.assertNotEquals(thing1, thing2);
   
      String test = "test";
      Assert.assertNotEquals(thing1, test);
      
      Assert.assertEquals(thing1.hashCode(), 0);
   }
   
   /**
    * Test the comparison interface.
    *
    */ 
   @Test public void compareToTest1() {
      Spherocylinder thing1 = new Spherocylinder("Test", 1.0, 1.0);
      Spherocylinder thing2 = new Spherocylinder("Test", 1.0, 1.0); 
      Assert.assertTrue(thing1.compareTo(thing2) == 0);
      
      thing2.setRadius(5.0);
      Assert.assertTrue(thing1.compareTo(thing2) < 0);
      
      thing2.setRadius(0.5);
      Assert.assertTrue(thing1.compareTo(thing2) > 0);
   }
}
