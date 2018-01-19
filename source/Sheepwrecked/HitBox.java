import greenfoot.*;

public class HitBox extends Actor
{
    public HitBox()
    {
        getImage().setTransparency(0);
    }
    
    @Override
    public boolean isTouching(java.lang.Class<?> cls)
    {
       return super.isTouching(cls);
    }
}
