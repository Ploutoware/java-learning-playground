package linkedlist.part1;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class Main
{
    public static void main(String[] args)
    {
        LinkedList<String> placesToVisit = new LinkedList<>();
        var placesToVisit2 = new LinkedList<String>(); // defining with "var"

        placesToVisit.add("Sydney");
        placesToVisit.add(0, "Canberra");
        System.out.println(placesToVisit);
        placesToVisit.pop();
        System.out.println(placesToVisit);

        addMoreElements(placesToVisit);
        System.out.println(placesToVisit);

        removeElements(placesToVisit);
        System.out.println(placesToVisit);

        usingAsQueue(placesToVisit2);
        usingAsList(placesToVisit2);

        LinkedList<String> list = new LinkedList<>();
        list.add("Canberk");
        list.add("Ozum");
        list.add("Kaan");
        list.add("Ugur");
        list.add("Tugay");

        gettingElements(list);

        printItinerary(list);
        printItinerary2(list);
        printItinerary3(list);

        System.out.println("-----------");

        testIterator(list);
        testListIterator(list);
    }

    private static void addMoreElements(LinkedList<String> list)
    {
        list.addFirst("Darwin");
        list.addLast("Hobart");

        // Queue methods
        list.offer("Melbourne");
        list.offerFirst("Brisbane");
        list.offerLast("Toowoomba");
        list.push("Turkey");
    }

    private static void removeElements(LinkedList<String> list)
    {
        list.remove(4);
        list.remove("Brisbane");

        System.out.println(list);
        String s1 = list.remove();
        System.out.println(s1 + " removed.");

        String s2 = list.removeFirst();
        System.out.println(s2 + " removed.");

        String s3 = list.removeLast();
        System.out.println(s3 + " removed.");

        // Queue / Deque poll methods
        String p1 = list.poll();
        System.out.println(p1 + " removed.");
        String p2 = list.pollFirst();
        System.out.println(p2 + " removed.");
        String p3 = list.pollLast();
        System.out.println(p3 + " removed.");

        list.push("Sydney");
        list.push("Brisbane");
        list.push("Canberra");
        System.out.println(list);

        String p4 = list.pop();
        System.out.println(p4 + " removed.");
    }

    private static void usingAsQueue(LinkedList<String> list)
    {
        list.offer("Quest1");
        list.offer("Quest2");

        System.out.println(list);

        while (!list.isEmpty())
        {
            String quests = list.poll();
            System.out.println(quests);
            if (quests != null)
            {
                System.out.println("Proceeding..." + quests);
            }
        }
    }

    private static void usingAsList(LinkedList<String> list)
    {
        list.add("ListQuest1");
        list.add("ListQuest2");

        try
        {
            while (true)
            {
                String obj = list.remove();
                System.out.println("Proceeding..." + obj);
            }
        }
        catch (NoSuchElementException e)
        {
            System.out.println("List completed.");
        }
    }

    private static void gettingElements(LinkedList<String> list)
    {
        System.out.println("Retrieved Element: " + list.get(4));

        System.out.println("First Element: " + list.getFirst());
        System.out.println("Last Element: " + list.getLast());

        System.out.println("Ozum is at position: " + list.indexOf("Ozum"));
        System.out.println("Kaan is at position: " + list.lastIndexOf("Kaan"));

        // Queue retrieval method
        System.out.println("Element from element(): " + list.element());

        // Stack retrieval methods
        System.out.println("Element from peek(): " + list.peek());
        System.out.println("Element from peekFirst(): " + list.peekFirst());
        System.out.println("Element from peekLast(): " + list.peekLast());
    }

    private static void printItinerary(LinkedList<String> list)
    {
        System.out.println("List starts with: " + list.getFirst());
        for (int i = 1; i < list.size(); i++)
        {
            System.out.println("--> From: " + list.get(i - 1) + ", to: " + list.get(i));
        }
        System.out.println("List ends with: " + list.getLast());
    }

    private static void printItinerary2(LinkedList<String> list)
    {
        System.out.println("List starts with: " + list.getFirst());
        String previousTown = list.getFirst();
        for (String town : list)
        {
            System.out.println("--> From: " + previousTown + ", to: " + town);
            previousTown = town;
        }
        System.out.println("List ends with: " + list.getLast());
    }

    private static void printItinerary3(LinkedList<String> list)
    {
        System.out.println("List starts with: " + list.getFirst());
        String previousTown = list.getFirst();
        ListIterator<String> iterator = list.listIterator(1);
        while (iterator.hasNext())
        {
            var town = iterator.next();
            System.out.println("--> From: " + previousTown + ", to: " + town);
            previousTown = town;
        }
        System.out.println("List ends with: " + list.getLast());
    }

    private static void testIterator(LinkedList<String> list)
    {
        var iterator = list.iterator();
        while (iterator.hasNext())
        {
            // System.out.println(iterator.next());
            if (iterator.next().equals("Ozum"))
            {
                iterator.remove();
            }
        }
        System.out.println(list);
    }

    private static void testListIterator(LinkedList<String> list)
    {
        var iterator = list.listIterator();
        while (iterator.hasNext())
        {
            if (iterator.next().equals("Canberk"))
            {
                iterator.add("Ozum");
            }
        }

        while (iterator.hasPrevious())
        {
            System.out.println(iterator.previous());
        }
        System.out.println(list);

        var iterator2 = list.listIterator(3);
        System.out.println(iterator2.previous());
    }
}
