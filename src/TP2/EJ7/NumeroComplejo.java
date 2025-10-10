package TP2.EJ7;

import java.lang.Math;

public class NumeroComplejo {
    private double parteReal;
    private double parteImaginaria;

    public NumeroComplejo(double real, double imaginaria) {
        this.parteReal = real;
        this.parteImaginaria = imaginaria;
    }

    public double getParteReal() {
        return parteReal;
    }

    public double getParteImaginaria() {
        return parteImaginaria;
    }

    public double getModulo() {
        return Math.sqrt(parteReal * parteReal + parteImaginaria * parteImaginaria);
    }

    public void mostrarCoordenadasPolares() {
        double modulo = getModulo();
        double argumento = Math.atan2(parteImaginaria, parteReal);
        System.out.println("Módulo: " + modulo);
        System.out.println("Argumento: " + argumento + " radianes");
    }

    public NumeroComplejo sumar(NumeroComplejo otro) {
        double nuevaReal = this.parteReal + otro.getParteReal();
        double nuevaImaginaria = this.parteImaginaria + otro.getParteImaginaria();
        return new NumeroComplejo(nuevaReal, nuevaImaginaria);
    }

    public NumeroComplejo restar(NumeroComplejo otro) {
        double nuevaReal = this.parteReal - otro.getParteReal();
        double nuevaImaginaria = this.parteImaginaria - otro.getParteImaginaria();
        return new NumeroComplejo(nuevaReal, nuevaImaginaria);
    }

    public NumeroComplejo multiplicar(NumeroComplejo otro) {
        double c = otro.getParteReal();
        double d = otro.getParteImaginaria();
        double nuevaReal = (this.parteReal * c) - (this.parteImaginaria * d);
        double nuevaImaginaria = (this.parteReal * d) + (this.parteImaginaria * c);
        return new NumeroComplejo(nuevaReal, nuevaImaginaria);
    }

    public String toString() {
        if (parteImaginaria >= 0) {
            return parteReal + " + " + parteImaginaria + "i";
        } else {
            return parteReal + " - " + (-parteImaginaria) + "i";
        }
    }
}

