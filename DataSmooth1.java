import java.util.LinkedList;

class DataSmooth1 {
  DataSmooth1(){}
  
  public LinkedList<Double> dataSmooth(LinkedList<Show> shows) 
  {
      LinkedList<Double> averageData = new LinkedList<>();
      LinkedList<Double> smoothData = new LinkedList<>();

      for(Show show: shows) {
          double runTime = 0;
          for (Episode episode : show.episodes) {
              runTime = runTime + episode.runTime;

          }
          double averageRunTime = runTime / (show.episodes.size());
          averageData.add(averageRunTime);

      }

      if (averageData.size() > 0) {
          smoothData.add(averageData.getFirst());

          for(int i = 1; i<(averageData.getFirst()-1);i++) {
              smoothData.add((averageData.get(i) + averageData.get(i-1))/3);
          }
          smoothData.add(averageData.getLast());


      }
      return smoothData;


  }
}