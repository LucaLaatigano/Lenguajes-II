package TP2.EJ9;

public class InmuebleRural extends Inmueble{
    // instance variables - replace the example below with your own
    double superficieCultivada;
    /**
     * Constructor para objetos de clase InmuebleRural
     */
    public InmuebleRural(double v, double s, String c)
    {
        super(v,s,c);
        superficieCultivada=0;
    }
    /**
     * Método para establecer superficie cultivada
     *
     * @param sc superficie cultivada
     * @return void
     */
    public void setSuperficieCultivada(double sc)
    {
        superficieCultivada=sc;
    }
    /*
     * Método para obtener la superficie cultivada
     **/

    // @return superficie cultivada
    //*/
    public double getSuperficieCultivada()
    {
        return superficieCultivada;
    }
    /**
     * método para calcular impuesto a imnmueble rural

    // * @param double k factor sobre la superficie cultivada, double p
    porcentaje sobre el total
     * @return monto del impuesto
     */
    public double impuesto(double k, double p)
    {
        return (this.getSuperficie()+(k)*this.getSuperficieCultivada())*p/100;
    }
}












