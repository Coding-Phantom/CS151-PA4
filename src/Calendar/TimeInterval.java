package Calendar;

import java.time.LocalTime;

/**
 * A TimeInterval class to hold two times.
 *
 */
public class TimeInterval
{
    private LocalTime st;
    private LocalTime et;


    /**
     * Constructs a TimeInterval object to hold two times.
     * @param st - start time
     * @param et - end time
     * precondition: times must be in military time
     *
     */
    public TimeInterval(LocalTime st, LocalTime et)
    {
        this.st = st;
        this.et = et;
    }

    /**
     * Return the start time
     * @return start time
     */
    public LocalTime getSt()
    {
        return st;
    }

    /**
     * Return the end time
     * @return end time
     */
    public LocalTime getEt()
    {
        return et;
    }

    /**
     * Determines whether the given time interval overlaps with another time interval
     * @return true if the times overlap, otherwise returns false;
     */
    public boolean overlap(TimeInterval b)
    {

        boolean overlap = ((st.compareTo(b.getEt()) <= 0) && (et.compareTo(b.getSt()) >= 0));
        return overlap;
    }

    /**
     * Returns the toString() of this object
     * @return toString() of this object
     */
    public String toString()
    {
        String start = st.toString();
        if (start.substring(0, 1).equals("0"))
        {
            start = start.substring(1, start.length());
        }
        String end = et.toString();
        if (end.substring(0, 1).equals("0"))
        {
            end = end.substring(1, end.length());
        }

        return start + " - " + end;
    }
}
