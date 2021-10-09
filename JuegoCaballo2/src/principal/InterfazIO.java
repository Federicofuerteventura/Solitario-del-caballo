package principal;
import javax.swing.*;


public class InterfazIO {

	public byte pideEjeY(){
		boolean datoBien=false;
		int num=0;
		while (!datoBien) {
			num= Integer.parseInt( JOptionPane.showInputDialog(null,"Introduzca numero de casillas verticales del tablero (0..100)","Tablero",JOptionPane.QUESTION_MESSAGE) );
			if (num<100 && num>0)
				datoBien=true;
		}
		return (byte) num;
		
	}

	public byte pideEjeX() {
		boolean datoBien=false;
		int num=0;
		while (!datoBien) {
			num= Integer.parseInt( JOptionPane.showInputDialog(null,"Introduzca numero de casillas horizontales del tablero (0..100)","Tablero",JOptionPane.QUESTION_MESSAGE) );
			if (num<100 && num>0)
				datoBien=true;
		}
		return (byte) num;
		
	}

	

}