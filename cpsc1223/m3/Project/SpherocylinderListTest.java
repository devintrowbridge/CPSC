import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
* Test class for SpherocylinderList class.
*
* @author Devin Trowbridge CPSC-1223-AO1
* @version 2020-09-03
*/
public class SpherocylinderListTest {
   private Spherocylinder s1 = new Spherocylinder("Test1", 1.0, 1.0);
   private Spherocylinder s2 = new Spherocylinder("Test2", .25, 3.6);
   private Spherocylinder s3 = new Spherocylinder("Test3", 10.2, 5.3);
  
   private SpherocylinderList myList;
   private SpherocylinderList myListEmpty;

   /**
    * Test setup.
    *
    */ 
   @Before public void setUp() {
      Spherocylinder[] tempArr = {s1, s2, s3, null};
      Spherocylinder[] emptyArr = {};
   
      myList = new SpherocylinderList("Test List", tempArr, 3);
      myListEmpty = new SpherocylinderList("Empty List", emptyArr, 0);
   }

   /**
    * Test the name getter.
    *
    */ 
   @Test public void getNameTest() {         
      Assert.assertEquals("Test List", myList.getName());
   }
   
   /**
    * Test the number of cylinders getter.
    *
    */ 
   @Test public void numberOfCylindersTest() {         
      Assert.assertEquals(3, myList.numberOfSpherocylinders());
      Assert.assertEquals(0, myListEmpty.numberOfSpherocylinders());
   }
   
   /**
    * Test the total surface area calcs.
    *
    */ 
   @Test public void totalSATest() {         
      Assert.assertEquals(1672.364017, myList.totalSurfaceArea(), .000001);
      Assert.assertEquals(0, myListEmpty.totalSurfaceArea(), .000001);
   }
   
   /**
    * Test the total volume calcs.
    *
    */ 
   @Test public void totalVolume() {         
      Assert.assertEquals(6185.592254, myList.totalVolume(), .000001);
      Assert.assertEquals(0, myListEmpty.totalVolume(), .000001);
   }
   
   /**
    * Test the average surface area calcs.
    *
    */ 
   @Test public void avgSATest() {         
      Assert.assertEquals(557.454672, myList.averageSurfaceArea(), .000001);
      Assert.assertEquals(0, myListEmpty.averageSurfaceArea(), .000001);
   }
   
   /**
    * Test the average volume calcs.
    *
    */ 
   @Test public void avgVolume() {         
      Assert.assertEquals(2061.864084, myList.averageVolume(), .000001);
      Assert.assertEquals(0, myListEmpty.averageVolume(), .000001);
   }
   
   /**
    * Test the toString interface.
    *
    */ 
   @Test public void toStringTest() {         
      myList.toString();
   }
   
   /**
    * Test the list getter.
    *
    */ 
   @Test public void getListTest() {         
      Spherocylinder[] tempArr1 = myList.getList();
      Spherocylinder[] tempArr2 = {s1, s2, s3, null};
      
      Assert.assertArrayEquals(tempArr2, tempArr1);
   }
   
   /**
    * Test the adding and finding functions.
    *
    */ 
   @Test public void addFindTest() { 
      Spherocylinder[] tempArr1 = {s1, s2, s3, null};        
      SpherocylinderList addFindList 
         = new SpherocylinderList("Test List", tempArr1, 3);
   
      String label = "Test4";
      addFindList.addSpherocylinder(label, 11.3, 26.3);
      addFindList.addSpherocylinder("Test5", 11.3, 26.3);
      
      Assert.assertTrue(addFindList.findSpherocylinder(label) != null);
      Assert.assertTrue(
         addFindList.findSpherocylinder(label.toUpperCase()) != null);
      Assert.assertTrue(addFindList.findSpherocylinder("nonsense") == null);
   }
   
   /**
    * Test the delete functions.
    *
    */ 
   @Test public void deleteTest() {         
      Spherocylinder[] tempArr1 = {s1, s2, s3, null, null};        
      SpherocylinderList deleteList1 
         = new SpherocylinderList("Test List", tempArr1, 3);
      
      String label = "Test4";
      
      deleteList1.addSpherocylinder(label, 11.3, 26.3);
      Assert.assertTrue(deleteList1.deleteSpherocylinder(label) != null);
      Assert.assertTrue(
         deleteList1.findSpherocylinder(label.toUpperCase()) == null);
      Assert.assertTrue(deleteList1.deleteSpherocylinder("nonsense") == null);
      
      Spherocylinder[] tempArr2 = {s1, s2, s3};        
      SpherocylinderList deleteList2 
         = new SpherocylinderList("Test List", tempArr1, 3);
      Assert.assertTrue(
         deleteList2.deleteSpherocylinder(s3.getLabel()) != null);
   }
   
   /**
    * Test the edit functions.
    *
    */ 
   @Test public void editTest() { 
      String label = "Test3";
      Assert.assertTrue(myList.editSpherocylinder(label, 23.1, 56.2));
      Assert.assertEquals(23.1, 
                          myList.findSpherocylinder(label).getRadius(), 
                          .000001);
      Assert.assertEquals(56.2, 
                          myList.findSpherocylinder(label).getCylinderHeight(),
                          .000001);
      Assert.assertEquals(56.2, 
                          myList.findSpherocylinder(
                          label.toUpperCase()).getCylinderHeight(),
                          .000001);                             
       
      Assert.assertTrue(!myList.editSpherocylinder("nonsense", 5, 2));
   }  
   
    /**
    * Test the find largest volume function.
    *
    */ 
   @Test public void findLargestVolTest() { 
      Spherocylinder[] scArray = {};
      SpherocylinderList sList 
         = new SpherocylinderList("Test List", scArray, 0);
      sList.addSpherocylinder("Test1", 1.0, 1.0);
      sList.addSpherocylinder("Test2", .25, 3.6);
      sList.addSpherocylinder("Test3", 10.2, 5.3);
      sList.addSpherocylinder("Test4", 0.2, 0.3);
      
      Spherocylinder mySpherocylinder = 
         sList.findSpherocylinderWithLargestVolume();
      Assert.assertEquals("Test3", mySpherocylinder.getLabel());
       
      Assert.assertTrue(
         null == myListEmpty.findSpherocylinderWithLargestVolume());
   }     
}
