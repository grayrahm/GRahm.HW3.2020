import java.util.LinkedList;

class ShowManager2 {

	ShowManager2() {
	}

	public ShowSummary organizeShows(LinkedList<Show> shows) {

		LinkedList<Show> cleanedList = this.clean(shows);
		LinkedList<Show> cleanedDayTime = new LinkedList<>();
		LinkedList<Show> cleanedPrimeTime = new LinkedList<>();
		LinkedList<Show> cleanedLateNight = new LinkedList<>();

		for(Show s: cleanedList) {
			if (s.broadcastTime >= 0600 && s.broadcastTime < 1700) {
				cleanedDayTime.add(s);
			}
			else if (s.broadcastTime >= 1700 && s.broadcastTime < 2200) {
				cleanedPrimeTime.add(s);
			}
			else if (s.broadcastTime >= 2200 && s.broadcastTime < 0100) {
				cleanedLateNight.add(s);
			}
			else return null;
		}
		return new ShowSummary(cleanedDayTime, cleanedPrimeTime, cleanedLateNight);
	}

	/**
	 * Accumulator that gives only a list of shows during daytime, prime time,
	 * and late night that aren't specials
	 *
	 * @param show
	 * @return
	 */

	LinkedList<Show> clean(LinkedList<Show> show) {
		LinkedList<Show> cleanedList = new LinkedList<>();

		for (Show s : show) {
			if (!s.isSpecial)
				cleanedList.add(s);
		}
		return cleanedList;
	}

}