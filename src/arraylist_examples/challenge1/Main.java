package arraylist_examples.challenge1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main
{
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)
    {
        ArrayList<String> groceryList = new ArrayList<>();
        boolean flag = true;
        while (flag)
        {
            printActions();
            switch (Integer.parseInt(scanner.nextLine()))
            {
                case 1 -> addItems(groceryList);
                case 2 -> removeItems(groceryList);
                default -> flag = false;

            }
            groceryList.sort(Comparator.naturalOrder());
            System.out.println(groceryList);
        }
    }

    private static void printActions()
    {
        String textBlock = """
                Available actions: 
                0 - To Quit
                1 - To add item(s) to list
                2 - To remove item(s) from list
                
                Enter a number for which action you want to do:""";
        System.out.println(textBlock + " ");
    }

    private static void addItems(ArrayList<String> groceryList)
    {
        System.out.println("Add item(s).");
        String[] items = scanner.nextLine().split(",");
        // groceryList.addAll(List.of(items));

        for (String item : items)
        {
            String trimmed = item.trim();
            if (!groceryList.contains(trimmed))
            {
                groceryList.add(trimmed);
            }
        }
    }

    private static void removeItems(ArrayList<String> groceryList)
    {
        System.out.println("Remove item(s).");
        String[] items = scanner.nextLine().split(",");

        for (String item : items)
        {
            String trimmed = item.trim();
            groceryList.remove(trimmed);
        }
    }
}