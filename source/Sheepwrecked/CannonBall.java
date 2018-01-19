import greenfoot.*;

public class CannonBall extends Actor
{
    public TeamBoat shooter;
    
    public void act() 
    {
        move(2);
        disappear();
    }    
    
    public void disappear()
    {
        if(isAtEdge())
        {
            World w = getWorld();
            w.removeObject(this);
        }
    }
    
    public void shooter(TeamBoat shooter)
    {
        this.shooter = shooter;
    }
    
    public TeamBoat getShooter()
    {
        return shooter;
    }
}
