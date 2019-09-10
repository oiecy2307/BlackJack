package juegos;

public class Carta<T> {
	
	public int num;
	public T figura;
	public boolean abierta=true;
	public int valorAlterno;
	
	public Carta(int numero, T figura, boolean abierta, int alterno) {
		this.num =numero;
		this.figura = figura;
		this.abierta= abierta;
		this.valorAlterno = alterno;
	}


	public int getNum() {
		return num;
	}


	public T getFigura() {
		return figura;
	}
	
	public boolean getAbierta() {
		return abierta;
	}
	


	public void setAbierta(boolean abierta) {
		this.abierta = abierta;
	}


	public String toString() {
		String tipoCarta = "";
		String descripcion = "";
		
		if(figura.getClass().getSimpleName().equals("FigurasBarajaInglesa") && this.abierta) {
			switch(num) {
			case 1:
				tipoCarta = "AS";
				break;
			case 11:
				tipoCarta = "JOTA";
				break;
			case 12:
				tipoCarta = "REYNA";
				break;
			case 13: 
				tipoCarta = "REY";
				break;
			default:
				tipoCarta = num+"";
			}
			
			
			return descripcion = tipoCarta + " de " + figura;
		} else {
			
			return descripcion = "Carta Tapada";
		}
		
		
		
			
	}
	
}
