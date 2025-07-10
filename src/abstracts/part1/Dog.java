package abstracts.part1;

public class Dog extends Mammal
{
    public Dog(String type, String size, double weight)
    {
        super(type, size, weight);
    }

    @Override
    public void move(String speed)
    {
        if (speed.equalsIgnoreCase("slow"))
        {
            System.out.println(getExplicitType() + " walking.");
        }
        else
        {
            System.out.println(getExplicitType() + " running.");
        }
    }

    @Override
    public void shedHair() {
        System.out.println(getExplicitType() + " sheds all the time.");
    }

    @Override
    public void makeNoise()
    {
        if (type.equalsIgnoreCase("Wolf"))
        {
            System.out.println("Howling! ");
        }
        else
        {
            System.out.println("Woof! ");
        }
    }
}
