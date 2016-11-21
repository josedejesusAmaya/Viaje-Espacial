import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CopyOfCombustible here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Municion extends Capsula
{
    private int velocidad;
    private GreenfootImage municion = new GreenfootImage("lemon.png");
    public Municion(int xVel)
    {
       velocidad = Greenfoot.getRandomNumber(5) + xVel;
       municion.scale(25,25);
       setImage(municion);
       setVelocidad(velocidad);
    }
    /**
     * Act - do whatever the CopyOfCombustible wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    // Add your action code here.
    {
        comportamiento();
    }
}
