import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Capsula here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vida extends Capsula
{
    private int velocidad;
    private GreenfootImage vida = new GreenfootImage("mushroom.png");
   
    public Vida(int xVel)
    {
        setImage(vida);
        vida.scale(25,25);
        velocidad = Greenfoot.getRandomNumber(5) + xVel;
        setVelocidad(velocidad);
    }
    /**
     * Act - do whatever the Capsula wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        comportamiento();
    }    
}
