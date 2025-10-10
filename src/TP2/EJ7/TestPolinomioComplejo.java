package TP2.EJ7;

public class TestPolinomioComplejo {
    public static void main(String[] args) {
        PolinomioGrado2Complejo pComplejo = new PolinomioGrado2Complejo(1, 2, 5);
        System.out.println("Polinomio: " + pComplejo);
        System.out.println("Cantidad de raíces reales distintas: " + pComplejo.cantidadRaicesRealesDistintas());

        NumeroComplejo raiz1 = pComplejo.getUnaRaiz();
        System.out.println("Una de sus raíces complejas es: " + raiz1);
        System.out.println();

        PolinomioGrado2Complejo pReal = new PolinomioGrado2Complejo(1, 5, 6);
        System.out.println("Polinomio: " + pReal);
        System.out.println("Cantidad de raíces reales distintas: " + pReal.cantidadRaicesRealesDistintas());

        NumeroComplejo raizReal = pReal.getUnaRaiz();
        System.out.println("Una de sus raíces reales es: " + raizReal);
    }
}
