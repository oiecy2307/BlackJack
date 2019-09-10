package juegos;

import java.util.ArrayList;

public abstract class Baraja {
	
	protected int numeroDeCartasPorFigura;
	protected ArrayList<Carta> mazo = new  ArrayList<Carta>();
	
	public Baraja() {
		
		
	}
	
	protected abstract void creaBaraja();
}
