package Calendar;

import Calendar.DateButton;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class CalendarPanel extends JPanel
{
    // Keep reference of the DaySquare
    private DateButton[] dayButtons;
    private CalendarModel m;

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
                    System.out.println(dayCount);
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

    public JButton[] getDaySquares()
    {
        return dayButtons;
    }

    public void updateCalendar()
    {
        // Essentially just run the program again, it will now be updated with the Model changes
        removeAll(); // remove all components from the panel, hard reseting it
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
                    System.out.println(dayCount);
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
