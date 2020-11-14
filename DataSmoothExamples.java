import static org.junit.Assert.*;
import org.junit.Test;
import java.util.LinkedList;

public class DataSmoothExamples 
{  
  LinkedList<Show> shows = new LinkedList<Show>();

  LinkedList<Double> showResults = new LinkedList<Double>();
  DataSmooth1 D1 = new DataSmooth1();
  DataSmooth2 D2 = new DataSmooth2();

  LinkedList<Show> show1 = new LinkedList<Show>();
  LinkedList<Show> show2 = new LinkedList<Show>();
  LinkedList<Double> showResults1 = new LinkedList<Double>();
  LinkedList<Double> showResults2 = new LinkedList<Double>();


  
  public DataSmoothExamples() 
  {
		LinkedList<Episode> eps1 = new LinkedList<Episode>();
		eps1.add(new Episode("Best of Both Worlds", 88));
		eps1.add(new Episode("The Ultimate Computer", 49));
		eps1.add(new Episode("Trials and Tribble-ations", 43));		
		shows.add(new Show("Star Trek", 1800, eps1, false));
		
		LinkedList<Episode> eps2 = new LinkedList<Episode>();
		eps2.add(new Episode("Fear of a Bot Planet", 23));
		eps2.add(new Episode("The Why of Fry", 21));
		eps2.add(new Episode("Roswell that Ends Well", 23));
		eps2.add(new Episode("Meanwhile", 22));
		shows.add(new Show("Futurama", 1900, eps2, false));
		
		LinkedList<Episode> eps3 = new LinkedList<Episode>();
		eps3.add(new Episode("Yakko's World", 4));
		eps3.add(new Episode("Hello Nice Warners", 8));
		eps3.add(new Episode("Where Rodents Dare", 9));
		shows.add(new Show("Animaniacs", 1630, eps3, false));
		
		LinkedList<Episode> eps4 = new LinkedList<Episode>();
		eps4.add(new Episode("The Letter W", 59));
		eps4.add(new Episode("The Letter P", 57));
		eps4.add(new Episode("The Letter I", 58));
		shows.add(new Show("Sesame Street", 900, eps4, false));

	    showResults.add(60.0);
	    showResults.add(29.75);
	    showResults.add(29.08333);
	    showResults.add(58.0);

	    LinkedList<Episode>eps5 = new LinkedList<Episode>();
	    eps5.add(new Episode ("Turtles", 0));
	    eps5.add(new Episode("chickens", 0));
	    eps5.add(new Episode("dolphins",0));

	    show1.add(new Show ("Pigs",700,eps5,false));
	    show1.add(new Show("cows",700,eps5,false));

	    showResults1.add(0.0);
	    showResults1.add(0.0);

	  LinkedList<Episode> eps6 = new LinkedList<Episode>();
	  eps6.add(new Episode("cucumbers", 88));
	  eps6.add(new Episode("pickles", 49));


	  show2.add(new Show("wow", 1800, eps6, false));
	  show2.add(new Show("socks", 1800, eps6, false));
	  show2.add(new Show("hello", 1800, eps6, false));




  }
  
  @Test
  public void instructorTestDS() 
  {
	  LinkedList<Double> runtimes = D1.dataSmooth(shows);
	  
	  for(int i = 0; i < runtimes.size(); i++)
	  {
		  assertEquals(runtimes.get(i), showResults.get(i), .01);
	  }
  }

  @Test
	public void zeroTest(){
  	LinkedList <Double> time = D1.dataSmooth(show1);
  	for (int i = 0; i < time.size(); i++ )
	{
		assertEquals(time.get(i),showResults1.get(i), 0.01);

	}
  }

	@Test
	public void zeroTest2(){
		LinkedList <Double> time = D2.dataSmooth(show1);
		for (int i = 0; i < time.size(); i++ )
		{
			assertEquals(time.get(i),showResults1.get(i), 0.01);

		}
	}



	@Test
	public void dataSmoothTestshow2(){
		LinkedList<Double> runtimes = D1.dataSmooth(show2);
		assertEquals(68.5, runtimes.get(1), .01);

	}


	@Test
	public void dataSmoothTestShows3(){
		LinkedList<Double> runtimes = D2.dataSmooth(show2);
		assertEquals(68.5, runtimes.get(1), .01);

	}



  
}


/*
Subtasks
-Creates  an empty list of double
-Calculates average runTime
-Returns the list of runTimes
-Calculate the average of each of the number and its predecessor and successor (Smooths
 */