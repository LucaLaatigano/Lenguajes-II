package TP2.EJ6;

public class TestPolinomio {
    public static void main(String[] args) {
        System.out.println("Polinomio 1: Raíces reales");
        polinomioGrado2 p1 = new polinomioGrado2(1, 5, 6);
        System.out.println("Polinomio: " + p1);
        p1.mostrarRaices();
        System.out.println("¿Son reales? " + p1.raicesSonReales());
        System.out.println("Valor en x=2: " + p1.evalua(2));
        System.out.println();

        System.out.println("Polinomio 2: Raíces complejas");
        polinomioGrado2 p2 = new polinomioGrado2(1, 2, 5);
        System.out.println("Polinomio: " + p2);
        p2.mostrarRaices();
        System.out.println("¿Son reales? " + p2.raicesSonReales());
        System.out.println();

        System.out.println("Polinomio 3: Una raíz real doble");
        polinomioGrado2 p3 = new polinomioGrado2(1, -6, 9);
        System.out.println("Polinomio: " + p3);
        p3.mostrarRaices();
        System.out.println();

        System.out.println("Polinomio 4: Normalización");
        polinomioGrado2 p4 = new polinomioGrado2(2, -12, 18);
        System.out.println("Polinomio original: " + p4);
        p4.normaliza();
        System.out.println("Polinomio normalizado: " + p4);
        p4.mostrarRaices();
    }
}

