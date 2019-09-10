package juegos;

import java.util.ArrayList;

public abstract class Jugador {
	
	protected  ArrayList<Carta> mano= new  ArrayList<Carta>();
	protected int acumulado=0;
	protected int acumuladoAlterno=0;
	

	
	protected abstract void plantarse();
	protected abstract String mostrarMano();
	
}
