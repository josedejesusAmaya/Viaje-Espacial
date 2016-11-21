import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Capsula here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Capsula extends Actor
{
    public int velocidad;    
    /**
     * Act - do whatever the Capsula wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }  
    public void comportamiento()
    {
        setLocation(getX()-velocidad,getY());
        turn (1);
        if(getX() == 0)
        {
            Space space = (Space)getWorld();
            space.removeObject(this);
        }
    }
    
    public void setVelocidad(int vel)
    {
        velocidad = vel;
    }
}
