import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MapMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MapMenu extends World
{
    private int numberOfPlayers;
    private boolean cheating;
    private int map;
    private boolean choice;
    
    public MapMenu(int numberOfPlayers, boolean cheating)
    {    
        super(1000, 800, 1); 
        this.numberOfPlayers = numberOfPlayers;
        this.cheating = cheating;
        map = 0;
        choice = false;
    }
    
    public void act()
    {
        if(Greenfoot.isKeyDown("0"))
        {
            map = 0;
            choice = true;
        }
        
        if(Greenfoot.isKeyDown("1"))
        {
            map = 1;
            choice = true;
        }
        
        if(Greenfoot.isKeyDown("2"))
        {
            map = 2;
            choice = true;
        }
        
        if(Greenfoot.isKeyDown("3"))
        {
            map = 3;
            choice = true;
        }
        
        if(Greenfoot.isKeyDown("4"))
        {
            map = 4;
            choice = true;
        }
        
        if(choice == true)
        {
            Greenfoot.setWorld(new CharacterMenu(numberOfPlayers, map, cheating));
        }
    }
}
