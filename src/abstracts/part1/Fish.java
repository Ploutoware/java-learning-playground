package abstracts.part1;

public class Fish extends Animal
{
    public Fish(String type, String size, double weight)
    {
        super(type, size, weight);
    }

    @Override
    public void move(String speed)
    {
        if (speed.equalsIgnoreCase("slow"))
        {
            System.out.println(getExplicitType() + " lazily swimming.");
        }
        else
        {
            System.out.println(getExplicitType() + " running.");
        }
    }

    @Override
    public void makeNoise()
    {
        if (type.equalsIgnoreCase("goldfish"))
        {
            System.out.println("swish ");
        }
        else
        {
            System.out.println("splash ");
        }
    }
}
