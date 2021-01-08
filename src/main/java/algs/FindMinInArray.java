package algs;

public class FindMinInArray
{
    public int findMin (int[] array)
    {
        int minIndex = 0;
        int min = array[minIndex];
        for (int i = 0; i < array.length; i++)
        {
            if (min > array[i])
            {
                minIndex = i;
                min = array[minIndex];
            }
        }
        return minIndex;
    }

    public static void main(String[] args)
    {
        FindMinInArray findMinInArray = new FindMinInArray();
        int min = findMinInArray.findMin(new int[] { 1, 4, 10, -1, 5, 0 , -0});
        System.out.println(min);
    }
}
