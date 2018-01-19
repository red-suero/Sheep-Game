import greenfoot.*;

public class StartMenu extends World
{
    private TwoPlayers p2;
    private ThreePlayers p3;
    private FourPlayers p4;
    private boolean cheating1;
    private boolean cheating2;
    private boolean cheating3;
    private boolean cheating4;
    private boolean cheating5;
    
    public StartMenu()
    {    
        super(1000, 800, 1);  
        p2 = new TwoPlayers();
        addObject(p2, 500, 300);
        
        p3 = new ThreePlayers();
        addObject(p3, 500, 400);
        
        p4 = new FourPlayers();
        addObject(p4, 500, 500);
        
        cheating1 = false;
        cheating2 = false;
        cheating3 = false;
        cheating4 = false;
        cheating5 = false;
    }
    
    public void act()
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if(mouse != null && Greenfoot.mouseClicked(p2) == true)
        {
            Greenfoot.setWorld(new MapMenu(2, cheating5));
        }
        
        if(mouse != null && Greenfoot.mouseClicked(p3) == true)
        {
            Greenfoot.setWorld(new MapMenu(3, cheating5));
        }
        
        if(mouse != null && Greenfoot.mouseClicked(p4) == true)
        {
            Greenfoot.setWorld(new MapMenu(4, cheating5));
        }
        
        cheatCode();
    }
    
    public void cheatCode()
    {
        if(Greenfoot.isKeyDown("c"))
        {
            cheating1 =true;
        }
        
        if(Greenfoot.isKeyDown("h") && cheating1 == true)
        {
            cheating2 = true;
        }
        
        if(Greenfoot.isKeyDown("e") && cheating2 == true)
        {
            cheating3 = true;
        }
        
        if(Greenfoot.isKeyDown("a") && cheating3 == true)
        {
            cheating4 = true;
        }
        
        if(Greenfoot.isKeyDown("t") && cheating4 == true)
        {
            cheating5 = true;
        }
    }
}
