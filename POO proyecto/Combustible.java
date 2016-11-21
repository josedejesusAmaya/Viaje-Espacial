import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Combustible here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Combustible extends Capsula
{
    private int velocidad;
    private GreenfootImage combustible = new GreenfootImage("barrel.png");
    
    public Combustible(int xVel)
    {
       setImage(combustible);
       velocidad = Greenfoot.getRandomNumber(5) + xVel;
       setVelocidad(velocidad);
    }
   
    /**
     * Act - do whatever the Combustible wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    // Add your action code here.
    {
        comportamiento();
    }      
}
