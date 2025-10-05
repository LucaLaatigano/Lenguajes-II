package TP2.EJ9;

public class Impuestos {
    public static void main(String args[]) {
        InmuebleRural ir1 = new InmuebleRural(220.3, 13000, "100-1");
        ir1.setSuperficieCultivada(6300);
        double impuesto1 = ir1.impuesto(3, 3);
        ;
        System.out.println("Impuesto Inmobiliario Anual: " + impuesto1 + "pesos");
        /** El impuesto en la propiedad rural se calcula como
         * el 3% de (Superficie Total + 3 Sup Cultivada) $
         */


/** El impuesto en una propiedad urbana se calcula
 * $1000(frente/fondo)*valorFiscal
 */


    }
}
