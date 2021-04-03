package algs;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class WordsCounter {
    /**
     * Выполняет поиск слов в предлжении, которые встречаются в нем один раз
     * @param sentence строка, представляющая набор слов, разделенных пробелом (знаков препинания нет)
     * @return список слов, которые встречаются единственный раз в предоставленное строке
     */
    public List<String> countSingleWords(String sentence)
    {
        List<String> words = Arrays.stream(sentence.split(" ")).
                collect(Collectors.groupingBy(s -> s, Collectors.counting())).entrySet().stream().
                filter(s -> s.getValue() == 1).map(x -> x.getKey()).collect(Collectors.toList());
        words.forEach(System.out::println);
        return words;
    }
    public static void main(String[] args) {
        String sentence = "mama mama mama misha vasia maxim misha papa papa grisha";
       WordsCounter wordsCounter = new WordsCounter();
       wordsCounter.countSingleWords(sentence);
    }
}
