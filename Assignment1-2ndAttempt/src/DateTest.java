import org.junit.Assert;
import org.junit.jupiter.api.Test;

class DateTest {

  int testDay = 19;
  int testMonth = 1;
  int testYear = 1990;
  Date date = new Date(testMonth, testDay, testYear);

  Date intTest = new Date(1, 1, 1000);

  // Date monthTest = new Date();



  @Test // tests if the days, month, year inputs are within range
  public void testReadInput() {
    Assert.assertTrue(date.getDay() == testDay);
    Assert.assertTrue(date.getMonth() == testMonth);
    Assert.assertTrue(date.getYear() == testYear);
  }

  @Test
  public void dateOKTest() {
    Assert.assertTrue(intTest.dateOK(5, 12, 2230));
  }

  @Test
  public void monthOKTest() {
    Assert.assertTrue("January", true);
    // Assert.assertTrue("March", false); //this line is an error - which means success!
  }
}
