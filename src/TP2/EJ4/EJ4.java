package TP2.EJ4;

public class EJ4 {

	public static void main(String[] args) {

		NaipeEspañol carta=null;
		int intentos=0;
		
		System.out.println("Generando cartas hasta que encuentre el As de Espadas");
		while(true) {
			carta=RevisaTruco.generarCarta();
			carta.setNombre();
			intentos++;
			System.out.println("intento numero: "+ intentos + ": se generó la carta "+ carta.mostrarNombre());
			if(carta.mostrarNumero()==1 && carta.mostrarPalo().equals("espadas")) {
				System.out.println();
				System.out.println("Se ha encontrado el As de Espadas");
				break;
			}
		}
		System.out.println("se encontro el as de espadas despues de "+ intentos);
		
		
	}

}
