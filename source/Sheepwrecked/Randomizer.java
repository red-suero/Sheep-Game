import greenfoot.*;

public class Randomizer  
{
    public static int randomize(double high, double low)
    {
        double random = (high - low) * Math.random() + low;
        return (int) random;
    }
    
    protected static boolean randomChance(int chance)
    {
        if(chance >= getRandomFromRange(0, 100) )
        {
            return true;
        }
        return false;
    }
    
    protected static int getRandomFromRange(int low, int high)
    {
        return (int) (Math.random() * (high - low) + low + 1);
    }
}
