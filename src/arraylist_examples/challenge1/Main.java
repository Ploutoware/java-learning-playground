package arraylist_examples.challenge1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        /*
         * Available actions
         * 0 - To shutdown
         * 1 - To add item(s) to list (comma delimited list)
         * 2 - To remove any item(s) (comma delimited list)
         *
         * Use ArrayList to add items, remove items, check if an item is already in the list
         * */

        Scanner input = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        list.addAll(List.of("Banana", "Bread", "Apple"));


        System.out.println("Welcome to the Grocery List application.");
        System.out.println("Please enter a number from the menu.");
        System.out.println("0 - To Quit");
        System.out.println("1 - To Add New Item to the List");
        System.out.println("2 - To Remove Item from the List");
        int option = input.nextInt();

        while (option != 0 && option != 1 && option != 2){
            System.out.println("Please enter a number from the menu.");
            option = input.nextInt();
        }

        if (option == 0) {
            System.out.println("Quitting...");
            System.exit(0);
        } else if (option == 1) {
            while(option != 0) {
                System.out.println("Please add an item.");
                String name = input.next();
                while (list.contains(name)) {
                    System.out.println("This item is already on the list.");
                    System.out.println("Please enter an another item.");
                    name = input.next();
                }

                list.add(name);
                System.out.println("Item added successfully.");
                System.out.println("List: " + list);

                System.out.println("If you want to continue to add item, press 1.");
                System.out.println("If you want to quit, press 0.");
                option = input.nextInt();
            }
        } else {
            while (option != 0) {
                System.out.println("Your Grocery List:");
                System.out.println(list);
                System.out.println("Enter a name to remove item from the list.");
                String name = input.next();

                if (!list.contains(name)) {
                    System.out.println("This item is not on the list.");
                    System.out.println("Please enter an another item.");
                } else {
                    list.remove(name);
                    System.out.println("Item successfully removed.");
                    System.out.println(list);
                }

                System.out.println("If you want to continue to add item, press 1.");
                System.out.println("If you want to quit, press 0.");
                option = input.nextInt();
            }
        }
    }
}
