package algs;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.Optional;

import org.junit.Test;

/**
 * Слияние 2-х отсортированных массивов с сохранением сортировки
 */
public class TwoSortedArraysMerge
{
    public static int[] merger(int[] a, int[] b)
    {
        int[] c = new int[a.length + b.length];
        int n = a.length;
        int m = b.length;
        int i = 0, j = 0, k = 0;
        while (i < n && j < m)
        {
            if (a[i] < b[j])
            {
                c[k++] = a[i++];
            }
            else if (a[i] > b[j])
            {
                c[k++] = b[j++];
            }
            else
            {
                c[k++] = a[i];
                c[k++] = a[i++]; j++;
            }
        }
        while (i < n) {
            c[k++] = a[i++];
        }
        while (j < m) {
            c[k++] = b[j++];
        }
        return c;
    }

    @Test
    public void test()
    {
        int[] a = {2, 3, 5, 8,  15, 15, 16, 16, 21, 35, 39, 48, 52};
        int[] b = {2, 4, 5, 5,  6, 7, 16, 17, 19, 22, 52};
        int[] expected = {2, 2, 3, 4, 5, 5, 5, 6, 7, 8, 15, 15, 16, 16, 16, 17, 19, 21, 22, 35, 39, 48, 52, 52};
        int actual[] = merger(a, b);
        Optional<String> optRes = Arrays.stream(actual).mapToObj(x -> String.valueOf(x)).reduce((e, d) -> e + " " + d);
        System.out.println(optRes.orElse("empty"));
        assertArrayEquals(expected, actual);
    }
}
