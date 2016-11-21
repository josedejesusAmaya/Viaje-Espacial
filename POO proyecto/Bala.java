import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bala here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bala extends Mover
{
    private int vida = 20;
    private int poder = 16;
    private GreenfootImage bala = new GreenfootImage("steel-ball.png");
    public Bala()
    {
        
    }
    public Bala(int x, int y)
    {
        bala.scale(25,25);
        setImage(bala);
    }
    
    public Bala(Vector velocidad, int rotacion)
    {
        super(velocidad);
        bala.scale(25,25);
        setImage(bala);
        setRotation(rotacion);
        incrementaVelocidad(new Vector(rotacion,15));
    }
  
    public void act()
    {
        if(vida <= 0)
        {
            getWorld().removeObject(this);
        }
        else
        {
            mover();
            vida--;
        }
    }
}
