import java.util.Scanner;

public class EjercicioEnClase {

	public static void main(String [] args) {
		int saldo, opcion;
		String tirada [] = new String [3];
		String figuras [] = {"CORAZON", "DIAMANTE", "TREBOL", "CAMPANA", "LIMON", "iop"};
		int multiplicadores [] = {50, 25, 10, 5, 2};
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduce el saldo de la Slot:");
		saldo = sc.nextInt();
		
		do {
			System.out.println("Que quiere hacer? 1.JUGAR 2.COBRAR");
			opcion = sc.nextInt();
			
			switch(opcion){
				case 1://JUGAR
					//Restar saldo
					saldo--;
					//Sacar Jugada
					for(int i=0 ; i<tirada.length ; i++) {
						int posicion = (int)(Math.random()*5);
						tirada[i] = figuras[posicion];
					}
					//Imprimir Jugada
					System.out.println("-------------------");
					System.out.println("[");
					for(int i=0 ; i<tirada.length ; i++) {
						System.out.println(" " + tirada[i]);
					}
					System.out.println("]");
					System.out.println("-------------------");

					//Comprobar Premio y Actualizar Saldo
					if(tirada[0].equals(tirada[1]) && tirada[1].equals(tirada[2])) {
						int multiplicador, posicion=-1;
						String contenido = tirada[0];
						for(int i=0 ; i<figuras.length ; i++) {
							if(figuras[i].equals(contenido)) {
								posicion = i;
							}
						}
						multiplicador = multiplicadores[posicion];
						
						saldo = saldo + multiplicador;

					}else if (!tirada[0].equals(tirada[1]) && !tirada[1].equals(tirada[2]) && !tirada[0].equals(tirada[2])){
						//No hago nada porque ya le he restado el saldo
					}else {
						saldo++; //Recupero el euro de la tirada
					}
					
					break;
				case 2://COBRAR
					System.out.println("Cobras " + saldo + "�");
					break;
				default://ERROR
					System.out.println("ERROR. Introduce un valor correcto");
					break;
			}
		}while(opcion!=2 && saldo>0);
		
		
		
		
		
	}//Fin main
	
	
	
	
	
	
	
	
	
	
}
