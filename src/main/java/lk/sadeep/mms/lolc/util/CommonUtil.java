package lk.sadeep.mms.lolc.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CommonUtil
{
    public static String convertDateTime(LocalDateTime localDateTime, String dateFormat)
    {
        return localDateTime.format(DateTimeFormatter.ofPattern(dateFormat));
    }
}
