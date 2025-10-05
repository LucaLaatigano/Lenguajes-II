package TP2.EJ9;

public class Inmueble {
    /**
     * Clase padre de todo tipo de inmueble
     *
     */

        // instance variables - replace the example below with your own
        double valorFiscal,superficie;
        String catastro;
        /**
         * Constructor for objects of class Inmueble
         */
        public Inmueble(double v, double s, String c)
        {
            valorFiscal=v;
            superficie=s;
            catastro=c;
        }
        public Inmueble(){

        }
    /**
     * Getter para valorFiscal
     *
     * @return Valor Fiscal del Inmueble
     */
    public double getValorFiscal()
    {
    // put your code here
        return valorFiscal;
    }
    /**
     * Getter para Superficie
     *
     * @return Superficie total del Inmueble
     */
    public double getSuperficie()
    {
        return superficie;
    }
}

