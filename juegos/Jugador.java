package juegos;

import java.util.ArrayList;

public abstract class Jugador {
	
	protected  ArrayList<Carta> mano= new  ArrayList<Carta>();
	protected int acumulado=0;
	protected int acumuladoAlterno=0;
	protected boolean blackJack= false;
	protected boolean masDeBlackJack = false;
	

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
	//protected abstract void plantarse();
	//protected abstract String mostrarMano();
	
}
