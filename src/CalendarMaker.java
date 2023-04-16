import javax.swing.*;
import java.awt.*;

public class CalendarMaker extends JPanel
{
    public CalendarMaker()
    {
        setLayout(new GridLayout(6, 7));

        for (int i = 0; i < 42; i++)
        {
            add(new Days());
        }

    }
}
