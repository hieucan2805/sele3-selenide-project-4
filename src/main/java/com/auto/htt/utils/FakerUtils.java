package com.auto.htt.utils;


import net.datafaker.Faker;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class FakerUtils {
    private static final Faker faker = new Faker();

    public static String word() {
        return faker.lorem().word();
    }

    public static String sentence() {
        return faker.lorem().sentence();
    }

    public static double randomDouble(int min, int max) {
        Random r = new Random();
        double random = min + r.nextDouble() * (max - min);
        return Math.round(random * 100.0) / 100.0;
    }

    public static int randomInteger(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String randomLong() {
        return String.valueOf(Long.parseLong("9199968547408") - System.currentTimeMillis());
    }

    public static double randomDouble() {
        return randomDouble(1, 100);
    }

    public static LocalDate getRandomDate() {
        Random random = new Random();
        int minDay = (int) LocalDate.of(2010, 1, 1).toEpochDay();
        int maxDay = (int) LocalDate.of(2030, 1, 1).toEpochDay();
        long randomDay = minDay + random.nextInt(maxDay - minDay);
        return LocalDate.ofEpochDay(randomDay);
    }

    public static LocalDate getCurrentDate() {
        return LocalDate.now();
    }

    public static String getFormatedCurrentDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(Constants.TIME_FORMAT_CURRENT_DATE);
        LocalDate now = LocalDate.now();
        return dtf.format(now);
    }

    public static String getDate(Object date) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(Constants.TIME_FORMAT_CURRENT_DATE);
        LocalDate tempDate;

        if (date.equals("tomorrow")) {
            tempDate = getCurrentDate().plusDays(1);
        } else if (date.equals("yesterday")) {
            tempDate = getCurrentDate().minusDays(1);
        } else {
            tempDate = getCurrentDate().plusDays((int) date);
        }
        return dtf.format(tempDate);
    }

    public static String getCurrentDateTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(Constants.TIME_FORMAT_CURRENT_DATE_TIME);
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    public static String formatDate(LocalDate date, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return date.format(DateTimeFormatter.ofPattern(format));
    }

    public static String formatStyleDate(LocalDate date, FormatStyle formatStyle) {
        return date.format(DateTimeFormatter.ofLocalizedDate(formatStyle));
    }

    public static String getMonthByTextStyle(LocalDate date, TextStyle textStyle) {
        return date.getMonth().getDisplayName(textStyle, Locale.ENGLISH);
    }

    public static String getYearToString(LocalDate date) {
        return Integer.toString(date.getYear());
    }

}
