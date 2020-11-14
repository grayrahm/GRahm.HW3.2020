import java.util.LinkedList;

class ShowManager1 {
	
	ShowManager1() {}

	/**
	 * sorts the shows into list based on their runtime
	 * @param shows is a list of all shows
	 * @return a list of on non special shows and shows that are not overnight
	 */

	public ShowSummary organizeShows(LinkedList<Show> shows)
	{
		LinkedList<Show> dayTime = new LinkedList<Show>();
		LinkedList<Show> primeTime = new LinkedList<Show>();
		LinkedList<Show> lateNight = new LinkedList<Show>();
		for(Show show: shows){
			if (show.broadcastTime >= 0600 && show.broadcastTime< 1700 && !show.isSpecial){
				dayTime.add(show);

			}
			else if (show.broadcastTime >= 1700 && show.broadcastTime < 2200 && !show.isSpecial){
				primeTime.add(show);

			}
			else if (show.broadcastTime >= 2200 || show.broadcastTime< 0100 && !show.isSpecial){
				lateNight.add(show);
			}


		}
		return new ShowSummary (dayTime, primeTime, lateNight);
	}
	
}
