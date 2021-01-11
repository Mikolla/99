package algs;

import java.util.Arrays;
import java.util.Optional;
import org.junit.Test;
import static org.junit.Assert.*;

public class ChooseSort
{
    public int[] chooseSort(int[] a)
    {
        for (int i = 0; i < a.length; i++)
        {
            int min = findMinInPartOfArray(a, i);
            int tempo = a[min];
            a[min] = a[i];
            a[i] = tempo;
        }
        return a;
    }

    public int findMinInPartOfArray(int[] array, int start)
    {
        int minIndex = start;
        int min = array[minIndex];
        for (int i = start + 1; i < array.length; i++)
        {
            if (min > array[i])
            {
                minIndex = i;
                min = array[minIndex];
            }
        }
        return minIndex;
    }

    @Test
    public void test()
    {
        int[] a = new int[] { 9, 5, 7, 4, 2, 8, 3, 1, 6, 0 };
        int[] expected = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        ChooseSort chooseSort = new ChooseSort();
        int[] actual = chooseSort.chooseSort(a);
        Optional<String> resultStr = Arrays.stream(a).mapToObj(x -> String.valueOf(x)).reduce((c, d) -> c + " " + d);
        System.out.println(resultStr.get());
        assertArrayEquals(expected, actual);
    }
}
