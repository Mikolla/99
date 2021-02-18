package algs;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.Optional;

import org.junit.Test;

public class QuickSort
{
    public void quickSort(int[] arr, int from, int to)
    {
        if (from < to)
        {
            int rightIndex = to;
            int leftIndex = from;
            int pivot = arr[from + (to - from) / 2];
            while (leftIndex <= rightIndex)
            {
                while (arr[leftIndex] < pivot)
                {
                    leftIndex++;
                }

                while (arr[rightIndex] > pivot)
                {
                    rightIndex--;
                }
                if (leftIndex <= rightIndex)
                {
                    swap(arr, leftIndex, rightIndex);
                    leftIndex++;
                    rightIndex--;
                }
            }
            int divideIndex = leftIndex;
            quickSort(arr, from, divideIndex - 1);

            quickSort(arr, divideIndex, to);
        }

    }

    private static void swap(int[] array, int index1, int index2)
    {
        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }

    @Test
    public void test()
    {
        int[] a = new int[] { 9, 5, 7, 4, 2, 8, 3, 1, 6, 0 };
        int[] expected = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        /*QuickSort quickSort = new QuickSort();
        quickSort.quickSort(a, 0, a.length - 1);*/
        MeasureTime.measureTime(() -> quickSort(a, 0, a.length - 1));
        Optional<String> resultStr = Arrays.stream(a).mapToObj(x -> String.valueOf(x)).reduce((c, d) -> c + " " + d);
        System.out.println(resultStr.get());
        assertArrayEquals(expected, a);
    }

}
