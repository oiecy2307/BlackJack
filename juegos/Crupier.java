package juegos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Crupier extends Jugador {
	BarajaInglesa barajaInl = new BarajaInglesa();
	int monto ;
	public Crupier(int monto) {
		super();
		this.monto = monto;
		
	}
	
	
	
	public void Barajar() {
		
		Collections.shuffle(barajaInl.mazo);
	}
	
	
	public void manoInicial(ArrayList<Apostador> jugadores) {
		
			  int tamanio= jugadores.size()*2;
			  int j = 0;
			  int i = 0;
			  while(j< tamanio ) {
				  if(i == jugadores.size())
					  i=0;
				  for( Apostador jugador : jugadores) {
					  jugadores.get(i).mano.add(barajaInl.mazo.remove(barajaInl.mazo.size()-1));
					  jugadores.get(i).cincoCartas++;
					  i++; j++;
					  
				  }
				 
				  
			  }
			  
			  this.mano.add(barajaInl.mazo.remove(barajaInl.mazo.size()-1));
			  this.mano.add(barajaInl.mazo.remove(barajaInl.mazo.size()-1));
			  this.mano.get(mano.size()-1).setAbierta(false);
		}
	
	public void turnoCrupier() {
		
		//for(int i = 0; i<jugadores.size() ; i++) {
		//if(jugadores.get(i).masDeBlackJack)
		//	return;
		//if(jugadores.get(i).blackJack || !jugadores.get(i).blackJack) {
		this.mano.get(mano.size()-1).setAbierta(true);
		this.acumulado =  this.acumulado + this.mano.get(this.mano.size()-1).valorAlterno;
		this.acumuladoAlterno = this.acumuladoAlterno + this.mano.get(this.mano.size()-1).valorAlterno;
		System.out.println("Crupier "+ "\n" 
				+ "En tu mano tienes: "
				+ "\n"+this.mostrarMano()
				+ "Puntos Normales: " + this.acumulado
				+ "\n"+ "Puntos Alternos: " + this.acumuladoAlterno + "\n");
		
		while (true) {
			if(this.acumuladoAlterno == 21 || this.acumulado ==21) {
				
				this.blackJack = true;
				
				System.out.println("Crupier "+ "\n" 
						+ "En tu mano tienes: "
						+ "\n"+this.mostrarMano()
						+ "Puntos Normales: " + this.acumulado
						+ "\n"+ "Puntos Alternos: " + this.acumuladoAlterno + "\n");
				System.out.println("Crupier tiene BlackJack"+"\n");
				break;
			}
			if(this.acumulado > 21) {
				this.masDeBlackJack = true;
				System.out.println("Crupier "+ "\n" 
						+ "En tu mano tienes: "
						+ "\n"+this.mostrarMano()
						+ "Puntos Normales: " + this.acumulado
						+ "\n"+ "Puntos Alternos: " + this.acumuladoAlterno + "\n");
				System.out.println("Crupier se ha pasado de 21"+"\n");
				break;
			}
			if(this.acumulado>=17) {
				System.out.println("Crupier "+ "\n" 
						+ "En tu mano tienes: "
						+ "\n"+this.mostrarMano()
						+ "Puntos Normales: " + this.acumulado
						+ "\n"+ "Puntos Alternos: " + this.acumuladoAlterno + "\n");
				System.out.println("Crupier se planta"+"\n");
				break;
			}else {
				this.mano.add(barajaInl.mazo.remove(barajaInl.mazo.size()-1));
			this.acumulado =  this.acumulado + this.mano.get(this.mano.size()-1).valorAlterno;
			this.acumuladoAlterno = this.acumuladoAlterno + this.mano.get(this.mano.size()-1).valorAlterno;
			}
			
			}
		//}
		//}
		}
	
		
	
			
		
		
		

	
	
	public int repartirCarta(Apostador jugadores) {
		
		
		
		jugadores.mano.add(barajaInl.mazo.remove(barajaInl.mazo.size()-1));
		jugadores.cincoCartas++;
		
			jugadores.mostrarMano();
			if(jugadores.acumuladoAlterno == 21 || jugadores.acumulado ==21) {
				
				jugadores.blackJack = true;
				
				System.out.println(jugadores.nombre+ "\n" 
						+ "En tu mano tienes: "
						+ "\n"+jugadores.mostrarMano()
						+ "Puntos Normales: " + jugadores.acumulado
						+ "\n"+ "Puntos Alternos: " + jugadores.acumuladoAlterno + "\n");
				
				System.out.println("Tienes BlackJack");
				return 1;
			}
			if(jugadores.acumulado > 21) {
				jugadores.masDeBlackJack = true;
				System.out.println(jugadores.nombre+ "\n" 
						+ "En tu mano tienes: "
						+ "\n"+jugadores.mostrarMano()
						+ "Puntos Normales: " + jugadores.acumulado
						+ "\n"+ "Puntos Alternos: " + jugadores.acumuladoAlterno + "\n");
				System.out.println("Te pasaste de 21");
				return 2;
			}
			if(jugadores.cincoCartas == 5 && jugadores.acumulado <=21) {
				jugadores.masDeBlackJack = true;
				System.out.println(jugadores.nombre+ "\n" 
						+ "En tu mano tienes: "
						+ "\n"+jugadores.mostrarMano()
						+ "Puntos Normales: " + jugadores.acumulado
						+ "\n"+ "Puntos Alternos: " + jugadores.acumuladoAlterno + "\n");
				System.out.println("Tienes 5 cartas y menos de 21 puntos");
				return 2;
			}
			System.out.println(jugadores.nombre+ "\n" 
					+ "En tu mano tienes: "
					+ "\n"+jugadores.mostrarMano()
					+ "Puntos Normales: " + jugadores.acumulado
					+ "\n"+ "Puntos Alternos: " + jugadores.acumuladoAlterno + "\n");
			 return 3;
		
	}
	
	public void cobrar(ArrayList<Apostador> jugadores) {
		
		for(int i = 0; i<jugadores.size();i++) {
			
			if(jugadores.get(i).cincoCartas==5 && jugadores.get(i).acumulado<=21) {
				System.out.println("El jugador " + jugadores.get(i).nombre + " gana con cinco cartas\n");
				jugadores.get(i).monto = jugadores.get(i).monto + jugadores.get(i).apuestaInicial;
				this.monto = this.monto-jugadores.get(i).apuestaInicial;
				jugadores.get(i).acumulado = 0;
				jugadores.get(i).acumuladoAlterno=0;
				jugadores.get(i).blackJack=false;
				jugadores.get(i).masDeBlackJack=false;
				jugadores.get(i).cincoCartas = 0;
				
				barajaInl.mazo.addAll(jugadores.get(i).mano);  
				jugadores.get(i).mano.removeAll(jugadores.get(i).mano);
				continue;
			}
			
			if(jugadores.get(i).masDeBlackJack==true) {
				System.out.println("El crupier ganó, " + jugadores.get(i).nombre +"  se pasó de 21\n");
				this.monto = this.monto + jugadores.get(i).apuestaInicial;
				jugadores.get(i).monto = jugadores.get(i).monto - jugadores.get(i).apuestaInicial;
				jugadores.get(i).acumulado = 0;
				jugadores.get(i).acumuladoAlterno=0;
				jugadores.get(i).blackJack=false;
				jugadores.get(i).masDeBlackJack=false;
				jugadores.get(i).cincoCartas = 0;
				
				barajaInl.mazo.addAll(jugadores.get(i).mano);  
				jugadores.get(i).mano.removeAll(jugadores.get(i).mano);
				continue;
			}
			
			if(this.blackJack== true && jugadores.get(i).blackJack==true) {
				System.out.println("Crupier y el jugador: " + jugadores.get(i).nombre + " empataron con BlackJack\n");
				jugadores.get(i).acumulado = 0;
				jugadores.get(i).acumuladoAlterno=0;
				jugadores.get(i).blackJack=false;
				jugadores.get(i).masDeBlackJack=false;
				jugadores.get(i).cincoCartas = 0;
				
				barajaInl.mazo.addAll(jugadores.get(i).mano);  
				jugadores.get(i).mano.removeAll(jugadores.get(i).mano);
				continue;
			}
			if(this.masDeBlackJack && !jugadores.get(i).masDeBlackJack ) {
				
				System.out.println("El jugador " + jugadores.get(i).nombre + " gana, crupier se pasó de 21\n");
				jugadores.get(i).monto = jugadores.get(i).monto + jugadores.get(i).apuestaInicial;
				this.monto = this.monto-jugadores.get(i).apuestaInicial;
				jugadores.get(i).acumulado = 0;
				jugadores.get(i).acumuladoAlterno=0;
				jugadores.get(i).blackJack=false;
				jugadores.get(i).masDeBlackJack=false;
				jugadores.get(i).cincoCartas = 0;
				
				barajaInl.mazo.addAll(jugadores.get(i).mano);  
				jugadores.get(i).mano.removeAll(jugadores.get(i).mano);
				continue;
				
			} 
			if(!this.masDeBlackJack && jugadores.get(i).masDeBlackJack) {
				
				System.out.println("El crupier le ganó con BlackJack al jugador " + jugadores.get(i).nombre +"\n");
				this.monto = this.monto + jugadores.get(i).apuestaInicial;
				jugadores.get(i).monto = jugadores.get(i).monto - jugadores.get(i).apuestaInicial;
				jugadores.get(i).acumulado = 0;
				jugadores.get(i).acumuladoAlterno=0;
				jugadores.get(i).blackJack=false;
				jugadores.get(i).masDeBlackJack=false;
				jugadores.get(i).cincoCartas = 0;
				
				barajaInl.mazo.addAll(jugadores.get(i).mano);  
				jugadores.get(i).mano.removeAll(jugadores.get(i).mano);
				continue;
			}
			
			
			if(this.blackJack && !jugadores.get(i).masDeBlackJack ) {
				
				System.out.println("Crupier gana por BlackJack a " + jugadores.get(i).nombre);
				this.monto = this.monto + jugadores.get(i).apuestaInicial;
				jugadores.get(i).monto = jugadores.get(i).monto - jugadores.get(i).apuestaInicial;
				jugadores.get(i).acumulado = 0;
				jugadores.get(i).acumuladoAlterno=0;
				jugadores.get(i).blackJack=false;
				jugadores.get(i).masDeBlackJack=false;
				jugadores.get(i).cincoCartas = 0;
				
				barajaInl.mazo.addAll(jugadores.get(i).mano);  
				jugadores.get(i).mano.removeAll(jugadores.get(i).mano);
				continue;
				
			}
			
			if(jugadores.get(i).blackJack && !this.blackJack) {
				
				System.out.println("El jugador " + jugadores.get(i).nombre +" gana con BlackJack");
				jugadores.get(i).monto = jugadores.get(i).monto + jugadores.get(i).apuestaInicial;
				this.monto = this.monto-jugadores.get(i).apuestaInicial;
				jugadores.get(i).acumulado = 0;
				jugadores.get(i).acumuladoAlterno=0;
				jugadores.get(i).blackJack=false;
				jugadores.get(i).masDeBlackJack=false;
				jugadores.get(i).cincoCartas = 0;
				
				barajaInl.mazo.addAll(jugadores.get(i).mano);  
				jugadores.get(i).mano.removeAll(jugadores.get(i).mano);
				continue;
			}
			
			if(this.acumulado<jugadores.get(i).acumulado || this.acumulado<jugadores.get(i).acumuladoAlterno ) {
				System.out.println("El jugador " + jugadores.get(i).nombre +" gana con mayor puntaje");
				jugadores.get(i).monto = jugadores.get(i).monto + jugadores.get(i).apuestaInicial;
				this.monto = this.monto-jugadores.get(i).apuestaInicial;
				jugadores.get(i).acumulado = 0;
				jugadores.get(i).acumuladoAlterno=0;
				jugadores.get(i).blackJack=false;
				jugadores.get(i).masDeBlackJack=false;
				jugadores.get(i).cincoCartas = 0;
				
				barajaInl.mazo.addAll(jugadores.get(i).mano);  
				jugadores.get(i).mano.removeAll(jugadores.get(i).mano);
				continue;
			}
			
			if(this.acumulado>jugadores.get(i).acumulado || this.acumulado>jugadores.get(i).acumuladoAlterno) {
				System.out.println("Crupier gana por mayoria de puntos a " + jugadores.get(i).nombre);
				this.monto = this.monto + jugadores.get(i).apuestaInicial;
				jugadores.get(i).monto = jugadores.get(i).monto - jugadores.get(i).apuestaInicial;
				jugadores.get(i).acumulado = 0;
				jugadores.get(i).acumuladoAlterno=0;
				jugadores.get(i).blackJack=false;
				jugadores.get(i).masDeBlackJack=false;
				jugadores.get(i).cincoCartas = 0;
				
				barajaInl.mazo.addAll(jugadores.get(i).mano);  
				jugadores.get(i).mano.removeAll(jugadores.get(i).mano);
				continue;
			}
			
			if(this.acumulado==jugadores.get(i).acumulado) {
				
				System.out.println("Crupier y el jugador " + jugadores.get(i).nombre + " empataron con mismos puntos");
				jugadores.get(i).acumulado = 0;
				jugadores.get(i).acumuladoAlterno=0;
				jugadores.get(i).blackJack=false;
				jugadores.get(i).masDeBlackJack=false;
				jugadores.get(i).cincoCartas = 0;
				
				barajaInl.mazo.addAll(jugadores.get(i).mano);  
				jugadores.get(i).mano.removeAll(jugadores.get(i).mano);
				
				continue;
			}
		
			
		}
	}
	
public void nuevaRonda(ArrayList<Apostador> jugadores) {
	
	int opc = 0;
	Scanner scan = new Scanner(System.in);
	int nuevaApuesta=0;
	int aux=jugadores.size();
	int count = 0;
	for(int i = 0; i<jugadores.size();i++) {
		
		
		
	// while(opc!=3){
		
			if(aux==count)
				return;
			System.out.println("Jugador: " +jugadores.get(i).nombre+" ¿Deseas seguir jugando?");
			
			System.out.println("1 - Si"+"\n");
	        System.out.println("2 - No"+"\n");
    
	        opc = scan.nextInt();
	        
			//switch(opc) {
			//case 1:
	        
	        
	        if(opc==1) {
				try {
	            System.out.println("¿Cual es la cantidad de tu nueva apuesta?");
				nuevaApuesta = scan.nextInt();
				
				if(jugadores.get(i).monto==0) {
					System.out.println(jugadores.get(i).nombre + ", Tu monto para jugar se ha acabado, Adios!");
					jugadores.get(i).mano.removeAll(jugadores.get(i).mano);
					jugadores.remove(i);
					i--;
					continue;
				}
				
				if(nuevaApuesta>jugadores.get(i).monto) {
					System.out.println("Tu apuesta excede tu monto actual , por favor, considera una nueva apuesta");
					i--;
					continue;
				}
				
				
				jugadores.get(i).setApuestaInicial(nuevaApuesta);
				
				count ++;
				opc = 3;
				
				continue;
				
				
				
				}catch(Exception e) {
					scan.next();
					System.out.println("Ingreso erroneo de apuesta, favor de ingresarla correctamente");
					i--;
				}
	        }
	        else if (opc==2) {
				System.out.println("Hasta luego y gracias por jugar " + jugadores.get(i).nombre + "!");
				barajaInl.mazo.addAll(jugadores.get(i).mano);  
				jugadores.get(i).acumulado = 0;
				jugadores.get(i).acumuladoAlterno=0;
				jugadores.get(i).blackJack=false;
				jugadores.get(i).masDeBlackJack=false;
				jugadores.get(i).mano.removeAll(jugadores.get(i).mano);
				jugadores.remove(i);
				count ++;
				opc=3;
				i=0;
				continue;
	        }
			//}
		
			
			
			
			//}
			
		}
	this.acumulado = 0;
	this.acumuladoAlterno =0;
	this.blackJack = false;
	this.masDeBlackJack = false;
barajaInl.mazo.addAll(this.mano);
this.mano = new ArrayList<Carta>();//.removeAll(mano);
}
}
		
		
		
	

	
	
	

