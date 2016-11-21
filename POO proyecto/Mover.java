import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Mover here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Mover extends Actor
{
    private Vector movimiento = new Vector();
    private double x;
    private double y;
    public Mover()
    {
   
    }
    
    /**
     * Crea un nuevo mover inicializado con Vector velocidad
     */
    public Mover(Vector velocidad)
    {
        movimiento = velocidad;
    }
    
    public void mover()
    {
        x = x + movimiento.getX();
        y = y + movimiento.getY();
        
        if(x >= getWorld().getWidth()) 
            //x = 0;
            x = getWorld().getWidth()-10;
        if(x < 0) 
            //x = getWorld().getWidth() - 1;
            x = 10;
        if(y >= getWorld().getHeight()) 
            //y = 0;
            y = getWorld().getHeight()-10;
        if(y < 0) 
            //y = getWorld().getHeight() - 1;
            y = 10;
        setLocacion(x,y);
    }
    
    public void mover(double xi, double yi)
    {
        x = xi;
        y = yi;
        setLocacion(x,y);
    }
    
    public void setLocacion(double x, double y)
    {
        this.x = x;
        this.y = y;
        super.setLocation((int)x,(int)y);
    }
    
    public void setLocacion(int x, int y)
    {
        setLocacion((double)x,(double)y);
    }
    
    public double getLocacionX()
    {
        return x;
    }
    
    public double getLocacionY()
    {
        return y;
    }
    
    /**
     * incrementa la velocidad con el vector dado
     */
    public void incrementaVelocidad(Vector s)
    {
        movimiento.agrega(s);
    }
    
    /**
     * Retorna el movimiento 
     */
    public Vector getMovimiento()
    {
        return movimiento;
    }
    public void getx(int xn)
    {
        x = (double)xn;
    }
    
    public void gety(int yn)
    {
        y = (double)yn;
    }
}
