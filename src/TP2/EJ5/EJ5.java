package TP2.EJ5;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EJ5 {

    public void analizar(int numero) {
        List<Integer> multiplosEncontrados = new ArrayList<>();

        if (numero % 2 == 0) {
            multiplosEncontrados.add(2);
        }
        if (numero % 3 == 0) {
            multiplosEncontrados.add(3);
        }
        if (numero % 7 == 0) {
            multiplosEncontrados.add(7);
        }
        if (numero % 9 == 0) {
            multiplosEncontrados.add(9);
        }

        int cantidad = multiplosEncontrados.size();
        System.out.println("Resultado para el número " + numero + " ");

        switch (cantidad) {
            case 0:
                System.out.println("El número no es múltiplo de ninguno (2, 3, 7, 9).");
                break;
            case 1:
                System.out.println("Es múltiplo de un solo valor: " + multiplosEncontrados.get(0));
                break;
            case 4:
                System.out.println("Es múltiplo de todos los valores: 2, 3, 7 y 9.");
                break;
            default: 
                System.out.print("Es múltiplo de varios valores, pero no de todos. Es múltiplo de: ");
                System.out.println(multiplosEncontrados);
                break;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        EJ5 verificador = new EJ5();

        System.out.print("Por favor, ingrese un número entero: ");
        int numeroIngresado = scanner.nextInt();

        verificador.analizar(numeroIngresado);

        scanner.close();

        System.out.println("Ejecutando algunas pruebas automáticas:");
        verificador.analizar(14); 
        verificador.analizar(10);  
        verificador.analizar(11);  
        verificador.analizar(126);  
    }
}