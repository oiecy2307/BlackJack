package juegos;

public class Apostador extends Jugador{
	
	int monto ;
	int apuestaInicial;
	String nombre;
	
	public Apostador(int monto, String nombre, int inicial) {
		//super();
		this.monto = monto;
		this.nombre = nombre;
		this.apuestaInicial = inicial;
	}
	
	
	public String mostrarMano() {
		String cadena = "";
		int aux = 0;
		this.acumulado = 0;
		this.acumuladoAlterno = 0;
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
	
	public void doblar() {
		
	}

	@Override
	protected void plantarse() {
		// TODO Auto-generated method stub
		
	}
	
	
   
}
