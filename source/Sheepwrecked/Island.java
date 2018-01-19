import greenfoot.*;

public class Island extends Actor
{
    private int amount;
    private long sheepTimer;
    private boolean done;
    
    public Island(int amount)
    {
        this.amount = amount;
        sheepTimer = System.currentTimeMillis();
        done = false;
    }
    
    public void act()
    {
        if(done == false)
        {
            for(int i = 0; i < amount; i++)
           {
            Sheep s = new Sheep();
            World w = getWorld();
            w.addObject(s, getX() + 20 - i*20, getY() + 20 - i*20);
           }
           done = true;
        }
        addSheep();
    }
    
    public void addSheep()
    {
        if(!containsSheep())
        {
            World w = getWorld();
            long next = sheepTimer + 7000;
            long rightNow = System.currentTimeMillis();
            if(rightNow >= next)
            {
                 sheepTimer = System.currentTimeMillis();
                 int amount2 = Randomizer.getRandomFromRange(1,3);
                 for(int i = 0; i < amount2; i++)
                 {
                     Sheep s = new Sheep();
                     w.addObject(s, getX() + 20 - i*20, getY() + 20 - i*20);
                 }
            }
        }
        else
        {
            sheepTimer = System.currentTimeMillis();
        }
    }
    
    public void removeSheep()
    {
        Sheep s = (Sheep) getOneIntersectingObject(Sheep.class);
        if(s != null && containsSheep())
        {
            World w = getWorld();
            w.removeObject(s);
        }
    }
    
    public boolean containsSheep()
    {
        if(isTouching(Sheep.class))
        {
            return true;
        }
        else 
        {
            return false;
        }
    }
}
