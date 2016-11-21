import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Space extends World
{
    private int puntos;
    private GreenfootImage space1 = new GreenfootImage("space1.jpg");
    private Vid v[] = {null,null,null};
    private Mun mun;
    private Blind b;
    private Combus c;
    private boolean b1;
    private boolean b2;
    private boolean b3;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public Space()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1100, 360, 1);
        b1 = false;
        b2 = false;
        b3 = false;
        mun = new Mun();
        b = new Blind();
        c = new Combus();
        setBackground(space1);
        puntos = 0;
        Nave n = new Nave();
        addObject(n,50,200);
        muestraScore();
    }
  
    public void act()
    {
        //if(puntos <= 20)
        //{
        //    b1 = true;
        //    primerNivel();
        //}
        //if(puntos > 20)
        //{
            b1 = false;
            b2 = true;
            segundoNivel();
        //}
        if(puntos > 50)
        {
            b2 = false;
            b3 = true;
            tercerNivel();
        }
    }
    
    public boolean getb1()
    {
        return b1;
    }
    
    private void primerNivel()
    {
        showText("Nivel uno", 550,10);
        if(Greenfoot.getRandomNumber(250) < 2)
            addObject(new AsteroideUno(1,30), 1099, Greenfoot.getRandomNumber(360));
        if(Greenfoot.getRandomNumber(800) < 1)
            addObject(new AsteroideDos(30), 1099, Greenfoot.getRandomNumber(360));
        if(Greenfoot.getRandomNumber(1300) < 2)
            addObject(new Municion(1), 1099, Greenfoot.getRandomNumber(360));
    }
    
    private void segundoNivel()
    {
        showText("Nivel dos", 550,10);
        if(Greenfoot.getRandomNumber(1000) < 2)
           addObject(new Municion(5), 1099, Greenfoot.getRandomNumber(360));
        if(Greenfoot.getRandomNumber(1000) < 10)
           addObject(new Combustible(5), 1099, Greenfoot.getRandomNumber(360));
        if(Greenfoot.getRandomNumber(1000) < 2)
           addObject(new Blindaje(5), 1099, Greenfoot.getRandomNumber(360));
        if(Greenfoot.getRandomNumber(1000) < 3)
           addObject(new Vida(5), 1099, Greenfoot.getRandomNumber(360));   
        if(Greenfoot.getRandomNumber(250) < 3)
            addObject(new AsteroideUno(2,Greenfoot.getRandomNumber(60)+20), 1099, Greenfoot.getRandomNumber(360));
    }
    
    public void fragmentos(int x, int y)
    {
        if(b2)
        {
            //addObject(new AsteroideUno(3,10),x,y);
            //addObject(new AsteroideUno(3,10),x,y);
            addObject(new AsteroideDos(10),x,y);
            addObject(new AsteroideDos(10),x,y);
        }
    }
    
    private void tercerNivel()
    {
        showText("Nivel tres", 550,10);
    }
    
    private void muestraScore()
    {
        showText("Puntos: " + puntos, 60,30);
    }
    
    public void sumaScore(int p)
    {
        puntos = puntos + p;
        muestraScore();   
    }
    
    public void llamaMunicion()
    {
        addObject(mun,60,330);
    }
    
    public void quitaMunicion()
    {
        removeObject(mun);
    }
    
    public void llamaBlindaje()
    {
        addObject(b,100,330);
    }
    
    public void quitaBlindaje()
    {
        removeObject(b);
    }
    
    public void llamaCombustible()
    {
        addObject(c,20,330);
    }
    
    public void quitaCombustible()
    {
        removeObject(c);
    }
    
    public void quitaVida(int vida)
    {
        removeObject(v[vida]);
    }
    
    public void llamaVida(int vidas)
    {
        int x = 20;
        for(int i = 0; i<vidas;i++)
        {
            v[i] = new Vid();
            addObject(v[i],x*(i+1),10);
        }
    }
}