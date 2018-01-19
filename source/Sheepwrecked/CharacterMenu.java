import greenfoot.*;

public class CharacterMenu extends World
{
    private int numberOfPlayers;
    private String p1c;
    private String p2c;
    private String p3c;
    private String p4c;
    private Knights k;
    private Vikings v;
    private Mages m;
    private Barbarians b;
    private USNavy us;
    private boolean choice1;
    private boolean choice2;
    private boolean choice3;
    private boolean choice4;
    private int map;
    private boolean cheating;
    
    public CharacterMenu(int numberOfPlayers, int map, boolean cheating)
    {    
        super(1000, 800, 1);
        this.numberOfPlayers = numberOfPlayers;
        this.map = map;
        this.cheating = cheating;
        if(numberOfPlayers == 2)
        {
            p3c = "none";
            p4c = "none";
        }
        
        if(numberOfPlayers == 3)
        {
            p4c = "none";
        }
        
        k = new Knights(0);
        addObject(k, 250, 300);
        
        v = new Vikings(0);
        addObject(v, 250, 500);
        
        m = new Mages(0);
        addObject(m, 750, 500);
        
        b = new Barbarians(0);
        addObject(b, 750, 300);
        
        if(cheating == true)
        {
            us = new USNavy(0);
            addObject(us, 500, 400);
        }
        
        choice1 = false;
        choice2 = false;
        choice3 = false;
        choice4 = false;
    }
    
    public void act()
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        
        if(mouse != null && Greenfoot.mouseClicked(k) == true && choice1 == false)
        {
            p1c = "Knights";
            choice1 = true;
        }
        else if(mouse != null && Greenfoot.mouseClicked(v) == true && choice1 == false)
        {
            p1c = "Vikings";
            choice1 = true;
        }
        else if(mouse != null && Greenfoot.mouseClicked(m) == true && choice1 == false)
        {
            p1c = "Mages";
            choice1 = true;
        }
        else if(mouse != null && Greenfoot.mouseClicked(b) == true && choice1 == false)
        {
            p1c = "Barbarians";
            choice1 = true;
        }
        else if(mouse != null && Greenfoot.mouseClicked(us) == true && choice1 == false)
        {
            p1c = "USNavy";
            choice1 = true;
        }
        
        if(Greenfoot.isKeyDown("k"))
        {
            p2c = "Knights";
            choice2 = true;
        }
        else if(Greenfoot.isKeyDown("v"))
        {
            p2c = "Vikings";
            choice2 = true;
        }
        else if(Greenfoot.isKeyDown("m"))
        {
            p2c = "Mages";
            choice2 = true;
        }
        else if(Greenfoot.isKeyDown("b"))
        {
            p2c = "Barbarians";
            choice2 = true;
        }
        else if(Greenfoot.isKeyDown("u") && cheating == true)
        {
            p2c = "USNavy";
            choice2 = true;
        }
        
        if(choice1 == true && choice2 == true)
        {
            Greenfoot.setWorld(new Ocean(p1c, p2c, p3c, p4c, map));
        }
    }
}
