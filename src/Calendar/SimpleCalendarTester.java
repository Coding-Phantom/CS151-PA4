package Calendar;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * SimpleCalendarTester class that runs the MVC Calendar program. Also handles with events.txt file handling -- will create or load a events.txt file
 * @author David Vu
 * @version 1.0 4/23/23
 */
public class SimpleCalendarTester
{
    public static void main(String[] args) throws IOException
    {

        SimpleCalendarTester();

    }

    /***
     * Creates a new model and views, and attaches the views to the model. Also reads the file with eventFileReader()
     *
     * @throws IOException
     */
    public static void SimpleCalendarTester() throws IOException
    {
        CalendarModel model = new CalendarModel(LocalDate.now());

        eventFileReader(model);

        CalendarView view = new CalendarView(model);
        DayViewFrame dayView = new DayViewFrame(model);

        model.attach(view);
        model.attach(dayView);

        System.out.println(model.printData());
    }

    /***
     * Reads events.txt and adds the data into the CalendarModel
     * @param m the CalendarModel to add
     * @throws IOException
     */
    public static void eventFileReader(CalendarModel m) throws IOException
    {
        File file = new File("events.txt");
        boolean readEvents = false;

        if (!file.exists())
        {
            file.createNewFile();
            System.out.println("Creating new events.txt file.");
        }

        // If the file exists, load the file
        else if (file.exists())
        {
            readEvents = true;
            System.out.println("Loading events.txt file.");
        }

        Scanner scan = new Scanner(file);
        DateTimeFormatter df = DateTimeFormatter.ofPattern("M/d/yy");
        DateTimeFormatter f = DateTimeFormatter.ofPattern("H:mm");

        while(scan.hasNext() && readEvents)
        {
            try
            {
                // This is the event name on the first line
                String name = scan.nextLine();

                // The line after with date and times
                String event = scan.nextLine();

                // Split everything, date, start time, end time
                String[] events = event.split(" ");

                // Parse the date and times
                LocalDate d = LocalDate.parse(events[0], df);
                LocalTime start = LocalTime.parse(events[1], f);
                LocalTime end = LocalTime.parse(events[2], f);


                // Create the event with the name, time interval, and if its recurring
                TimeInterval t = new TimeInterval(start, end);
                Event e = new Event(name, t);
                m.add(d, e);
            }

            catch (Exception e)
            {
                e.printStackTrace();
            }

        }
    }
}
