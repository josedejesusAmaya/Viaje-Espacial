/**
 * Vector en 2D
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vector  
{
    // instance variables - replace the example below with your own
    double dx = 0;
    double dy = 0;
    int direccion = 0;
    double longitud;

    /**
     * Crea un vector inicializado en cero.
     */
    public Vector()
    {
    }

    /**
     * Crea un vector con la longitud y direccion dada 
     */
    public Vector(int direccion, double longitud)
    {
        this.direccion = direccion;
        this.longitud = longitud;
        dx = longitud * Math.cos(Math.toRadians(direccion));
        dy = longitud * Math.sin(Math.toRadians(direccion));
    }
    
    /**
     * Establece la direccion del vector
     */
    public void setDireccion(int direccion)
    {
        this.direccion = direccion;
        dx = longitud * Math.cos(Math.toRadians(direccion));
        dy = longitud * Math.sin(Math.toRadians(direccion));
    }
    
    /**
     * Agrega el vector dado
     */
    public void agrega(Vector otro)
    {
        dx += otro.dx;
        dy += otro.dy;
        this.direccion = (int) Math.toDegrees(Math.atan2(dy,dx));
        this.longitud = Math.sqrt(dx*dx + dy*dy);
    }
    
    /**
     * Devuelve la x del vector 
     */
    public double getX()
    {
        return dx;
    }
    
    /**
     * Devuelve la y del vector 
     */
    public double getY()
    {
        return dy;
    }
    
    /**
     * Devuelve la direccion (en grados)
     */
    public int getDireccion()
    {
        return direccion;
    }
    
    /**
     * Devuelve la longitud del vector
     */
    public double getLongitud()
    {
        return longitud;
    }
    
    /**
     * Crea una copia del vector
     */
    public Vector copia()
    {
        Vector copia = new Vector();
        copia.dx = dx;
        copia.dy = dy;
        copia.direccion = direccion;
        copia.longitud = longitud;
        return copia;
    }
}