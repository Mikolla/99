package streams;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Поиск индекса максимального элемента в списке при помощи стримов, особеннсть в том, что возвращается не
 * максимумальный элемент, а его индекс в списке
 */
public class FindMaxInListByStream
{

    /**
     * Получение индекса максимального элемента в списке при помощи стримов
     * @param list список интов
     * @return первый индекс максимального элемента из принятого списка (max элементов м.б. несколько)
     */
    public static int findMaxByStream(List<Integer> list) {

        return IntStream.range(0, list.size()).reduce((i, j) -> list.get(i) > list.get(j) ? i : j)
                .orElseThrow();
    }

    @Test
    public static void main(String[] args) {
        List<Integer> ints = Arrays.asList(45, 67, 89, 6, 6, 15, 167, 3, 45, 90, 89);
        int expected = 6;
        int actual = findMaxByStream(ints);
        Assert.assertEquals(expected, actual);
        System.out.println("work");
    }
}
