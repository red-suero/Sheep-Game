import greenfoot.*;

public class Ocean extends World
{
    private HeadQuarters hq1;
    private HeadQuarters hq2;
    private HeadQuarters hq3;
    private HeadQuarters hq4;
    private Knights k;
    private Barbarians b;
    private Vikings v;
    private Mages m;
    private USNavy u;
    private long gameTimer;
    private boolean done;
    private String p1c;
    private String p2c;
    private String p3c;
    private String p4c;
    private int map;
    
    public Ocean(String p1c, String p2c, String p3c, String p4c, int map)
    {    
        super(1000, 800, 1); 
        
        this.p1c = p1c;
        this.p2c = p2c;
        this.p3c = p3c;
        this.p4c = p4c;
        this.map = map;
        
        addIslands();
        
        hq1 = new HeadQuarters(1);
        addObject(hq1, 45, 50);
        
        hq2 = new HeadQuarters(2);
        addObject(hq2, 955, 50);
        
        hq3 = new HeadQuarters(2);
        addObject(hq3, 45, 750);
        
        hq4 = new HeadQuarters(4);
        addObject(hq4, 955, 750);
        
        chooseClasses();
        
        done = false;
    }
    
    public void chooseClasses()
    {
        if(p1c == "Knights")
        {
            k = new Knights(1);
            addObject(k, 45, 125);
        }
        else if(p1c == "Vikings")
        {
            v = new Vikings(1);
            addObject(v, 45, 125);
        }
        else if(p1c == "Mages")
        {
            m = new Mages(1);
            addObject(m, 45, 125);
        }
        else if(p1c == "Barbarians")
        {
            b = new Barbarians(1);
            addObject(v, 45, 125);
        }
        else if(p1c == "USNavy")
        {
            u = new USNavy(1);
            addObject(u, 45, 125);
        }
        
        if(p2c == "Knights")
        {
            k = new Knights(2);
            addObject(k, 955, 675);
        }
        else if(p2c == "Vikings")
        {
            v = new Vikings(2);
            addObject(v, 955, 675);
        }
        else if(p2c == "Mages")
        {
            m = new Mages(2);
            addObject(m, 955, 675);
        }
        else if(p2c == "Barbarians")
        {
            b = new Barbarians(2);
            addObject(b, 955, 675);
        }
        else if(p2c == "USNavy")
        {
            u = new USNavy(2);
            addObject(u, 955, 675);
        }
    }
    
    public void act()
    {
        if(done == false)
        {
            gameTimer = System.currentTimeMillis() + 180000;
            done = true;
        }
        
        if(System.currentTimeMillis() > gameTimer)
        {
            Greenfoot.setWorld(new ResultsMenu());
        }
    }
    
    public void addIslands()
    {
        if(map == 0)
        {
            int r = Randomizer.getRandomFromRange(1,5);
            if(r == 2)
            {
                map1();
            }
            else if(r == 3)
            {
                map2();
            }
            else if(r == 4)
            {
                map3();
            }
            else if(r == 5)
            {
                map4();
            }
        }
        else if(map == 1)
        {
            map1();
        }
        else if(map == 2)
        {
            map2();
        }
        else if(map == 3)
        {
            map3();
        }
        else if(map == 4)
        {
            map4();
        }
    }
    
    public void map1()
    {
        Island i = new Island(Randomizer.getRandomFromRange(1,3));
        addObject(i, 500, 400);
        Island i2 = new Island(Randomizer.getRandomFromRange(1,3));
        addObject(i2, 200, 400);
        Island i3 = new Island(Randomizer.getRandomFromRange(1,3));
        addObject(i3, 800, 400);
        Island i4 = new Island(Randomizer.getRandomFromRange(1,3));
        addObject(i4, 500, 640);
        Island i5 = new Island(Randomizer.getRandomFromRange(1,3));
        addObject(i5, 500, 160);
    }
    
    public void map2()
    {
        Island i = new Island(Randomizer.getRandomFromRange(1,3));
        addObject(i, 500, 400);
        Island i2 = new Island(Randomizer.getRandomFromRange(1,3));
        addObject(i2, 325, 255);
        Island i3 = new Island(Randomizer.getRandomFromRange(1,3));
        addObject(i3, 675, 255);
        Island i4 = new Island(Randomizer.getRandomFromRange(1,3));
        addObject(i4, 325, 545);
        Island i5 = new Island(Randomizer.getRandomFromRange(1,3));
        addObject(i5, 675, 545);
    }
    
    public void map3()
    {
        Island i = new Island(Randomizer.getRandomFromRange(1,3));
        addObject(i, 500, 50);
        Island i2 = new Island(Randomizer.getRandomFromRange(1,3));
        addObject(i2, 500, 225);
        Island i3 = new Island(Randomizer.getRandomFromRange(1,3));
        addObject(i3, 500, 400);
        Island i4 = new Island(Randomizer.getRandomFromRange(1,3));
        addObject(i4, 500, 575);
        Island i5 = new Island(Randomizer.getRandomFromRange(1,3));
        addObject(i5, 500, 750);
    }
    
    public void map4()
    {
        Island i = new Island(Randomizer.getRandomFromRange(1,3));
        addObject(i, 50, 400);
        Island i2 = new Island(Randomizer.getRandomFromRange(1,3));
        addObject(i2, 275, 400);
        Island i3 = new Island(Randomizer.getRandomFromRange(1,3));
        addObject(i3, 500, 400);
        Island i4 = new Island(Randomizer.getRandomFromRange(1,3));
        addObject(i4, 725, 400);
        Island i5 = new Island(Randomizer.getRandomFromRange(1,3));
        addObject(i5, 950, 400);
    }
}
