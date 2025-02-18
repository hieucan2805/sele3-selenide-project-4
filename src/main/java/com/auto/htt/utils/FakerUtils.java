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



}
