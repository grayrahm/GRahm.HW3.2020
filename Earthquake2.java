import java.util.LinkedList;

class Earthquake2 {
  Earthquake2(){}

  // checks whether a datum is a date
  boolean isDate(double anum)
  {
    return (int)anum > 10000000;
  }
  // extracts the month from an 8-digit date
  int extractMonth(double dateNum)
  {
    return ((int)dateNum % 10000) / 100;
  }

  public LinkedList<MaxHzReport> dailyMaxForMonth(LinkedList<Double> data, int month)
  {
    LinkedList<Double> dataList = cleaning(data,month);
    LinkedList<MaxHzReport> monthlyReport = new LinkedList<>();
    if (dataList.isEmpty())
      return monthlyReport;

    double beatThis = 0.00;
    double date = dataList.get(0);
    for (int i = 1; i < dataList.size(); i++) {
      if (!isDate(dataList.get(i)) &&  dataList.get(i) > beatThis) {
        beatThis = dataList.get(i);
      }
      if (isDate(dataList.get(i))) {
        monthlyReport.add(new MaxHzReport(date, beatThis));
        date = dataList.get(i);
        beatThis = 0;
      }

    }
    monthlyReport.add(new MaxHzReport(date, beatThis));
    return monthlyReport;
  }

  LinkedList<Double> cleaning(LinkedList<Double> data, int month) {
    LinkedList<Double> cleanedData = new LinkedList<>();
    boolean rightMonth = false;
    for (Double d: data) {
      if (isDate(d) && extractMonth(d) == month) {
        rightMonth = true;
      }
      if (rightMonth == true) {
        if (isDate(d) && extractMonth(d) != month)
          break;
        else if (d >= 0)
          cleanedData.add(d);
      }
    }
    return cleanedData;
  }

}
