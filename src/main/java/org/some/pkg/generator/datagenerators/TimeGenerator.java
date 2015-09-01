package org.some.pkg.generator.datagenerators;

import org.joda.time.DateTime;

import java.util.Random;

/**
 * Created by siarqua on 24.07.15.
 */
public class TimeGenerator {

    private final int minMonth;
    private final int minDay;
    private final int minHour;
    private final int minMinute;
    private final int minSceound;
    private Random random;
    private int minYer;
    private int maxYer;
    private int maxMonth;
    private int maxDay;
    private int maxHour;
    private int maxMinute;
    private int maxSceound;
    private DateTime dateTime;

    public TimeGenerator() {
        this(2016, 2015);
    }

    public TimeGenerator(int maxYer, int minYer) {
        this.random = new Random();
        this.dateTime = new DateTime();
        this.maxYer = maxYer;
        this.minYer = minYer;
        this.maxMonth = dateTime.monthOfYear().getMaximumValue();
        this.maxDay = dateTime.dayOfMonth().getMaximumValue();
        this.maxHour = dateTime.hourOfDay().getMaximumValue();
        this.maxMinute = dateTime.minuteOfHour().getMaximumValue();
        this.maxSceound = dateTime.secondOfMinute().getMaximumValue();
        this.minMonth = dateTime.monthOfYear().getMinimumValue();
        this.minDay = dateTime.dayOfMonth().getMinimumValue();
        this.minHour = dateTime.hourOfDay().getMinimumValue();
        this.minMinute = dateTime.minuteOfHour().getMinimumValue();
        this.minSceound = dateTime.secondOfMinute().getMinimumValue();
    }

    public DateTime generate() {
        return new DateTime();
    }

    public DateTime generateAfter(DateTime time) {
        DateTime endTime = new DateTime(maxYer, maxMonth, maxDay, maxHour, maxMinute, maxSceound);
        return generate(time, endTime);
    }

   public DateTime generateBefore(DateTime time) {
        DateTime startTime = new DateTime(minYer,minMonth, minDay, minHour, minMinute, minSceound);
        return generate(startTime, time);
    }

    public DateTime addMinutes(DateTime dateTime, int minutes) {
        return dateTime.plusMinutes(minutes);
    }

    public DateTime generate(DateTime startDate, DateTime endDate) {
        int randomYer = randomBetween(startDate.getYear(), endDate.getYear());
        int randomMonth = randomBetween(startDate.getMonthOfYear(), endDate.minusDays(1).getMonthOfYear());
        int randomDay = randomBetween(startDate.getDayOfMonth(), endDate.minusDays(1).getDayOfMonth());
        int randomHour = randomBetween(startDate.getHourOfDay(), endDate.minusMinutes(1).getHourOfDay());
        int randomMinute = randomBetween(startDate.getMinuteOfHour(), endDate.minusMinutes(1).getMinuteOfHour());
        int randomSecond = randomBetween(startDate.getSecondOfMinute(), endDate.minusSeconds(1).getSecondOfMinute());
        return new DateTime(randomYer, randomMonth, randomDay, randomHour, randomMinute, randomSecond);
    }

    private int randomBetween(int start, int end) {
        int result = 0;
        try {
            result = tryToGenerateRandomBetweenresult(start, end);
        } catch (Exception e) {
            System.out.println("start = " + start);
            System.out.println("end = " + end);
            System.out.println("result = " + result);
            throw new IllegalArgumentException(e);
        }
        return result;
    }

    private int tryToGenerateRandomBetweenresult(int start, int end) {
        int result = 0;
        if (start != end){
            result = generateRandomBeetwenResult(start, end);
        } else {
            result = start;
        }
        return result;
    }

    private int generateRandomBeetwenResult(int start, int end) {
        int result =0;
        int bound = end - start;
        bound = setBoundGreaterThenZero(bound);
        result = random.nextInt(bound) + start;
        result = setResultGreaterThenZero(result);
        return result;
    }

    private int setResultGreaterThenZero(int result) {
        if (result < 0 ){
            result *= -1;
        }
        return result;
    }

    private int setBoundGreaterThenZero(int bound) {
        bound = setResultGreaterThenZero(bound);
        return bound;
    }
}
