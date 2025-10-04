package TP2.EJ3;

public class estructuraDeControl {

    public static void main(String[] args){
        int suma=0;
        /*for (int i=0; i<10; i++){
            suma+=i;
            System.out.print(suma+ "\n");
        }*/

        int i=0;
        /*while (i<10){
            suma+=i;
            System.out.print(suma+ "\n");
            i++;
        }*/

        do {
            suma+=i;
            i++;
        } while (i<10);


    }

}
