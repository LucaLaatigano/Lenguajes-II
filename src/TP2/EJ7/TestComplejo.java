package TP2.EJ7;

public class TestComplejo {

public static void main(String[] args) {
    NumeroComplejo c1 = new NumeroComplejo(3.0, 4.0);
    NumeroComplejo c2 = new NumeroComplejo(1.0, -2.0);

    System.out.println("Número complejo c1: " + c1);
    System.out.println("Número complejo c2: " + c2);
    System.out.println();

    NumeroComplejo suma = c1.sumar(c2);
    System.out.println("Suma (c1 + c2): " + suma);

    NumeroComplejo resta = c1.restar(c2);
    System.out.println("Resta (c1 - c2): " + resta);

    NumeroComplejo producto = c1.multiplicar(c2);
    System.out.println("Multiplicación (c1 * c2): " + producto);
    System.out.println();

    System.out.println("Módulo de c1: " + c1.getModulo());
    System.out.println("Coordenadas polares de c1:");
    c1.mostrarCoordenadasPolares();
    }
}

