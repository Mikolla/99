package calcBrain;

import java.util.Objects;

public class Exercize
{
    public int factorOne;
    public int factorTwo;
    public char act = '*';
    long elapsed = 0;

    public Exercize(int factorOne, int factorTwo, char act)
    {
        this.factorOne = factorOne;
        this.factorTwo = factorTwo;
        this.act = act;
        this.elapsed = 0;
    }

    public int getFactorOne()
    {
        return factorOne;
    }

    public void setFactorOne(int factorOne)
    {
        this.factorOne = factorOne;
    }

    public int getFactorTwo()
    {
        return factorTwo;
    }

    public void setFactorTwo(int factorTwo)
    {
        this.factorTwo = factorTwo;
    }

    public char getAct()
    {
        return act;
    }

    public void setAct(char act)
    {
        this.act = act;
    }

    public long getElapsed()
    {
        return elapsed;
    }

    public void setElapsed(long elapsed)
    {
        this.elapsed = elapsed;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (!(o instanceof Exercize))
            return false;
        Exercize exercize = (Exercize)o;
        return getFactorOne() == exercize.getFactorOne() && getFactorTwo() == exercize.getFactorTwo()
                && getAct() == exercize.getAct() && getElapsed() == exercize.getElapsed();
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getFactorOne(), getFactorTwo(), getAct(), toString());
    }

    @Override
    public String toString()
    {
        return getFactorOne() + " " + getAct() + " " + getFactorTwo() + " = ";
    }
}
