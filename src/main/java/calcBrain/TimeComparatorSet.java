package calcBrain;

import java.util.Comparator;

public class TimeComparatorSet implements Comparator<Exercize>
{
    @Override
    public int compare(Exercize ex1, Exercize ex2)
    {
        return Long.compare(ex2.getElapsed(), ex1.getElapsed());
    }
}
