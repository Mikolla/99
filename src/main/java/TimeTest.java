import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class TimeTest
{
    public static void main(String[] args)
    {
        Date nowDate = new Date();
        System.out.println(nowDate.toString());
        System.out.println("Current nowDate in milliseconds is :" + nowDate.getTime());


        Instant now = nowDate.toInstant();/*Instant.now();*/
        System.out.println("milliseconds instant = " + now.toEpochMilli());
        now.atZone(ZoneId.of("GMT"));
        System.out.println(now.toEpochMilli());

        System.out.println("raw zero-zoned Date is " + now);
        System.out.println("ZoneId default = " + ZoneId.systemDefault());
        ZonedDateTime zdt = ZonedDateTime.ofInstant(now, ZoneId.systemDefault());
        System.out.println( "Date zdt is: " + zdt );

        OffsetDateTime now1 = OffsetDateTime.now(ZoneOffset.UTC);

        System.out.println("Time now1 in UTC (GMT) is " + now1);
        System.out.println("seconds = " + now1.toEpochSecond());


        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        System.out.println("cal = " + cal.getTimeInMillis());


        long millisSinceEpoch = LocalDateTime.now()
                .atOffset(ZoneOffset.UTC)
                .toInstant()
                .toEpochMilli();
        System.out.println("millisSinceEpoch = " + millisSinceEpoch);


        TimeZone tz = TimeZone.getDefault();
        long rawOffSet = tz.getRawOffset();
        Date ret = new Date(nowDate.getTime() - tz.getRawOffset());
        long a = OffsetDateTime.now().getOffset().get(ChronoField.OFFSET_SECONDS) * 1000L;
        OffsetDateTime.now().getOffset();
        System.out.println("ret = " + ret.getTime());
    }
}
