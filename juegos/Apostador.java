package juegos;

public class Apostador extends Jugador{
	
	int monto ;
	int apuestaInicial;
	String nombre;
	boolean juega;
	
	public Apostador(int monto, String nombre, int inicial, boolean juega) {
		super();
		this.monto = monto;
		this.nombre = nombre;
		this.apuestaInicial = inicial;
		this.juega = juega;
	}
	
	
	public void setApuestaInicial (int apuesta) {
		this.apuestaInicial=apuesta;
	}
	
	public boolean isJuega() {
		return juega;
	}




	public void setJuega(boolean juega) {
		this.juega = juega;
	}




	public void doblar() {
		
	}


	public void plantarse() {
		if(this.acumuladoAlterno == 21 || this.acumulado ==21) {
			
			this.blackJack = true;
			
			System.out.println(this.nombre+ "\n" 
					+ "En tu mano tienes: "
					+ "\n"+this.mostrarMano()
					+ "Puntos Normales: " + this.acumulado
					+ "\n"+ "Puntos Alternos: " + this.acumuladoAlterno + "\n");
			
			System.out.println("Tienes BlackJack");
			return ;
		}
		if(this.acumulado > 21) {
			this.masDeBlackJack = true;
			System.out.println(this.nombre+ "\n" 
					+ "En tu mano tienes: "
					+ "\n"+this.mostrarMano()
					+ "Puntos Normales: " + this.acumulado
					+ "\n"+ "Puntos Alternos: " + this.acumuladoAlterno + "\n");
			System.out.println("Te pasaste de 21");
			return ;
		}
		System.out.println(this.nombre+ "\n" 
				+ "En tu mano tienes: "
				+ "\n"+this.mostrarMano()
				+ "Puntos Normales: " + this.acumulado
				+ "\n"+ "Puntos Alternos: " + this.acumuladoAlterno + "\n");
		 return ;
	
	}
	
   
}
