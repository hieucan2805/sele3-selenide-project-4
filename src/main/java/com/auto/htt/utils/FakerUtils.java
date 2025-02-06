package com.auto.htt.utils;


import net.datafaker.Faker;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.FormatStyle;
import java.time.format.TextStyle;
import java.util.Arrays;
import java.util.List;
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

    private static final List<DateTimeFormatter> DATE_FORMATS = Arrays.asList(
            DateTimeFormatter.ofPattern("dd-MM-yyyy"),      // 13-02-2025
            DateTimeFormatter.ofPattern("d-M-yyyy"),        // 3-2-2025
            DateTimeFormatter.ofPattern("dd/MM/yyyy"),      // 13/02/2025
            DateTimeFormatter.ofPattern("d/M/yyyy"),        // 3/2/2025
            DateTimeFormatter.ofPattern("d MMMM yyyy", Locale.ENGLISH), // 13 February 2025
            DateTimeFormatter.ofPattern("dd, MMMM yyyy", Locale.ENGLISH) // 13, February 2025
    );

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

    private static LocalDate parseWithMultipleFormats(String dateStr) {
        for (DateTimeFormatter formatter : DATE_FORMATS)
            try {
                return LocalDate.parse(dateStr, formatter);
            } catch (DateTimeParseException ignored) {
            }
        throw new IllegalArgumentException("Invalid date format: " + dateStr);
    }

    public static String parseSelectedDate(String date) {
        LocalDate localDate;

        switch (date.toLowerCase()) {
            case "today":
                localDate = LocalDate.now();
                break;
            case "tomorrow":
                localDate = LocalDate.now().plusDays(1);
                break;
            case "yesterday":
                localDate = LocalDate.now().minusDays(1);
                break;
            default:
                localDate = parseWithMultipleFormats(date);

                break;
        }
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern(Constants.TIME_FORMAT_CURRENT_DATE);
        return localDate.format(outputFormatter);

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
