package com.lib.tdt.thejan.timedateformatertdtapps;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by ThejanThrimanna on 2016-10-17.
 */
public class TimeDateFormatter {

    public static String FORMAT1 = "yyyy.MM.dd G 'at' HH:mm:ss z";
    public static String FORMAT2 = "EEE, MMM d, ''yy";
    public static String FORMAT3 = "h:mm a";
    public static String FORMAT4 = "hh 'o''clock' a, zzzz";
    public static String FORMAT5 = "K:mm a, z";
    public static String FORMAT6 = "yyyyy.MMMMM.dd GGG hh:mm aaa";
    public static String FORMAT7 = "EEE, d MMM yyyy HH:mm:ss Z";
    public static String FORMAT8 = "yyMMddHHmmssZ8";
    public static String FORMAT9 = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
    public static String FORMAT10 = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";
    public static String FORMAT11 = "YYYY-'W'ww-u";

    /**
     * This methoad use to change the string addedTime to millisecond addedTime.
     *
     * @param timeX   millisecond addedTime to return
     * @param formatX String addedTime
     * @return
     */
    public static String convertMilliSecondsToString(long timeX, String formatX) {

        //long timeInMillis = 0;

        SimpleDateFormat formatter = new SimpleDateFormat(formatX);

        // Create a calendar object that will convert the date and addedTime value in milliseconds to date.
        Calendar calendar = Calendar.getInstance();
        //calendar.setTimeInMillis(new Date().getAddedTime());
        calendar.setTimeInMillis(timeX);

        return formatter.format(calendar.getTime());
        //paymentUpdate.setPaymentDate(formatter.format(calendar.getAddedTime()));

    }

    /**
     * This method uses to change the addedTime format ot another format
     *
     * @param currentFormmat
     * @param newFormat
     * @param timeX
     * @return
     */

    public static String convertStringFormatToAnotherStringFormat(String currentFormmat, String newFormat, String timeX) {

        SimpleDateFormat inputFormat = new SimpleDateFormat(currentFormmat);
        SimpleDateFormat outputFormat = new SimpleDateFormat(newFormat);

        Date date = null;
        String str = null;

        try {
            date = inputFormat.parse(timeX);
            str = outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return str;

    }

    /**
     *
     * @param timeString
     * @param format
     * @return
     */

    public static long convertStringToMilliseconds(String timeString , String format){

        Date lastdate = new Date();
        try {
            lastdate = new SimpleDateFormat(format).parse(timeString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return lastdate.getTime();
    }




}
