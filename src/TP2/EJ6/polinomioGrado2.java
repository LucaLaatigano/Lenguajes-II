package TP2.EJ6;

import java.lang.Math;

public class polinomioGrado2 {
    private double a;
    private double b;
    private double c;

    public polinomioGrado2(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double evalua(double x) {
        return this.a * x * x + this.b * x + this.c;
    }

    public void normaliza() {
        if (this.a != 0) {
            this.b = this.b / this.a;
            this.c = this.c / this.a;
            this.a = 1.0; // o this.a / this.a
        } else {
            System.out.println("Error: No se puede normalizar si el coeficiente 'a' es 0.");
        }
    }

    private double getDiscriminante() {
        return (this.b * this.b) - (4 * this.a * this.c);
    }

    public boolean raicesSonReales() {
        return getDiscriminante() >= 0;
    }

    public double raizRealMayor() {
        if (this.a == 0 || !raicesSonReales()) {
            return Double.NaN; // Not a Number, indica un resultado indefinido.
        }
        double discriminante = getDiscriminante();
        return (-this.b + Math.sqrt(discriminante)) / (2 * this.a);
    }


    public double raizRealMenor() {
        if (this.a == 0 || !raicesSonReales()) {
            return Double.NaN; // Not a Number, indica un resultado indefinido.
        }
        double discriminante = getDiscriminante();
        return (-this.b - Math.sqrt(discriminante)) / (2 * this.a);
    }

    public void mostrarRaices() {
        if (this.a == 0) {
            System.out.println("Es una ecuación lineal, no cuadrática. No se pueden calcular raíces con este método.");
            return;
        }

        double discriminante = getDiscriminante();

        if (raicesSonReales()) {
            System.out.println("Las raíces son reales:");
            System.out.println("Raíz 1: " + raizRealMayor());
            System.out.println("Raíz 2: " + raizRealMenor());
        } else {
            // Raíces complejas: (-b ± i*sqrt(-discriminante)) / 2a
            double parteReal = -this.b / (2 * this.a);
            double parteImaginaria = Math.sqrt(-discriminante) / (2 * this.a);
            System.out.println("Las raíces son complejas y conjugadas:");
            System.out.println("Raíz 1: " + parteReal + " + " + parteImaginaria + "i");
            System.out.println("Raíz 2: " + parteReal + " - " + parteImaginaria + "i");
        }
    }

    public String toString() {
        return a + "x^2 + " + b + "x + " + c;
    }
}

