package principal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Lamina extends JPanel{
	JButton [][] botones;
	JLabel cantMovimientos;
	Tablero tablero;
	JPanel laminaBotones;
	Oyente oyente;
	
	public Lamina(byte x, byte y){
		
		tablero = new Tablero(x,y);
		setLayout(new BorderLayout());
		
		//ponemos las instrucciones en la parde de arriba del panel
		JLabel instrucciones= new JLabel("Pulse un boton para mover el caballo, recuerde que el caballo puede mover 3 casillas pero nunca en forma recta");
		this.add(instrucciones, BorderLayout.NORTH);
		
		//agregamos botones a la lamina
		laminaBotones = new JPanel();
		laminaBotones.setLayout(new GridLayout(x,y));	
		oyente = new Oyente();
		
		botones = new JButton[x][y] ;
		for(int i=0;i<x;i++) {
			for (int j=0;j<y;j++) {
				botones[i][j]= new JButton(""+i+j);
				botones [i][j].addActionListener(oyente);
				
				
				laminaBotones.add(botones[i][j]);				
			}
		}
		this.add(laminaBotones,BorderLayout.CENTER);
		
		//agregamos el texto y boton de Reestart debajo para la cantidad de movimientos
		
		JPanel laminaAbajo= new JPanel();
		laminaAbajo.setLayout(new BorderLayout());				
		cantMovimientos= new JLabel("Ha movido el caballo 0 veces");
		laminaAbajo.add(cantMovimientos, BorderLayout.EAST);			
		this.add(laminaAbajo,BorderLayout.SOUTH);
		
		
	}
	//clase interna
	private class Oyente implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			//boton de reiniciar
			if (e.getActionCommand().equals("Reiniciar")) {
				tablero.reiniciarTablero();
				reiniciar();
				
				
				
			}
			String valor=e.getActionCommand();
			byte x= (byte)Character.getNumericValue(valor.charAt(0));
			byte y= (byte)Character.getNumericValue(valor.charAt(1));
			if (tablero.esPrimerMovimiento()) {
				
				tablero.marcarCasilla(x,y);
				moverCavallo(x, y);		
		
			} else {
				
					if(!tablero.puedeMover(x, y)) {
						marcaMalMovimiento(x, y);
					} else {
						byte [] ultimoMovimiento = new byte [2];
						ultimoMovimiento=tablero.getUltimoMovimiento();
						marcarQuePaso(ultimoMovimiento[0],ultimoMovimiento[1]);
						tablero.marcarCasilla(x, y);					
					
						moverCavallo(x, y);
						cambiaCantMov(tablero.getCantidadDeMovimientos());
						if(!tablero.noEsUltimoMovimiento(x,y)) {
							marcaFinJuego(tablero.getCantidadDeMovimientos());
							
						}
			
					}
				 
			}
			
		}

		
		
	}
	
	public void moverCavallo(byte x, byte y)  {
		
		ImageIcon fot = new ImageIcon("C:\\Users\\Federico\\OneDrive\\Documentos\\JuegoCaballo\\imagenes\\caballo.png");
		Icon icono = new ImageIcon(fot.getImage().getScaledInstance(this.botones[x][y].getWidth(),this.botones[x][y].getHeight(), Image.SCALE_DEFAULT));
		this.botones[x][y].setIcon(icono);
		
			
		
	}
	
	public void marcaMalMovimiento(byte x,byte y) {
		
		try {
			this.botones [x][y].setBackground(Color.GREEN);
			this.botones[x][y].setText(null);
			Thread.sleep(700);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		botones[x][y].setBackground(null);
		
	}
	
	public void marcarQuePaso(byte x,byte y) {
		this.botones [x][y].setBackground(Color.GREEN);
		this.botones[x][y].setText(null);
		this.botones[x][y].setIcon(null);
	}
	
	public void cambiaCantMov(byte veces) {
		cantMovimientos.setText("Ha movido el caballo "+ veces+" veces");
	}
	
	private void marcaFinJuego(byte cantidadDeMovimientos) {
		// TODO Auto-generated method stub
		cantMovimientos.setText("FIN ha movido el caballo "+ cantidadDeMovimientos+" veces");
		cantMovimientos.setBackground(Color.red);
		cantMovimientos.setOpaque(true);
	}
	
	public void reiniciar() {
		for(int i=0;i<botones.length;i++) {
			for (int j=0;j<botones[0].length;j++) {
				botones[i][j]= new JButton(""+i+j);
				botones [i][j].addActionListener(oyente);
				laminaBotones.add(botones[i][j]);				
			}
		}
	}
	
	
	

}
