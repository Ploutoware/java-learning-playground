package interfaces.part1;

public class Jet implements FlightEnabled, Trackable
{
    @Override
    public void takeOff()
    {
        System.out.println(getClass().getSimpleName() + " is taking off.");
    }

    @Override
    public void land()
    {
        System.out.println(getClass().getSimpleName() + " is landing.");
    }

    @Override
    public void fly()
    {
        System.out.println(getClass().getSimpleName() + " is flying.");
    }

    @Override
    public void track()
    {
        System.out.println(getClass().getSimpleName() + "'s coordinates recorded.");
    }

    @Override
    public FlightStages transition(FlightStages stage)
    {
        System.out.println(getClass().getSimpleName() + " transitioning.");
        return FlightEnabled.super.transition(stage);
    }
}
