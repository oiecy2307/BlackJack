package juegos;

public class BarajaInglesa extends Baraja   {
	
	public BarajaInglesa() {
		super();
		//this.numeroDeCartas = 52;
		this.numeroDeCartasPorFigura = 13;
		creaBaraja();
		//super.shuffle();
	}
	
	/*
	 Metodo sobrecargado para crear una baraja de tipo inglesa, este método se ejecuta en el constructor de esta misma clase,
	 entonces cuando se instancia un objeto de la clase BarajaInglesa, se crea una nueva baraja inglesa. 
	 */
	@Override
	protected void creaBaraja() {
		
		//this.mazo = (Carta<FigurasBarajaInglesa>[]) new Carta[numeroDeCartas];
		FigurasBarajaInglesa [] figuras = FigurasBarajaInglesa.values();
	    
		for(int i=0;i < figuras.length; i++) {
			for(int j=0; j< numeroDeCartasPorFigura; j++) {
				
				switch(j+1) {
				case 1: 
					mazo.add(new Carta(j+1, figuras[i], true,11));
					break;
				case 2: 
					mazo.add(new Carta(j+1, figuras[i], true,2));
					break;
				case 3: 
					mazo.add(new Carta(j+1, figuras[i], true,3));
					break;
				case 4: 
					mazo.add(new Carta(j+1, figuras[i], true,4));
					break;
				case 5: 
					mazo.add(new Carta(j+1, figuras[i], true,5));
					break;
				case 6: 
					mazo.add(new Carta(j+1, figuras[i], true,6));
					break;
				case 7: 
					mazo.add(new Carta(j+1, figuras[i], true,7));
					break;
				case 8: 
					mazo.add(new Carta(j+1, figuras[i], true,8));
					break;
				case 9: 
					mazo.add(new Carta(j+1, figuras[i], true,9));
					break;
				case 10: 
					mazo.add(new Carta(j+1, figuras[i], true,10));
					break;
				case 11: 
					mazo.add(new Carta(j+1, figuras[i], true,10));
					break;
				case 12: 
					mazo.add(new Carta(j+1, figuras[i], true,10));
					break;
				case 13: 
					mazo.add(new Carta(j+1, figuras[i], true,10));
					break;
				
				}
				
					
			
			}
			}
	}
	
	


}
