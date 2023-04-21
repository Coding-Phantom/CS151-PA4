package Calendar;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * A Calendar class that can hold multiple events in many dates.
 *
 */
public class MyCalendar
{
    private HashMap<LocalDate, ArrayList<Event>> calendar;
    private LocalDate date;

    private HashMap<String, String> recurringEvents;

    private String oneEvents;


    /**
     * Constructs a calendar object using today's date by default.
     * @param date - today's date
     */
    public MyCalendar(LocalDate date)
    {
        this.calendar = new HashMap<LocalDate, ArrayList<Event>>();
        this.date = date;
        recurringEvents = new HashMap<String, String>();
        oneEvents = "";
    }

    /**
     * Adds a event to a particular date
     * @param d - date to add
     * @param e - event to add to the date
     * @return true if an event has successfully been added, otherwise false
     *
     */
    public boolean add(LocalDate d, Event e)
    {
        // Add the event to the particular hashmap
        // If a date already contains events, then add to it
        if (calendar.containsKey(d))
        {

            // Check each event to see if it overlaps

            for (Event event : calendar.get(d))
            {
                if (e.getTime().overlap(event.getTime()))
                {
                    // It overlaps, do not add
                    System.out.println("Error! This event time overlaps with another event!");
                    return false;
                }
            }

            // Grab all the events within that date
            ArrayList<Event> eventList = calendar.get(d);
            eventList.add(e);
            calendar.put(d, eventList);
        }

        else
        {

            ArrayList<Event> eventList = new ArrayList<Event>();
            eventList.add(e);
            calendar.put(d, eventList);

        }

        return true;
    }

    /**
     * Gets the string of the day
     * @param dee - date to get the string from
     * @return the string of the date
     * @throws Exception if there are no events on that day
     */
    public String getKeyString(LocalDate dee)
    {
        TreeMap<LocalDate, ArrayList<Event>> sort = new TreeMap<>(calendar);
        sort.putAll(calendar);
        String dateAndEvent = "";

        boolean noEvent = false;
        try
        {
            calendar.get(dee).get(0);
        }

        catch (Exception error)
        {
            System.out.println("There are no events on this day!");
            noEvent = true;

        }
        // For every date in the keyset
        // Print out an event

        if (!noEvent)
        {
            for (Event e : calendar.get(dee))
            {

                dateAndEvent += e + "\n";

            }

        }

        return dateAndEvent;
    }

    /**
     * Gets the dates
     * @return the dates
     *
     */
    public Set<LocalDate> getKeySet()
    {
        TreeMap<LocalDate, ArrayList<Event>> sort = new TreeMap<>(calendar);


        return sort.keySet();
    }

    /**
     * Gets the events from that date
     * @return the events from that date
     *
     */
    public ArrayList<Event> getKeyValue(LocalDate d)
    {
        return calendar.get(d);
    }

    /**
     * Removes a single one-time event from the calendar
     * @param d - the date of the event
     * @name - the name of the event to be removed
     * @return true if it got deleted, otherwise its false
     *
     */
    public boolean deleteOneEvent(LocalDate d, String name)
    {
        if (calendar.get(d) == null)
        {
            return false;
        }

        for (Event e : calendar.get(d))
        {
            if (e.getName().equals(name))
            {
                // Delete
                calendar.get(d).remove(e);
                return true;
            }
        }
        return false;
    }

    /**
     * Removes all events from that date
     * @param d - the date of the event
     *
     */
    public void deleteAllDateEvents(LocalDate d)
    {
        if (calendar.get(d) == null)
        {
            return;
        }

        ArrayList<Event> removeList = new  ArrayList<Event> ();

        for (Event e : calendar.get(d))
        {
            if (!e.getIsReccuring())
            {
                removeList.add(e);
            }
        }
        calendar.get(d).removeAll(removeList);

    }

    /**
     * Removes all recurring events with a particular name
     * @param s - The name of the recurring event to remove
     *
     */
    public void deleteAllRecurringEvents(String s)
    {
        HashMap<LocalDate, ArrayList<Event>> temp = new HashMap<>(calendar);
        ArrayList<Event> removeList = new  ArrayList<Event> ();
        for (ArrayList<Event> events : temp.values())
        {
            for (Event e : events)
            {
                if (e.getName().equals(s) && e.getIsReccuring())
                {

                    removeList.add(e);
                }
            }
            events.removeAll(removeList);
            removeList.clear();
        }
    }

    /**
     * Checks if an event is present on that day. Used when displaying the calendar view and seeing events
     * @param d - The date to be viewed
     * @return true if an event is present, otherwise false
     * @throws Exception if there is no event to read
     *
     */
    public boolean checkForEvent(LocalDate d)
    {
        boolean eventPresent = true;
        try
        {
            calendar.get(d).get(0);
        }

        catch (Exception error)
        {
            eventPresent = false;
        }

        return eventPresent;
    }


    /**
     * Gets the date in a unique format
     * @param d - The date string
     * @return string of the formmated date
     *
     */
    public String getDay(LocalDate d)
    {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("E, MMMM dd, yyyy");
        String t = format.format(d);
        return t;
    }

    /**
     * Returns the date
     * @return the date
     *
     */
    public LocalDate getDate()
    {
        return date;
    }

    /**
     * Sets the date
     * @param d - the date to set
     *
     */
    public void setDate(LocalDate d)
    {
        date = d;
    }


    /**
     * toString() for MyCalendar. Used when viewing the events using the EventList function.
     * @return the string object of this class
     *
     */
    // This prints the ArrayList, hence the brackets
    public String toString()
    {
        TreeMap<LocalDate, ArrayList<Event>> sort = new TreeMap<>(calendar);
        sort.putAll(calendar);

        String oneTime = "";
        String recurring = "";

        DateTimeFormatter format = DateTimeFormatter.ofPattern("E, MMMM dd, yyyy");
        // For every date in the keyset
        // Print out an event
        for (LocalDate d : sort.keySet())
        {

            for (Event e : sort.get(d))
            {
                // If it's not recurring
                if (!e.getIsReccuring())
                {
                    oneTime += d.format(format) + "\n";
                    oneTime += e + "\n\n";
                }
            }
        }

        TreeMap<String, String> sortingE = new TreeMap<>(recurringEvents);

        for (String s: sortingE.keySet())
        {
            recurring += sortingE.get(s) + "\n" + s + "\n\n";
        }
        oneTime = oneTime.replace("[", "");
        oneTime = oneTime.replace("]", "");
        recurring = recurring.replace("[", "");
        recurring = recurring.replace("[", "");

        return "ONE TIME EVENTS" + "\n" + oneTime + "\n" + "RECURRING EVENTS" + "\n" + recurring;
    }

    /**
     * Add the string format of the recurring event
     * @param s - date
     * @param t - name
     *
     */
    public void addUniqueRecurringEvent(String s, String t)
    {
        recurringEvents.put(s, t);
    }

    /**
     * Removes the string of the recurring event
     * @param s - date
     *
     */
    public void removeUniqueRecurringEvent(String s)
    {
        recurringEvents.values().removeAll(Collections.singleton(s));
    }

}



