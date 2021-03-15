package calcBrain;

import java.util.Comparator;

public class HashComparatorSet implements Comparator<Exercize>
{
    @Override
    public int compare(Exercize ex1, Exercize ex2)
    {
        return Integer.compare(ex1.hashCode(), ex2.hashCode());
    }
}
