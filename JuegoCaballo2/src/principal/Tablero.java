package principal;



/**
 * @author Sara Fede
 *
 */
public class Tablero{
	private byte tablero [][];
	private byte cantidadDeMovimientos;
	private byte  ultimoMovimiento[]= new byte[2];
	private byte altoTablero;
	private byte anchoTablero;
	
	public Tablero(byte x,byte y) {
		anchoTablero=x;
		altoTablero=y;
		
		tablero = new byte [x] [y];
		for (int i=0;  i<x;i++ ) {
			for (int j=0; j<y;j++) {
				tablero [i][j]=0;
			}
		}
		cantidadDeMovimientos=0;
	}
	
	public void reiniciarTablero() {
		for (int i=0;  i<anchoTablero;i++ ) {
			for (int j=0; j<anchoTablero;j++) {
				tablero [j][i]=0;
			}
		}
		cantidadDeMovimientos=0;
		
		
	}
	
	
	public byte getCantidadDeMovimientos() {
		return cantidadDeMovimientos;
	}

	

	public byte[] getUltimoMovimiento() {
		return ultimoMovimiento;
	}


	
	
	
//	pre tiene que poder moverse
	public void marcarCasilla(byte x, byte y) {
		cantidadDeMovimientos++;
		tablero [x][y]=cantidadDeMovimientos;
		ultimoMovimiento[0]=x;
		ultimoMovimiento[1]=y;
	}
//	comprueba si puede mover
	public boolean noEstaOcupado(byte x,byte y) {
		if (tablero[x] [y]==0)
			return true;
		else
			return false;
		
		
	}
	
	public boolean puedeMover(byte x, byte y) {
		if(this.noEstaOcupado(x, y)){
			if (x>10 && y>10) {
				return false;
			} else {
				if(Math.abs(ultimoMovimiento[0]-x)+Math.abs(ultimoMovimiento[1]-y)==3 ) {
					if (ultimoMovimiento[0]==x || ultimoMovimiento[1]==y) {
						return false;
					} else
						return true;
				}
				
			}
			
			
		}
		return false;
		
	}
	
	public boolean esPrimerMovimiento(){
		return cantidadDeMovimientos==0;
	}



	public boolean noEsUltimoMovimiento(byte x, byte y) {
		// TODO Chequea que si hay alguna casilla que pueda moverse el caballo
		
		
		byte posibilidadAX=(byte) (x-2);
		byte posibilidadAY=(byte) (y-1);
		
		byte posibilidadBX=(byte) (x-1);
		byte posibilidadBY=(byte) (y-2);
		
		byte posibilidadCX=(byte) (x+2);
		byte posibilidadCY=(byte) (y+1);
		
		byte posibilidadDX=(byte) (x+1);
		byte posibilidadDY=(byte) (y+2);
		
		byte posibilidadEX=(byte) (x+2);
		byte posibilidadEY=(byte) (y-1);
		
		byte posibilidadFX=(byte) (x+1);
		byte posibilidadFY=(byte) (y-2);
		
		byte posibilidadGX=(byte) (x-2);
		byte posibilidadGY=(byte) (y+1);
		
		byte posibilidadHX=(byte) (x-1);
		byte posibilidadHY=(byte) (y+2);
		
		if((posibilidadAX<anchoTablero) && (posibilidadAY<altoTablero)  && (posibilidadAX>=0) && (posibilidadAY>=0)&& tablero[posibilidadAX][posibilidadAY]==0) {
			return true;
		}
		
		if((posibilidadBX<anchoTablero) && (posibilidadBY<altoTablero)  && (posibilidadBX>=0) && (posibilidadBY>=0)&& tablero[posibilidadBX][posibilidadBY]==0) {
			return true;
		}
		
		if((posibilidadCX<anchoTablero) && (posibilidadCY<altoTablero) && (posibilidadCX>=0) && (posibilidadCY>=0)&& tablero[posibilidadCX][posibilidadCY]==0) {
			return true;
		}
		
		if((posibilidadDX<anchoTablero) && (posibilidadDY<altoTablero)  && (posibilidadDX>=0) && (posibilidadDY>=0)&& tablero[posibilidadDX][posibilidadDY]==0) {
			return true;
		}
		
		if((posibilidadEX<anchoTablero) && (posibilidadEY<altoTablero)  && (posibilidadEX>=0) && (posibilidadEY>=0)&& tablero[posibilidadEX][posibilidadEY]==0) {
			return true;
		}
		
		if((posibilidadFX<anchoTablero) && (posibilidadFY<altoTablero) && (posibilidadFX>=0) && (posibilidadFY>=0)&& tablero[posibilidadFX][posibilidadFY]==0 ) {
			return true;
		}
		
		if((posibilidadGX<anchoTablero) && (posibilidadGY<altoTablero) && (posibilidadGX>=0) && (posibilidadGY>=0)&& tablero[posibilidadGX][posibilidadGY]==0 ) {
			return true;
		}
		
		if((posibilidadHX<anchoTablero) && (posibilidadHY<altoTablero) && (posibilidadHX>=0) && (posibilidadHY>=0)&& tablero[posibilidadHX][posibilidadHY]==0 ) {
			return true;
		}
		
		
		return false;
	}
	
	

	
	
	

}
