package linkedlist.part1;

import java.util.LinkedList;
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
}
