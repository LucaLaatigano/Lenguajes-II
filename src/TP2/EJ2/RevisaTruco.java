package TP2.EJ2;
import TP2.EJ1.NaipeEspañol;

import java.util.Random;

public class RevisaTruco {
    private static final String[] PALOS = {"oro", "bastos", "copas", "espadas"};
    private static final int[] NUMEROS = {1, 2, 3, 4, 5, 6, 7, 10, 11, 12};
    private static Random random = new Random();


    public static NaipeEspañol generarCarta(){
        String palo = PALOS[random.nextInt(PALOS.length)];
        int numero = NUMEROS[random.nextInt(NUMEROS.length)];
        return new NaipeEspañol(palo, numero);
    }
    public static int calcularMayor(int[] array){
        int maximo = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > maximo) {
                maximo = array[i];
            }
        }
        return maximo;
    }


    public static int calcularEnvido(NaipeEspañol c1, NaipeEspañol c2, NaipeEspañol c3){
        if(c1.igualPalo(c2)){
            if(c1.mostrarNumero() > 7 && c3.mostrarNumero() > 7){
                return 20;
            }
            else if(c1.mostrarNumero() <=7 && c2.mostrarNumero() > 7 ){
                return 20 + c1.mostrarNumero();
            }
            else if (c2.mostrarNumero() <=7 && c1.mostrarNumero() > 7) {
                return 20 + c2.mostrarNumero();
            }
        }
        else if (c1.igualPalo(c3)){
            if(c1.mostrarNumero() > 7 && c3.mostrarNumero() > 7){
                return 20;
            }
            else if(c1.mostrarNumero() <=7 && c3.mostrarNumero() > 7 ){
                return 20 + c1.mostrarNumero();
            }
            else if (c3.mostrarNumero() <=7 && c1.mostrarNumero() > 7) {
                return 20 + c3.mostrarNumero();
            }
        }
        else if(c2.igualPalo(c3)) {
            if(c2.mostrarNumero() > 7 && c3.mostrarNumero() > 7){
                return 20;
            }
            else if(c2.mostrarNumero() <=7 && c3.mostrarNumero() > 7 ){
                return 20 + c2.mostrarNumero();
            }
            else if (c3.mostrarNumero() <=7 && c2.mostrarNumero() > 7) {
                return 20 + c3.mostrarNumero();
            }
        }
        int[] array = {c1.mostrarNumero(), c2.mostrarNumero(), c3.mostrarNumero()};
        int mayor = calcularMayor(array);
        return mayor;
    }

    public static boolean calcularFlor(NaipeEspañol c1, NaipeEspañol c2, NaipeEspañol c3){
        if(c1.igualPalo(c2) && c1.igualPalo(c3)){
            return true;
        }
        return false;
    }

    public static NaipeEspañol calcularCartaMayor(NaipeEspañol c1, NaipeEspañol c2, NaipeEspañol c3){
        NaipeEspañol mayor = c1;

        if (compararCartasTruco(c2, mayor) > 0) {
            mayor = c2;
        }

        if (compararCartasTruco(c3, mayor) > 0) {
            mayor = c3;
        }

        return mayor;
    }
    private static int compararCartasTruco(NaipeEspañol c1, NaipeEspañol c2) {
        int valor1 = obtenerValorTruco(c1);
        int valor2 = obtenerValorTruco(c2);

        return Integer.compare(valor1, valor2);
    }
    private static int obtenerValorTruco(NaipeEspañol carta) {
        int numero = carta.mostrarNumero();
        String palo = carta.mostrarPalo();


        if (numero == 1 && palo.equals("espadas")) return 24;
        if (numero == 1 && palo.equals("bastos")) return 23;
        if (numero == 7 && palo.equals("espadas")) return 22;
        if (numero == 7 && palo.equals("oro")) return 21;
        if (numero == 3) return 20;
        if (numero == 2) return 19;
        if (numero == 1 && (palo.equals("copas") || palo.equals("oro"))) return 18;
        if (numero == 12) return 17;
        if (numero == 11) return 16;
        if (numero == 10) return 15;
        if (numero == 7 && (palo.equals("bastos") || palo.equals("copas"))) return 14;
        if (numero == 6) return 13;
        if (numero == 5) return 12;
        if (numero == 4) return 11;

        return 0;
    }
}
