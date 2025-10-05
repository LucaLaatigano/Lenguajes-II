package TP2.EJ9;

public class InmuebleUrbano extends Inmueble
{
    double superficieConstruida;
    double frente,fondo;
    /**
     * Constructor para objetos de clase InmuebleUrbano
     *
     */
    public InmuebleUrbano(double v,String cat, double f, double fo)
    {

    // ESCRIBA EL CONSTRUCTOR
        super(v,f*fo,cat);
    }
    public double getSuperficieConstruida()
    {
        return superficieConstruida;
    }
    public double getFrente()
    {
        return frente;
    }

    public double getFondo(){
        return fondo;
    }
}

