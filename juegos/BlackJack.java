package juegos;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BlackJack {
	Scanner scan = new Scanner(System.in);
	public BlackJack() {
		jugarBlackJack();
	}
	
	public static void main(String[] args) {
		new BlackJack();
	}
	
	public void jugarBlackJack() {
		
		ArrayList<Apostador> jugadores = new ArrayList<Apostador>();
		
		
			
			//Scanner scan = new Scanner(System.in);
			int numJugadores=0;
            int montoCrupier=0;
            int montoJugador=0;
            int apuestaInicial = 0;
            String nombreJugador = "";
            Pattern p = Pattern.compile("[a-zA-Z]");
            Matcher m;
			do {//Mientras no se ingresen los datos correctamente entra al ciclo para
				//pedir datos de entrada.
				try {
					//Ingreso de datos para la generación del tablero.
					System.out.println("Ingrese el numero de jugadores (mín 1 - max 3)");
					numJugadores = scan.nextInt();
					if(numJugadores<1 || numJugadores > 3){
						System.out.println("Ingreso erroneo de datos, volver a empezar");
						continue;
					}
					System.out.println("Ingrese el monto inicial para el crupier");
					montoCrupier = scan.nextInt();
					if(montoCrupier< 100){
						System.out.println("Ingreso erroneo del monto, volver a empezar");
						continue;
					}
					break;
				}catch(Exception e) {
					scan.next();
					System.out.println("Ingreso erroneo de datos, volver a empezar");
				}
			}while(true);
			
			//Agregamos jugadores al juego con su nombre y su monto inicial para apostar
			
			for(int i = 0; i < numJugadores; i++) {
				try{
					//Datos del jugador
					System.out.println("Ingrese el nombre del Jugador "+(i+1));
					nombreJugador = scan.next();
					System.out.println("Ingrese el monto inicial del Jugador "+(i+1));
					montoJugador = scan.nextInt();
					System.out.println("Ingrese Apuesta inicial del Jugador "+(i+1));
					apuestaInicial = scan.nextInt();
					
					//m = p.matcher(nombreJugador);
					//Se evalua si el monto minimo es de 100 y que el nombre del jugador no tenga numeros . && m.matches()
					if(montoJugador < 100 || apuestaInicial <10 || apuestaInicial>montoJugador) {
						System.out.println("valores invalidos, por favor ingrese el último nuevamente.");
						i--;
						continue;
					}
					//Se agregan apostadores a la mesa de juego.
					montoJugador = montoJugador - apuestaInicial;
					jugadores.add(new Apostador(montoJugador, nombreJugador,apuestaInicial));
				}catch(Exception e) {
					scan.next();
					System.out.println("Ingreso erroneo de datos, volver a empezar el ingreso del Jugador "+(i+1));
					i--;
				}
			}
			scan.nextLine();
			//Se inicia la mesa de juego
			Crupier crupier = new Crupier(montoCrupier);
			iniciar(crupier,jugadores);
			scan.close();
			
			
	}
	
	private void iniciar(Crupier crupier, ArrayList<Apostador> jugadores) {
		BarajaInglesa barajaInl = new BarajaInglesa();
		crupier.Barajar(barajaInl.mazo);
		crupier.manoInicial(barajaInl.mazo, jugadores);
		
		int vuelta = jugadores.size();
		int opc = 0;
		//Inicia Rondas
		System.out.println("Crupier "+ "\n" 
				+ "En tu mano tienes: "
				+ "\n"+crupier.mostrarMano()
				+ "Puntos Normales: " + crupier.acumulado
				+ "\n"+ "Puntos Alternos: " + crupier.acumuladoAlterno + "\n");
		
		
		for(int i = 0 ; i < jugadores.size(); i++) {
			System.out.println("Jugador: "+jugadores.get(i).nombre+ "\n" +
		    "Tu apuesta inicial es de: " + jugadores.get(i).apuestaInicial+ "\n" +
			"Tu monto es de: " + jugadores.get(i).monto+ "\n"+
			"En tu mano tienes: "+"\n"+jugadores.get(i).mostrarMano()
			+ "Puntos Normales: " + jugadores.get(i).acumulado
			+ "\n"+ "Puntos Alternos: " + jugadores.get(i).acumuladoAlterno+ "\n");
			
			do {
				
				System.out.println("¿Cuál es tu decision?");
				
				System.out.println("1 - Pedir una carta");
		        System.out.println("2 - Doblar");
		        System.out.println("3 - Plantarse");
		       // System.out.println("0 - Fin del turno de " +jugadores.get(i).nombre);
				
		        opc = scan.nextInt();
		        
				switch(opc) {
				case 1: 
				crupier.repartirCarta(barajaInl.mazo,jugadores.get(i));
				break;
				
				case 2:
				//break;
				case 3: System.out.println("Fin del turno de " +jugadores.get(i).nombre+ "\n");
				break;
				}
				
				
			}while(opc!=3);
			
		}
		System.out.println("Turno del crupier");
		crupier.turnoCrupier(barajaInl.mazo,jugadores);
		//destapar carta cerrada
		//sumar acumulados y si es menor a 17 sigue sacando del mazo de lo contrario se planta el crupier
		//evaluar quien tiene mas o menos puntos que el crupier para pagar
		//evaluar si quieren seguir jugando
		//Acciones del crupier
		
		/**/
		
	}
	
	
	
}
