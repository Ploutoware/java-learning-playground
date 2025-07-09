package enums.part1;

import enums.part1.DayOfTheWeek;

import java.util.Random;

public class Main
{
    public static void main(String[] args)
    {
        DayOfTheWeek weekDay = DayOfTheWeek.TUESDAY;
        System.out.println(weekDay);

        System.out.printf("Name is %s, Ordinal Value = %d%n", weekDay.name(), weekDay.ordinal());

        /*for (int i = 0; i < 10; i++)
        {
            *//*var randomDay = getRandomDay();
            System.out.printf("Name is %s, Ordinal Value = %d%n", randomDay.name(), randomDay.ordinal());*//*

            switchDayOfWeek(weekDay);
        }*/

        for (Topping topping : Topping.values())
        {
            System.out.println(topping.name() + " : " + topping.getPrice());
        }
    }

    public static void switchDayOfWeek(DayOfTheWeek weekDay)
    {
        int weekDayInteger = weekDay.ordinal() + 1;

        switch (weekDay)
        {
            case WEDNESDAY -> System.out.println("Wednesday is Day " + weekDayInteger);
            case SATURDAY -> System.out.println("Saturday is Day " + weekDayInteger);
            default -> System.out.println(weekDay.name().charAt(0) +
                    weekDay.name().substring(1).toLowerCase() + " day is Day " + weekDayInteger);
        }
    }

    public static DayOfTheWeek getRandomDay()
    {
        int randomInteger = new Random().nextInt(7);
        var allDays = DayOfTheWeek.values();

        return allDays[randomInteger];
    }
}
