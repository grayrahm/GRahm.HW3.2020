import static org.junit.Assert.*;
import org.junit.Test;
import java.util.LinkedList;

public class EarthquakeExamples {
  Earthquake1 E1 = new Earthquake1();
  Earthquake2 E2 = new Earthquake2();
  LinkedList<Double> noData = new LinkedList<Double>();
  LinkedList<Double> threeDates = new LinkedList<Double>();  
  LinkedList<MaxHzReport> NovReports = new LinkedList<MaxHzReport>();

  Earthquake2 otherE2 = new Earthquake2();
  Earthquake1 otherE1 = new Earthquake1();
  LinkedList<Double> test1 = new LinkedList<Double>();
  LinkedList<MaxHzReport> month07Reports = new LinkedList<MaxHzReport>();
  LinkedList<MaxHzReport> SepReports = new LinkedList<MaxHzReport>();
  LinkedList<MaxHzReport> OctReports = new LinkedList<MaxHzReport>();
  LinkedList<MaxHzReport> AugReports = new LinkedList<MaxHzReport>();



  
  public EarthquakeExamples() {
    threeDates.add(20151013.0);
    threeDates.add(10.0);
    threeDates.add(5.0);
    threeDates.add(20151020.0);
    threeDates.add(40.0);
    threeDates.add(50.0);
    threeDates.add(45.0);
    threeDates.add(20151101.0);
    threeDates.add(6.0);

    threeDates.add(20150802.0);
    threeDates.add(10.0);
    threeDates.add(30.0);
    threeDates.add(10.0);
    threeDates.add(20150901.0);
    threeDates.add(-1.0);
    threeDates.add(85.0);
    threeDates.add(-30.0);
    threeDates.add(90.0);
    threeDates.add(20151013.0);
    threeDates.add(10.0);
    threeDates.add(5.0);


    NovReports.add(new MaxHzReport(20151101.0,6.0));
    OctReports.add(new MaxHzReport(20151013.0, 10.0));
    OctReports.add(new MaxHzReport(20151020.0,50));
    SepReports.add(new MaxHzReport(20150901.0,90));
    AugReports.add(new MaxHzReport(20150802.0, 30));



    test1.add(20100728.0);
    test1.add(20200714.0);
    test1.add(9.0);
    test1.add(6.0);
    test1.add(-9.0);
    test1.add(100.0);

    month07Reports.add(new MaxHzReport (20100728.0,0.0 ));
    month07Reports.add(new MaxHzReport(20200714.0, 100.0));



  }

  @Test
  public void instructorTestEQ() { 
    assertEquals(NovReports, 
                 E1.dailyMaxForMonth(threeDates, 11));
  }


  @Test
  public void instructorTestEQ2() {
    assertEquals(NovReports,
            E2.dailyMaxForMonth(threeDates, 11));
  }



  @Test
  public void testingJuly(){
    assertEquals(month07Reports, otherE1.dailyMaxForMonth(test1, 07));
  }

  @Test
  public void testingOctober() {
    assertEquals(OctReports,
            E1.dailyMaxForMonth(threeDates, 10));
  }

  @Test
  public void testingSeptemberNeg() {
    assertEquals(SepReports,
            E1.dailyMaxForMonth(threeDates, 9));
  }

  @Test
  public void testingAug() {
    assertEquals(AugReports,
            E1.dailyMaxForMonth(threeDates, 8));
  }


  @Test
  public void testingAug2() {
    assertEquals(AugReports,
            E2.dailyMaxForMonth(threeDates, 8));
  }




  @Test
  public void testingSeptemberNeg2() {
    assertEquals(SepReports,
            E2.dailyMaxForMonth(threeDates, 9));
  }

}

/*
 * Subtask:
 * Clean data to have a list consists of data of the desired month
 * Extract the date
 * Extract the data of each date
 * Find max frequency of each date
 * Match date and max frequency go
 * Return the report
 */

