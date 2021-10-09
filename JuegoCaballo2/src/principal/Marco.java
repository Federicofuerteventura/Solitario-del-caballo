package principal;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;




@SuppressWarnings("serial")
class Marco extends JFrame implements ActionListener {
	JButton botonReiniciar;
	private byte ancho;
	private byte largo;
	Lamina lamina;
	
	
	
	
	public Marco() {
		// TODO Crea un marco para poner la lamina del tablero
		setLayout(new BorderLayout());
		setBounds(0,0,600,600);
		setTitle("Juedo del caballo ajedrez");
		botonReiniciar= new JButton("REINICIAR");
		botonReiniciar.addActionListener(this);
		
		
		InterfazIO interfazIO=new InterfazIO();
		ancho=interfazIO.pideEjeX();
		largo = interfazIO.pideEjeY();		
		
		lamina = new Lamina(ancho,largo);
		this.add(lamina,BorderLayout.CENTER);
		this.add(botonReiniciar, BorderLayout.SOUTH);
		
		
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Accion que se realiza cuando apretamos boton reiniciar
		lamina.setVisible(false);
		lamina = new Lamina(ancho,largo);
		this.add(lamina,BorderLayout.CENTER);
		lamina.setVisible(true);
	}
	

}
