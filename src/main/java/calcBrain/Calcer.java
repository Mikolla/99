package calcBrain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Calcer
{
    public TreeMap<Integer, Exercize> exMap = new TreeMap<>();
    public Comparator<Exercize> exComparator = new TimeComparatorSet().thenComparing(new HashComparatorSet());
    public Set<Exercize> exSet = new TreeSet<>(exComparator);

    public void initialiser()
    {
        exMap.put(1, new Exercize(3, 13, '*'));
        exMap.put(2, new Exercize(4, 13, '*'));
        exMap.put(3, new Exercize(5, 13, '*'));
        exMap.put(4, new Exercize(6, 13, '*'));
        exMap.put(5, new Exercize(6, 13, '*'));
        exMap.put(6, new Exercize(7, 13, '*'));
        exMap.put(7, new Exercize(8, 13, '*'));
        exMap.put(8, new Exercize(9, 13, '*'));
        exMap.put(9, new Exercize(10, 13, '*'));
        exMap.put(10, new Exercize(12, 13, '*'));
        exMap.put(11, new Exercize(13, 13, '*'));
        exMap.put(12, new Exercize(14, 13, '*'));
        exMap.put(13, new Exercize(15, 13, '*'));
        exMap.put(14, new Exercize(3, 13, '*'));
        exMap.put(15, new Exercize(4, 13, '*'));
        exMap.put(16, new Exercize(5, 13, '*'));
        exMap.put(17, new Exercize(6, 13, '*'));
        exMap.put(18, new Exercize(6, 13, '*'));
        exMap.put(19, new Exercize(7, 13, '*'));
        exMap.put(20, new Exercize(8, 13, '*'));
        exMap.put(21, new Exercize(9, 13, '*'));
        exMap.put(22, new Exercize(10, 13, '*'));
        exMap.put(23, new Exercize(12, 13, '*'));
        exMap.put(24, new Exercize(13, 13, '*'));
        exMap.put(25, new Exercize(14, 13, '*'));
        exMap.put(26, new Exercize(15, 13, '*'));


        exSet.add(new Exercize(3, 13, '*'));
        exSet.add(new Exercize(4, 13, '*'));
        exSet.add(new Exercize(5, 13, '*'));
        exSet.add(new Exercize(6, 13, '*'));
        exSet.add(new Exercize(6, 13, '*'));
        exSet.add(new Exercize(7, 13, '*'));
        exSet.add(new Exercize(8, 13, '*'));
        exSet.add(new Exercize(9, 13, '*'));
        exSet.add(new Exercize(10, 13, '*'));
        exSet.add(new Exercize(12, 13, '*'));
        exSet.add(new Exercize(13, 13, '*'));
        exSet.add(new Exercize(14, 13, '*'));
        exSet.add(new Exercize(15, 13, '*'));
        exSet.add(new Exercize(3, 13, '*'));
        exSet.add(new Exercize(4, 13, '*'));
        exSet.add(new Exercize(5, 13, '*'));
        exSet.add(new Exercize(6, 13, '*'));
        exSet.add(new Exercize(6, 13, '*'));
        exSet.add(new Exercize(7, 13, '*'));
        exSet.add(new Exercize(8, 13, '*'));
        exSet.add(new Exercize(9, 13, '*'));
        exSet.add(new Exercize(10, 13, '*'));
        exSet.add(new Exercize(12, 13, '*'));
        exSet.add(new Exercize(13, 13, '*'));
        exSet.add(new Exercize(14, 13, '*'));
        exSet.add(new Exercize(15, 13, '*'));
    }


    public Set<Exercize> getExSet()
    {
        return exSet;
    }

    public void setExSet(Set<Exercize> exSet)
    {
        this.exSet = exSet;
    }

    public boolean validateAnswer(String number, int expected)
    {
        //return number.equals("") || !number.matches("^[0-9]*$") || Integer.parseInt(number) != expected;
        System.out.println("number = " + number);
        String expectedStr = String.valueOf(expected);
        System.out.println("expectedStr = " + expectedStr);
        boolean equal = expectedStr.equals(number);
        return equal;
    }

    public void puller(Exercize exercize)
    {
        System.out.print(exercize.getElapsed() + " " + exercize.getFactorOne() + " * " + exercize.getFactorTwo()
                + " = ");
        int expected = exercize.getFactorOne() * exercize.getFactorTwo();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;
        try
        {
            String resultString = "";
            resultString = reader.readLine();
            boolean isValid = validateAnswer(resultString, expected);
            while (!isValid)
            {
                System.out.println("Попробуйте еще");
                resultString = reader.readLine();
                isValid = validateAnswer(resultString, expected);
            }
            result = Integer.parseInt(resultString);

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        System.out.println(result);
    }

    public void launcher()
    {
        initialiser();
        MeasureTimer measureTimer = new MeasureTimer();
        System.out.println("Введите \"Y\" для продолжения:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            reader.readLine();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        Set<Exercize> exSet = getExSet();
        int i = exSet.size();
        int lim = i / 5;
        while (i > lim)
        {
            for (Exercize ex : exSet)
            {
                long elapsed = measureTimer.measureTime(() -> puller(ex));
                ex.setElapsed(elapsed);
            }
            i = i / 2;
            Set<Exercize> s = new TreeSet<>(exComparator);
            exSet.stream().sorted(exComparator).limit(i).forEach(x -> s.add(x));
            exSet = s;
            System.out.println("новая итерация, кол-во примеров =  " + exSet.size());
        }
        System.out.println("ну и все!");
    }


    public static void main(String[] args) throws IOException
    {
        Calcer calcer = new Calcer();
        calcer.launcher();
    }
}
