package TP2.EJ7;

public class PolinomioGrado2Complejo extends polinomioGrado2 {

    public PolinomioGrado2Complejo(double a, double b, double c) {
        super(a, b, c);
    }

    public int cantidadRaicesRealesDistintas() {
        double discriminante = (this.b * this.b) - (4 * this.a * this.c);
        if (discriminante < 0) {
            return 0;
        } else if (discriminante == 0) {
            return 1;
        } else {
            return 2;
        }
    }

    public NumeroComplejo getUnaRaiz() {
        if (this.a == 0) {
            System.out.println("Ecuación lineal, no se puede calcular raíz con este método.");
            return null;
        }

        double discriminante = (this.b * this.b) - (4 * this.a * this.c);

        if (discriminante >= 0) {
            double parteReal = (-this.b + Math.sqrt(discriminante)) / (2 * this.a);
            return new NumeroComplejo(parteReal, 0);
        } else {
            double parteReal = -this.b / (2 * this.a);
            double parteImaginaria = Math.sqrt(-discriminante) / (2 * this.a);
            return new NumeroComplejo(parteReal, parteImaginaria);
        }
    }
}
