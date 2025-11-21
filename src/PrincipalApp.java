import java.util.*;

public class PrincipalApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String [] combinacion = new String [3];
		String [] premios = new String [5];
		
		int saldo, premio, tirada, opcion;
		
		inicializarPremios(premios);
		
		System.out.print("Introduce el saldo:__ ");
		saldo = sc.nextInt();
		
		do{
			System.out.print("Que quieres hacer? (1.JUGAR o 2.COBRAR):__ ");
			opcion = sc.nextInt();
			
			switch(opcion) {
				case 1:
					do{
						System.out.print("Cuanto te quieres jugar?:__ ");
						tirada = sc.nextInt();
						if(tirada>saldo) {
							System.out.println("Su saldo es menor a ese valor");
						}
					}while(tirada>saldo);
					
					saldo = saldo-tirada;
					
					for(int i=0 ; i<combinacion.length ; i++) {
						int figura = (int)(1+Math.random()*combinacion.length);
						combinacion[i]=premios[figura];
					}
					
					System.out.println("	+++++++++++++++++++++++++++++++++");
					System.out.println("	  " + combinacion[0] + "   " + combinacion[1] + "   " + combinacion[2]);
					System.out.println("	+++++++++++++++++++++++++++++++++");
					
					if(combinacion[0].equals(combinacion[1]) && combinacion[1].equals(combinacion[2]) && combinacion[0].equals(combinacion[2])) { //PREMIO
						switch(combinacion[0]) {
							case "CORAZON":
								premio = 50*tirada;
								saldo = saldo + premio;
								System.out.println("Premio + " + premio + "€!");
								break;
							case "DIAMANTE":
								premio = 25*tirada;
								saldo = saldo + premio;
								System.out.println("Premio + " + premio + "€!");
								break;
							case "TREBOL":
								premio = 10*tirada;
								saldo = saldo + premio;
								System.out.println("Premio + " + premio + "€!");
								break;
							case "CAMPANA":
								premio = 5*tirada;
								saldo = saldo + premio;
								System.out.println("Premio + " + premio + "€!");
								break;
							case "LIMON":
								premio = 2*tirada;
								saldo = saldo + premio;
								System.out.println("Premio + " + premio + "€!");
								break;
						}
					}else if(!combinacion[0].equals(combinacion[1]) && !combinacion[1].equals(combinacion[2]) && !combinacion[0].equals(combinacion[2])) { //PIERDE
						System.out.println("Pierdes " + tirada + "€ de tirada!");
					}else {
						saldo = saldo + tirada; //Recupera el saldo
						System.out.println("Recuperas el saldo!");
					}
					
					System.out.println("-----------------------------------");
					System.out.println("El saldo actual es: " + saldo + "€");
					System.out.println("-----------------------------------");

					break;
				case 2:
					System.out.println("Felicidades has retirado " + saldo + "€");
					break;
				default:
					System.out.println("Introduce una opcion valida");
					break;
			}
			
		}while(saldo>=1 && opcion!=2);
			
	}//Fin Main
	
	public static void inicializarPremios(String [] matriz) {
		matriz[0]="CORAZON";	
		matriz[1]="DIAMANTE";
		matriz[2]="TREBOL";
		matriz[3]="CAMPANA";	
		matriz[4]="LIMON";
	}//Fin inicializarPremios
	
}//Fin Clase
