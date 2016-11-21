import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Asteroide here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Asteroide extends Actor
{
    private int velocidad;
    /**
     * Act - do whatever the Asteroide wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    } 
    public void detectaBala(int selec)
    {
        setLocation(getX()- velocidad,getY());
        turn (-1);
        Space s = (Space) getWorld();
        int x;
        int y;
        if(selec == 1)
        {
            if(isTouching(Bala.class))
                s.sumaScore(1);
            if (getX() == 0 || isTouching(Bala.class)) 
            {
                x = getX();
                y = getY();
                s.fragmentos(x,y);
                getWorld().removeObject(this); //aqui se detecta el impacto de la bala y el asteroide
            }
        }
        if(selec == 2)
        {
            if (getX() == 0) 
            {
                getWorld().removeObject(this);
            }   
        }
    }
    
     public void setVelocidad(int vel)
    {
        velocidad = vel;
    }
}
