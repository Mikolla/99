package algs;

import java.util.Arrays;

/**
 * Сортировка перестановкой
 */
public class PermutationSorting
{
    public int[] permutationSort(int[] a)
    {
        for (int i = 0; i < a.length; i++)
        {
            for (int j = i + 1; j < a.length; j++)
            {
                if (a[i] < a[j])
                {
                    int b = a[i];
                    a[i] = a[j];
                    a[j] = b;
                }
            }
        }
        return a;
    }

    public static void main(String[] args)
    {
        int[] a = new int[] { 9, 5, 7, 4, 2, 8, 3, 1, 6, 0 };
        PermutationSorting permutationSorting = new PermutationSorting();
        Arrays.stream(permutationSorting.permutationSort(a)).forEach(x -> System.out.print(x + " "));
        System.out.println();
        String reduce = Arrays.stream(permutationSorting.permutationSort(a)).mapToObj(x -> String.valueOf(x))
                .reduce("", (partialString, element) -> partialString + element + " ").trim();
        System.out.println(reduce);
    }
}
