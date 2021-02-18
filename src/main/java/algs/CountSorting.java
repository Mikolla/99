package algs;

import java.util.Arrays;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Stream;

/**
 * Сортировка подсчетом массива интов
 */
public class CountSorting
{
    public static void countSorter(int[] a)
    {
        final int MAX_VAL = 1000;

        int[] count = new int[MAX_VAL];
        for (int i = 0; i < a.length; i++)
        {
            count[a[i]] = count[a[i]] + 1;
        }
        int arrayIndex = 0;
        for (int i = 0; i < count.length; i++)
        {
            for (int j = 0; j < count[i]; j++)
            {
                a[arrayIndex++] = i;
            }
        }
    }

    public static void main(String[] args)
    {
        /*
        отсюда видно, что сортировка массива подсчетом для диапазона интов 1000 работает примерно в 10-12 раз быстрей
         */
        int[] a = (new Random()).ints(1000000, 0, 1000).toArray();
        int[] b = Arrays.copyOf(a, 1000000);

        MeasureTime measureTime = new MeasureTime();
        measureTime.measureTime(() -> countSorter(a));
        QuickSort qs = new QuickSort();
        measureTime.measureTime(() -> qs.quickSort(b,0, 1000000-1));
        //Optional<String> resultOpt = Arrays.stream(a).mapToObj(String::valueOf).reduce((c, d) -> c + " " + d);
        //System.out.println(resultOpt.orElse("empty"));
    }
}