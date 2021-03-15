package calcBrain;

import java.util.Comparator;

public class StringComparatorSet implements Comparator<Exercize>
{
    @Override
    public int compare(Exercize ex1, Exercize ex2)
    {
        return ex1.toString().compareTo(ex2.toString());
    }
}
