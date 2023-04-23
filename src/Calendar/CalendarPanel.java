package Calendar;

import Calendar.DateButton;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

/**
 * CalendarPanel that creates a grid of 7x6 buttons that all have functionalities for its respective dates to the model. A key "View" in MVC.
 */
public class CalendarPanel extends JPanel
{
    // Keep reference of the DaySquare
    private DateButton[] dayButtons;
    private CalendarModel m;

    /**
     * Creates a new Panel with the buttons. It highlights if the date the model is on is the current day.
     * @param model
     */
    public CalendarPanel(CalendarModel model)
    {
        m = model;
        dayButtons = new DateButton[42];
        setLayout(new GridLayout(6, 7));

        // Find the first day of the month and add up from there
        boolean start = false;
        boolean disable = false;

        // this is the first day
        LocalDate firstDay = LocalDate.of(m.getDate().getYear(), m.getDate().getMonth(), 1);

        // this is the last day
        LocalDate lastDay = firstDay.withDayOfMonth(firstDay.lengthOfMonth());

        // this is the day we will be incrementing
        LocalDate dayCount = LocalDate.of(m.getDate().getYear(), m.getDate().getMonth(), 1);

        for (int i = 0; i < dayButtons.length; i++)
        {
            LocalDate finalDayCount = dayCount;
            if (start)
            {
                if (dayCount.getDayOfMonth() < lastDay.getDayOfMonth() && firstDay.getMonth().equals(dayCount.getMonth()))
                {
                    DateButton newDay = new DateButton(String.valueOf(dayCount.getDayOfMonth()), dayCount);
                    newDay.setFont(new Font("Arial", Font.PLAIN, 20));
                    if (m.getDate().equals(dayCount))
                    {
                        newDay.setFont(new Font("Arial", Font.PLAIN, 50));
                    }
                    newDay.setSize(180, 180);

                    newDay.addActionListener(e -> {
                        JButton temp = (JButton) e.getSource();
                        for (DateButton d : dayButtons)
                        {
                            if (d.equals(temp))
                            {
                                d.setFont(new Font("Arial", Font.PLAIN, 50));
                            } else
                            {
                                d.setFont(new Font("Arial", Font.PLAIN, 20));
                            }
                        }
                        LocalDate current = finalDayCount;
//                      m.viewDay(current);
                        m.setDate(current);
                    });
                    dayButtons[i] = newDay;
                    add(dayButtons[i]);
                    dayCount = dayCount.plusDays(1);

                }

                // The last day
                else
                {
                    DateButton newDay = new DateButton(String.valueOf(dayCount.getDayOfMonth()), dayCount);
                    newDay.setFont(new Font("Arial", Font.PLAIN, 20));
                    if (m.getDate().equals(dayCount))
                    {
                        newDay.setFont(new Font("Arial", Font.PLAIN, 50));
                    }
                    newDay.setSize(180, 180);
                    newDay.addActionListener(e -> {
                        JButton temp = (JButton) e.getSource();
                        for (DateButton d : dayButtons)
                        {
                            if (d.equals(temp))
                            {
                                d.setFont(new Font("Arial", Font.PLAIN, 50));
                            } else
                            {
                                d.setFont(new Font("Arial", Font.PLAIN, 20));
                            }
                        }
                        LocalDate current = finalDayCount;
//                       m.viewDay(current);
                        m.setDate(current);
                    });

                    dayButtons[i] = newDay;
                    add(dayButtons[i]);
//                    System.out.println(dayCount);
                    start = false;

                }
            }
            // If it finds the first day of the week, start printing
            else if (i == firstDay.getDayOfWeek().getValue() && firstDay.getMonth().equals(dayCount.getMonth()))
            {
                DateButton newDay = new DateButton(String.valueOf(dayCount.getDayOfMonth()), dayCount);
                newDay.setFont(new Font("Arial", Font.PLAIN, 20));
                if (m.getDate().equals(dayCount))
                {
                    newDay.setFont(new Font("Arial", Font.PLAIN, 50));
                }
                newDay.setSize(180, 180);
                newDay.addActionListener(e -> {
                    JButton temp = (JButton) e.getSource();
                    for (DateButton d : dayButtons)
                    {
                        if (d.equals(temp))
                        {
                            d.setFont(new Font("Arial", Font.PLAIN, 50));
                        } else
                        {
                            d.setFont(new Font("Arial", Font.PLAIN, 20));
                        }
                    }
                    LocalDate current = finalDayCount;
//                    m.viewDay(current);
                    m.setDate(current);
                });

                dayButtons[i] = newDay;
                add(dayButtons[i]);
                dayCount = dayCount.plusDays(1);

                start = true;

            }

            // If it hasn't found the first day, print a empty square
            else
            {
                dayButtons[i] = new DateButton(null, null);
                add(dayButtons[i]);

            }

        }

    }

    /**
     * Gets the button list
     * @return
     */
    public JButton[] getDaySquares()
    {
        return dayButtons;
    }


    // I might've just made the panel wrong, this seems unorthodox. But it works!
    /**
     * Reruns the program to update to the new model.
     */
    public void updateCalendar()
    {
        // Essentially just run the program again, it will now be updated with the Model changes
        removeAll(); // remove all components from the panel, hard resetting it
        dayButtons = new DateButton[42];
        setLayout(new GridLayout(6, 7));

        // Find the first day of the month and add up from there
        boolean start = false;
        boolean disable = false;

        // this is the first day
        LocalDate firstDay = LocalDate.of(m.getDate().getYear(), m.getDate().getMonth(), 1);

        // this is the last day
        LocalDate lastDay = firstDay.withDayOfMonth(firstDay.lengthOfMonth());

        // this is the day we will be incrementing
        LocalDate dayCount = LocalDate.of(m.getDate().getYear(), m.getDate().getMonth(), 1);

        for (int i = 0; i < dayButtons.length; i++)
        {
            LocalDate finalDayCount = dayCount;
            if (start)
            {
                if (dayCount.getDayOfMonth() < lastDay.getDayOfMonth() && firstDay.getMonth().equals(dayCount.getMonth()))
                {
                    DateButton newDay = new DateButton(String.valueOf(dayCount.getDayOfMonth()), dayCount);
                    newDay.setFont(new Font("Arial", Font.PLAIN, 20));
                    if (m.getDate().equals(dayCount))
                    {
                        newDay.setFont(new Font("Arial", Font.PLAIN, 50));
                    }
                    newDay.setSize(180, 180);

                    newDay.addActionListener(e -> {
                        JButton temp = (JButton) e.getSource();
                        for (DateButton d : dayButtons)
                        {
                            if (d.equals(temp))
                            {
                                d.setFont(new Font("Arial", Font.PLAIN, 50));
                            } else
                            {
                                d.setFont(new Font("Arial", Font.PLAIN, 20));
                            }
                        }
                        LocalDate current = finalDayCount;
//                      m.viewDay(current);
                        m.setDate(current);
                    });
                    dayButtons[i] = newDay;
                    add(dayButtons[i]);
                    dayCount = dayCount.plusDays(1);

                }

                // The last day
                else
                {
                    DateButton newDay = new DateButton(String.valueOf(dayCount.getDayOfMonth()), dayCount);
                    newDay.setFont(new Font("Arial", Font.PLAIN, 20));
                    if (m.getDate().equals(dayCount))
                    {
                        newDay.setFont(new Font("Arial", Font.PLAIN, 50));
                    }
                    newDay.setSize(180, 180);
                    newDay.addActionListener(e -> {
                        JButton temp = (JButton) e.getSource();
                        for (DateButton d : dayButtons)
                        {
                            if (d.equals(temp))
                            {
                                d.setFont(new Font("Arial", Font.PLAIN, 50));
                            } else
                            {
                                d.setFont(new Font("Arial", Font.PLAIN, 20));
                            }
                        }
                        LocalDate current = finalDayCount;
//                       m.viewDay(current);
                        m.setDate(current);
                    });

                    dayButtons[i] = newDay;
                    add(dayButtons[i]);
//                  System.out.println(dayCount);
                    start = false;

                }
            }
            // If it finds the first day of the week, start printing
            else if (i == firstDay.getDayOfWeek().getValue() && firstDay.getMonth().equals(dayCount.getMonth()))
            {
                DateButton newDay = new DateButton(String.valueOf(dayCount.getDayOfMonth()), dayCount);
                newDay.setFont(new Font("Arial", Font.PLAIN, 20));
                if (m.getDate().equals(dayCount))
                {
                    newDay.setFont(new Font("Arial", Font.PLAIN, 50));
                }
                newDay.setSize(180, 180);
                newDay.addActionListener(e -> {
                    JButton temp = (JButton) e.getSource();
                    for (DateButton d : dayButtons)
                    {
                        if (d.equals(temp))
                        {
                            d.setFont(new Font("Arial", Font.PLAIN, 50));
                        } else
                        {
                            d.setFont(new Font("Arial", Font.PLAIN, 20));
                        }
                    }
                    LocalDate current = finalDayCount;
//                    m.viewDay(current);
                    m.setDate(current);
                });

                dayButtons[i] = newDay;
                add(dayButtons[i]);
                dayCount = dayCount.plusDays(1);

                start = true;

            }

            // If it hasn't found the first day, print a empty square
            else
            {
                dayButtons[i] = new DateButton(null, null);
                add(dayButtons[i]);

            }

        }
    }
}
