import java.util.LinkedList;

class DataSmooth2 {
  DataSmooth2(){}
	/**
	 * takes a list of shows and smooths the runtimes of the episodes
	 * @param shows a list of shows
	 * @return the smooth list
	 */

  public LinkedList<Double> dataSmooth(LinkedList<Show> shows) 
  {
	  LinkedList<LinkedList<Double>> listOfLists = new LinkedList<>();
	  LinkedList<Double> averageData = new LinkedList<> ();
	  LinkedList<Double> smooth = new LinkedList<>();
	  for(Show show: shows) {
	      double runTime = 0;
	      for(Episode episode: show.episodes) {
	          runTime = runTime + episode.runTime;

          }
	      double averageRunTime = runTime/ (show.episodes.size());
	      averageData.add(averageRunTime);
      }
	  for(int i = 0; i < averageData.size(); i++) {
	      LinkedList<Double> addToList = new LinkedList<>();
	      if (i == 0 || (i == averageData.size()-1)) {
	          addToList.add(averageData.get(i));

          }

	      else {
	          addToList.add(averageData.get(i-1));
	          addToList.add(averageData.get(i));
	          addToList.add(averageData.get(i+1));

          }
	      listOfLists.add(addToList);

      }
	  for(LinkedList<Double> list: listOfLists){
	      double sum = 0;
	      for(double singles: list) {
	          sum = sum + singles;

          }
	      smooth.add(sum/(list.size()));
	  }
	  return smooth;

  }


}