package streams;

import java.util.Arrays;
import java.util.Optional;


import org.junit.Assert;
import org.junit.Test;

public class NoRepeats
{

    String noRepeatSber(String stringSber)
    {
        String[] split = stringSber.split("");
        Optional<String> resultOpt = Arrays.stream(split).reduce((x, y) ->
                x.endsWith(y) || x.endsWith(y.toLowerCase()) || x.endsWith(y.toUpperCase()) ? x : x + y);
        return resultOpt.orElse(null);
    }

    @Test
    public void sberNorepeatTest()
    {
        String dataString = "Сссбббеерр, пррриииввеетттт! Как дела? А?";
        String expected = "Сбер, привет! Как дела? А?";
        NoRepeats noRepeats = new NoRepeats();
        String actual = noRepeats.noRepeatSber(dataString);
        Assert.assertEquals(expected, actual);
    }
}
