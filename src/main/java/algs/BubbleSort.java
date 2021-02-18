package algs;

import java.util.Arrays;

/**
 * Сортировка пузырьковая
 * Постоянная перестановка радом стоящих элементов до тех пор, пока массив не будет полностью отсортирован
 */
public class BubbleSort
{
    public int[] bubbleSortArr(int[] a)
    {
        boolean sorted = false;
        while (!sorted)
        {
            sorted = true;
            for (int i = 0; i < a.length - 1; i++)
            {
                if (a[i] > a[i + 1])
                {
                    int tempo = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = tempo;
                    sorted = false;
                }
            }
        }
        return a;
    }

    public static void main(String[] args)
    {
        int[] a = new int[] { 9, 5, 7, 4, 2, 8, 3, 1, 6, 0 };
        BubbleSort bubbleSort = new BubbleSort();
        int[] ints = bubbleSort.bubbleSortArr(a);
        String s = Arrays.stream(ints).mapToObj(x -> String.valueOf(x)).reduce((c, d) -> c + " " + d).get();
        System.out.println(s);
    }
}
