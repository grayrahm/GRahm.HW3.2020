import static org.junit.Assert.*;
import org.junit.Test;
import java.util.LinkedList;
import java.util.Arrays;

public class ShowExamples
{
    ShowManager1 sm1 = new ShowManager1();
    ShowManager1 sm2 = new ShowManager1();
    ShowManager1 sm3 = new ShowManager1();
    ShowManager1 sm4 = new ShowManager1();
    ShowManager2 sm5 = new ShowManager2();
    ShowManager2 sm6 = new ShowManager2();
    ShowManager2 sm7 = new ShowManager2();
    ShowManager2 sm8 = new ShowManager2();

    LinkedList<Show> shows = new LinkedList<Show>();
    LinkedList<Show> shows2 = new LinkedList<Show>();
    LinkedList<Show> shows3 = new LinkedList<Show>();
    LinkedList<Show> shows4 = new LinkedList<Show>();
    ShowSummary report1 = new ShowSummary();
    ShowSummary report2 = new ShowSummary();
    ShowSummary report3 = new ShowSummary();
    ShowSummary report4 = new ShowSummary();
    ShowSummary report5 = new ShowSummary();




    public ShowExamples()
    {
        LinkedList<Episode> eps1 = new LinkedList<Episode>();
        eps1.add(new Episode("Best of Both Worlds", 88));
        eps1.add(new Episode("The Ultimate Computer", 49));
        eps1.add(new Episode("Trials and Tribble-ations", 43));
        Show s1 = new Show("Star Trek", 1800, eps1, false);
        shows.add(s1);
        report1.primetime.add(s1);

        LinkedList<Episode> eps2 = new LinkedList<Episode>();
        eps2.add(new Episode("Fear of a Bot Planet", 23));
        eps2.add(new Episode("The Why of Fry", 21));
        eps2.add(new Episode("Roswell that Ends Well", 23));
        eps2.add(new Episode("Meanwhile", 22));
        Show s2 = new Show("Futurama", 1900, eps2, false);
        shows.add(s2);
        report1.primetime.add(s2);
        report3.primetime.add(s2);

        LinkedList<Episode> eps3 = new LinkedList<Episode>();
        eps3.add(new Episode("Yakko's World", 4));
        eps3.add(new Episode("Hello Nice Warners", 8));
        eps3.add(new Episode("Where Rodents Dare", 9));
        Show s3 = new Show("Animaniacs", 1630, eps3, false);
        shows.add(s3);
        report1.daytime.add(s3);
        report2.daytime.add(s3);


        LinkedList<Episode> eps4 = new LinkedList<Episode>();
        eps4.add(new Episode("The Letter W", 59));
        eps4.add(new Episode("The Letter P", 57));
        eps4.add(new Episode("The Letter I", 58));
        Show s4 = new Show("Sesame Street", 900, eps4, false);
        shows.add(s4);
        report1.daytime.add(s4);
        report2.daytime.add(s4);

        LinkedList<Episode> eps5 = new LinkedList<Episode>();
        eps5.add(new Episode ("Compulsion", 44));
        eps5.add(new Episode ("scary Murder",45));
        eps5.add(new Episode ("boo",43));
        Show s5 = new Show("Criminal Minds", 0600,eps5,false );
        shows.add(s5);
        report1.daytime.add(s5);
        report2.daytime.add(s5);

        LinkedList<Episode> eps6 = new LinkedList<Episode>();
        eps6.add(new Episode ("Doctor person", 58));
        eps6.add(new Episode ("interns",47));
        eps6.add(new Episode ("Another one?", 55));
        Show s6 = new Show("Grey's Anatomy", 1700,eps6, false);
        shows.add(s6);
        report1.primetime.add(s6);
        report3.primetime.add(s6);

        LinkedList<Episode> eps7 = new LinkedList<Episode>();
        eps7.add(new Episode ("drugs",39));
        eps7.add(new Episode ("Being Bald", 47));
        eps7.add(new Episode ("Chemistry",46));
        Show s7 = new Show( "Breaking Bad", 2200, eps7, false);
        shows.add(s7);
        report1.latenight.add(s7);
        report4.latenight.add(s7);


        LinkedList<Episode> eps8 = new LinkedList<Episode>();
        eps8.add( new Episode ("Dragons?",55));
        eps8.add( new Episode("North wall",45));
        eps8.add(new Episode ("Thrones", 52));
        Show s8 = new Show("Game of Thrones", 2300,eps8, false);
        shows.add(s8);
        report1.latenight.add(s8);
        report4.latenight.add(s8);

        LinkedList<Episode> eps9 = new LinkedList<Episode>();
        eps9.add( new Episode ("who?",88));
        eps9.add( new Episode("What?",45));
        eps9.add(new Episode ("Where?", 100));
        Show s9 = new Show("Lost?", 0700,eps9, false);
        shows.add(s9);




    }

    //////testing Show manager 1
    //test all shows
    @Test
    public void instructorTestOrganizeShows()
    {
        ShowSummary reports1 = sm1.organizeShows(shows);
        assertEquals(report1, reports1);
    }

    //test only daytime with edge case
    @Test
    public void instructorTestOrganizeShows2()
    {
        ShowSummary reports2 = sm2.organizeShows(shows2);
        assertEquals(report2, reports2);
    }
    // test only primetime with edge case
    @Test
    public void instructorTestOrganizeShows3()
    {
        ShowSummary reports3 = sm3.organizeShows(shows3);
        assertEquals(report3, reports3);
    }
    // test only latenight
    @Test
    public void instructorTestOrganizeShows4()
    {
        ShowSummary reports4 = sm4.organizeShows(shows4);
        assertEquals(report4, reports4);
    }
    ////////ShowManager2 tests

    @Test
    public void instructorTestOrganizeShows5()
    {
        ShowSummary reports5 = sm5.organizeShows(shows);
        assertEquals(report5, reports5);
    }

    //

}



/*
Problem 1: SubTasks
    showOrganizer splits the places the show into:
        dayTime -> has a runtime starting at 0600 and ending before 1700
        primeTime -> has a runtime starting at 1700 and ending before 2200
        lateNight - > has a runTime starting at 2200 and ending before 0100
 */