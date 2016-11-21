import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * La nave se puede mover con "up","left","right"
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nave extends Mover
{
    private GreenfootImage imagen;
    private Vector aceleracion;
    private int armaTiempo;
    private int recargaContador;
    private int numeroDisparos;
    private GreenfootImage nave1 = new GreenfootImage("hamburger.png");
    private int n = 0;
    private int limiteBalas = 15;
    private int numeroMov;
    private int limiteMov = 100;
    public Nave()
    {
        //imagen = new GreenfootImage("hamburguer.png");
        setLocacion(50,200);   
        setImage(nave1);
        armaTiempo = 5;
        recargaContador = 0;
        aceleracion = new Vector(0,0.1);
        incrementaVelocidad(new Vector(2,0.1));
        numeroDisparos = 0;
        numeroMov = 0;
    }
    
    /**
     * Act - do whatever the Nave wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        mover();
        comandos();
        recargaContador++;
        detectarObjeto();
        remueveItem();
    }
    
    private void remueveItem()
    {
        Space s = (Space) getWorld();
        if(numeroDisparos == limiteBalas)
            s.quitaMunicion();
        if(numeroMov == limiteMov)
            s.quitaCombustible();
        if(numeroDisparos == limiteBalas/2)
            s.quitaBlindaje();
    }
    
    public int getNumeroDisparos()
    {
        return numeroDisparos;
    }
 
    public void setArmaTiempo(int tiempo)
    {
        armaTiempo = tiempo;
    }
   
    private void comandos()
    {
        Space s = (Space) getWorld();
        
        if(numeroMov < limiteMov || s.getb1() == true)
            ignicion(Greenfoot.isKeyDown("up"));
        if(Greenfoot.isKeyDown("left"))
            turn(-5);
        if (Greenfoot.isKeyDown("right"))
            turn(5);
        if(Greenfoot.isKeyDown("space"))
            fuego();
    }
   
    private void ignicion(boolean yolo)
    {
        if(yolo)
        {
            aceleracion.setDireccion(getRotation());
            incrementaVelocidad(aceleracion);
            numeroMov++;
        }
    }
    
    private void fuego()
    {
        if(recargaContador >= armaTiempo && numeroDisparos < limiteBalas)
        {
            Bala b = new Bala(getMovimiento().copia(),getRotation());
            int x = getX();
            int y = getY();
            getWorld().addObject(b,x,y);
            b.mover((double)x,(double)y);
            numeroDisparos++;
            recargaContador = 0;
        }
    }

    private void detectarObjeto()
    {       
        if(isTouching(Combustible.class) && numeroMov >= limiteMov)
        {
            removeTouching(Combustible.class); 
            Space s = (Space) getWorld();
            s.llamaCombustible();
            s.sumaScore(1);
            numeroMov = 0;
        }
        if(isTouching(Municion.class) && numeroDisparos >= limiteBalas)
        {
            removeTouching(Municion.class);
            Space s = (Space) getWorld();
            s.llamaMunicion(); 
            s.sumaScore(2);
            numeroDisparos = 0;
        }
        if(isTouching(Vida.class))
        {
            removeTouching(Vida.class);
            Space s = (Space) getWorld();
            n = n + 1;
            if(n <= 3)
                s.llamaVida(n);
            else
            {
            }
        }
        if(isTouching(Blindaje.class) && numeroDisparos >= limiteBalas/2)
        {
            removeTouching(Blindaje.class);
            Space s = (Space) getWorld();
            s.llamaBlindaje();
            s.sumaScore(5);
        }
        if(isTouching(AsteroideUno.class) || isTouching(AsteroideDos.class))
        {
            if(n == 0)
                Greenfoot.stop();
            else
            {
            Space s = (Space) getWorld();
            s.quitaVida(n-1);
            //n = n-1;
            //Greenfoot.stop();
            }
        }
    }
    
    private void choque()
    {
        if(isTouching(AsteroideUno.class))
        {
            Space s = (Space) getWorld();
            s.quitaVida(0);
        }
    }
}
