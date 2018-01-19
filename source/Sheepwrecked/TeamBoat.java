import greenfoot.*;
import java.util.List;

public class TeamBoat extends Actor
{
    protected boolean shootButton;
    protected int sheep;
    protected int score;
    protected HitBox hBox1;
    protected HitBox hBox2;
    protected int playerNumber;
    protected int resistance;
    protected int fSpeed;
    protected int bSpeed;
    
    public TeamBoat()
    {
        shootButton = false;
        sheep = 0;
        score = 0;
        hBox1 = new HitBox();
        hBox2 = new HitBox();
        resistance = 2;
        fSpeed = 3;
        bSpeed = 2;
    }
    
    public void addedToWorld(World world)
    {
        world.addObject(hBox1, getX(), getY());
        world.addObject(hBox2, getX(), getY());
    }
    
    public void act() 
    {
        moveHitBoxes();
        keyCommands();
        GamePadControls();
        collectSheep();
        depositSheep();
        hitCannonBall();
        checkSheep();
    } 
    
    public void moveHitBoxes()
    {
        hBox1.setRotation(getRotation());
        hBox1.setLocation(getX(), getY());
        hBox1.move(20);
        hBox2.setRotation(getRotation());
        hBox2.setLocation(getX(), getY());
        hBox2.move(-20);
    }
    
    public void checkSheep()
    {
        if(sheep < 0)
        {
            sheep = 0;
        }
    }
    
    public void hitCannonBall()
    {
        CannonBall c = (CannonBall) getOneIntersectingObject(CannonBall.class);
        if(c != null && c.getShooter() != this)
        {
            World w = getWorld();
            w.removeObject(c);
            resistance--;
            if(resistance <= 0)
            {
                resistance = 0;
                sheep--;
            }
        }
    }
    
    public void moveForward()
    {
        for(int i = 0; i < fSpeed; i++)
        {
            if(!hBox1.isTouching(Island.class) && !hBox1.isTouching(HeadQuarters.class))
            {
                move(1);
            }
        }
    }
    
    public void moveBackward()
    {
        for(int i = 0; i < bSpeed; i++)
        {
            if(!hBox2.isTouching(Island.class) && !hBox2.isTouching(HeadQuarters.class))
            {
                move(-1);
            }
        }
    }
    
    public void shoot()
    {
        World w = getWorld();
        CannonBall cballR = new CannonBall();
        w.addObject(cballR, getX(), getY());
        cballR.setRotation(getRotation() + 90);
        cballR.shooter(this);
        CannonBall cballL = new CannonBall();
        w.addObject(cballL, getX(), getY());
        cballL.setRotation(getRotation() - 90);
        cballL.shooter(this);
    }
    
    public void collectSheep()
    {
        Island i = (Island) getOneIntersectingObject(Island.class);
        if(sheep < 5)
        {
            if(i != null && i.containsSheep() && (isTouching(Island.class) || hBox1.isTouching(Island.class) || hBox2.isTouching(Island.class)))
            {
                 i.removeSheep();
                 sheep++;
            }
        }
    }
    
    public void depositSheep()
    {
       HeadQuarters h = (HeadQuarters) getOneIntersectingObject(HeadQuarters.class);
       if(h != null && (isTouching(HeadQuarters.class) || hBox1.isTouching(HeadQuarters.class) || hBox2.isTouching(HeadQuarters.class)) && h.getPlayer() == playerNumber)
       {
           if(sheep > 0)
           {
               sheep--;
               score++;
           }
       }
   }
    
    public void keyCommands()
    {
        if(playerNumber == 1)
        {
            if(Greenfoot.isKeyDown("w") && !Greenfoot.isKeyDown("s"))
            {
                moveForward();
            }
        
            if(Greenfoot.isKeyDown("a"))
            {
                turn(-1);
            }
        
            if(Greenfoot.isKeyDown("s") && !Greenfoot.isKeyDown("w"))
            {
                moveBackward();
            }
        
            if(Greenfoot.isKeyDown("d"))
            {
                turn(1);
            }
        
            if(Greenfoot.isKeyDown("r") && shootButton == false)
            {
               shoot();
               shootButton = true;
            }
        
            if(!Greenfoot.isKeyDown("r") && shootButton == true)
            {
                shootButton = false;
            }
        }
        else if(playerNumber == 2)
        {
            if(Greenfoot.isKeyDown("up") && !Greenfoot.isKeyDown("down"))
            {
                moveForward();
            }
        
            if(Greenfoot.isKeyDown("left"))
            {
                turn(-1);
            }
        
            if(Greenfoot.isKeyDown("down") && !Greenfoot.isKeyDown("up"))
            {
                moveBackward();
            }
        
            if(Greenfoot.isKeyDown("right"))
            {
                turn(1);
            }
        
            if(Greenfoot.isKeyDown("5") && shootButton == false)
            {
               shoot();
               shootButton = true;
            }
        
            if(!Greenfoot.isKeyDown("5") && shootButton == true)
            {
                shootButton = false;
            }
        }
    }
    
    public void GamePadControls()
    {
        
    }
    
    public int getScore()
    {
        return score;
    }
}
