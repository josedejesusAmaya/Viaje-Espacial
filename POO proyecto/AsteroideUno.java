import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Asteroide here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AsteroideUno extends Asteroide
{
    // instance variables - replace the example below with your ow
    private GreenfootImage asteroide = new GreenfootImage("apple1.png");
    private int velocidad;   
    /**
     * Constructor for objects of class Asteroide
     */
    public AsteroideUno(int factorVelocidad, int scale)
    {
        asteroide.scale(scale,scale);
        setImage(asteroide);
        velocidad = Greenfoot.getRandomNumber(3) + factorVelocidad;
        setVelocidad(velocidad);
    }
    
    public void act() 
    {
        detectaBala(1);
    } 

}
