

import java.util.LinkedList;

class Earthquake1 {
  Earthquake1(){}

  // checks whether a datum is a date
  boolean isDate(double anum) {
    return (int)anum > 10000000; }


  // extracts the month from an 8-digit date
  int extractMonth(double dateNum) {
    return ((int)dateNum % 10000) / 100;
  }


    /**
     * dailyMaxForMonth calculates the max Hz reading that day
     * @param data is the what is calculate
     * @param month holds the data
     * @return LinkedList MaxHzReports
     */
  public LinkedList<MaxHzReport> dailyMaxForMonth(LinkedList<Double> data,
                                                  int month) {

   LinkedList<Double> list1 = new LinkedList<Double>();
   LinkedList<MaxHzReport> list2 = new LinkedList<MaxHzReport>();
   for(double aData : data){
     if(isDate(aData)) {
       if (list1.size() == 0) {
         list1.add(aData);
       }
        else{
          list2.add(helper(list1));
          list1 = new LinkedList<Double>();
          list1.add(aData);
     }
   }
   else{
     if(aData > 0.0){
       list1.add(aData);
     }
     }

    }
   list2.add(helper(list1));
   LinkedList<MaxHzReport> result = new LinkedList<MaxHzReport>();

   for (MaxHzReport maxReport : list2) {
     if(extractMonth(maxReport.date)== month) {
       result.add(maxReport);

     }
   }
   return result;

  }



  public MaxHzReport helper(LinkedList<Double> data){
    double date = data.getFirst();
    data.removeFirst();
    double max = 0;
    for (double aData: data){
      if (aData > max) max = aData;


    }
      return new MaxHzReport(date,max);

    }
  }



