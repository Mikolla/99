package streams;

import java.util.Arrays;
import java.util.Optional;

public class NoRepeats
{
    public static void main(String[] args)
    {
        /*
Stream<String> wordsStream = Stream.of("мама", "мыла", "раму");
Optional<String> sentence = wordsStream.reduce((x,y)->x + " " + y);
System.out.println(sentence.get());
         */
        String dataString = "Сссбббеерр, пррриииввеетттт! Как дела? А?";
        String[] split = dataString.split("");
        Optional<String> reduce = Arrays.stream(split).reduce((x, y) ->
        {
            if (x.endsWith(y) || x.endsWith(y.toLowerCase()) || x.endsWith(y.toUpperCase()))
            {
                return x;
            }
            return x + y;
        });
        System.out.println(reduce.get());
    }
}
