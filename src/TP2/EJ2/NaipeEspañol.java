package TP2.EJ2;

public class NaipeEspañol {
    /**
     * NaipeEspañol representa a una carta de la baraja española.
     */
        private String nombre;
        private final String palo;
        private int numero;

        /**
         * Constructor de objetos de clase NaipeEspañol
         */
        public NaipeEspañol(String p,int n){
            numero=n;
            palo=p;
        }
        //----------------------------------------------------------------------
        /**
         * Método para devolver el valor de la carta
         *
         * @return valor de la carta
         */
        public int mostrarNumero(){
            return numero;
        }
        //----------------------------------------------------------------------
        /**
         * Método para devolver el palo de la carta
         *
         * @return palo de la carta
         */
        public String mostrarPalo()
        {
            return palo;
        }
        //----------------------------------------------------------------------
        /**
         * Método para devolver el nombre de la carta
         *
         * @return nombre de la carta
         */
        public String mostrarNombre()
        {
            return nombre;
        }
        //----------------------------------------------------------------------
        /**
         * Método para indicar si el naipe n es del mismo palo
         *
         * @return true si son del mismo palo
         */
        public boolean igualPalo(NaipeEspañol n){
            boolean iguales=true;
            if (n.mostrarPalo() != palo) {
                iguales=false;
            }
            return iguales;
        }
        //----------------------------------------------------------------------
        /**
         * Método para indicar si el naipe n es del mismo numero
         *
         * @return true si son del mismo numero
         */
        public boolean igualNumero(NaipeEspañol n){
            boolean iguales=true;
            if (n.mostrarNumero() != numero) {
                iguales=false;
            }
            return iguales;
        }
        //----------------------------------------------------------------------
        /**
         * Método para indicar si dada otra carta, devolver la de mayor valor
         *
         * @return la de mayor valor
         */
        public String mayorValor(NaipeEspañol n){
            String mayor= nombre;
            if (n.mostrarNumero() > numero) {
                mayor=n.mostrarNombre();
            }
            if (n.mostrarNumero() == numero) {
                mayor="Son iguales";
            }
            return mayor;
        }
        //----------------------------------------------------------------------------
        /**
         * Método para setear nombre de la carta.
         *
         * @return set nombre de carta
         */
        public void setNombre(){
            if (numero == 1) {
                this.nombre = "As de " + this.palo;
            }
            if (numero == 2) {
                this.nombre = "Dos de " + this.palo;
            }
            if (numero == 3) {
                this.nombre = "Tres de " + this.palo;
            }
            if (numero == 4) {
                this.nombre = "Cuatro de " + this.palo;
            }
            if (numero == 5) {
                this.nombre = "Cinco de " + this.palo;
            }
            if (numero == 6) {
                this.nombre = "Seis de " + this.palo;
            }
            if (numero == 7) {
                this.nombre = "Siete de " + this.palo;
            }
            if (numero == 10) {
                this.nombre = "Sota de " + this.palo;
            }
            if (numero == 11) {
                this.nombre = "Caballo de " + this.palo;
            }
            if (numero == 12) {
                this.nombre = "Rey de " + this.palo;
            }
        }
}

