package juegos;

import java.util.ArrayList;
import java.util.Collections;

public class Crupier extends Jugador {
	//protected  ArrayList<Carta> mazo = new  ArrayList<Carta>();
	int monto ;
	public Crupier(int monto) {
		super();
		this.monto = monto;
		
	}
	
	public String mostrarMano() {
		String cadena = "";
		this.acumulado=0;
		this.acumuladoAlterno=0;
		for(int i = 0 ; i< this.mano.size(); i++) {
			cadena = cadena  + this.mano.get(i).toString() + "\n";
			if(!this.mano.get(i).abierta)
				continue;
			if(this.mano.get(i).valorAlterno==11) {
				this.acumulado =  this.acumulado + this.mano.get(i).num;
				this.acumuladoAlterno = this.acumuladoAlterno + this.mano.get(i).valorAlterno;
			}
			else {
				this.acumulado =  this.acumulado + this.mano.get(i).valorAlterno;
				this.acumuladoAlterno = this.acumuladoAlterno + this.mano.get(i).valorAlterno;
				
			}
			
		}
		return cadena;
	}
	
	public void Barajar(ArrayList<Carta> mazo) {
		
		Collections.shuffle(mazo);
	}
	
	
	public void manoInicial(ArrayList<Carta> mazo, ArrayList<Apostador> jugadores) {
		
			  int tamanio= jugadores.size()*2;
			  int j = 0;
			  int i = 0;
			  while(j< tamanio ) {
				  if(i == jugadores.size())
					  i=0;
				  for( Apostador jugador : jugadores) {
					  jugadores.get(i).mano.add(mazo.remove(mazo.size()-1));
					  
					  i++; j++;
					  
				  }
				 
				  
			  }
			  
			  this.mano.add(mazo.remove(mazo.size()-1));
			  this.mano.add(mazo.remove(mazo.size()-1));
			  this.mano.get(mano.size()-1).setAbierta(false);
		}
	
	public void turnoCrupier(ArrayList<Carta> mazo, ArrayList<Apostador> jugadores) {
		//destapar carta cerrada
		//sumar acumulados y si es menor a 17 sigue sacando del mazo de lo contrario se planta el crupier
		//evaluar quien tiene mas o menos puntos que el crupier para pagar
		//evaluar si quieren seguir jugando
		
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
				System.out.println("Crupier "+ "\n" 
						+ "En tu mano tienes: "
						+ "\n"+this.mostrarMano()
						+ "Puntos Normales: " + this.acumulado
						+ "\n"+ "Puntos Alternos: " + this.acumuladoAlterno + "\n");
				System.out.println("Crupier gana con BlackJack");
				break;
			}
			if(this.acumulado > 21 || this.acumuladoAlterno > 21) {
				System.out.println("Crupier "+ "\n" 
						+ "En tu mano tienes: "
						+ "\n"+this.mostrarMano()
						+ "Puntos Normales: " + this.acumulado
						+ "\n"+ "Puntos Alternos: " + this.acumuladoAlterno + "\n");
				System.out.println("Crupier pierde por pasarse de 21");
				break;
			}
			if(this.acumulado>17) {
				System.out.println("Crupier "+ "\n" 
						+ "En tu mano tienes: "
						+ "\n"+this.mostrarMano()
						+ "Puntos Normales: " + this.acumulado
						+ "\n"+ "Puntos Alternos: " + this.acumuladoAlterno + "\n");
				System.out.println("Crupier se planta");
				break;
			}else {
				this.mano.add(mazo.remove(mazo.size()-1));
			this.acumulado =  this.acumulado + this.mano.get(this.mano.size()-1).valorAlterno;
			this.acumuladoAlterno = this.acumuladoAlterno + this.mano.get(this.mano.size()-1).valorAlterno;
			}
			
			}
			
		}
	
		
	
			
		
		
		

	
	
	public void repartirCarta(ArrayList<Carta> mazo, Apostador jugadores) {
		
		
		
		jugadores.mano.add(mazo.remove(mazo.size()-1));
		    
			System.out.println("Jugador: "+jugadores.nombre+ "\n" +
			"En tu mano tienes: "+"\n"+jugadores.mostrarMano()
			+ "Puntos Normales: " + jugadores.acumulado
			+ "\n"+ "Puntos Alternos: " + jugadores.acumuladoAlterno+ "\n"
					);
		
	}

	@Override
	protected void plantarse() {
		// TODO Auto-generated method stub
		
	}
	
	
}
