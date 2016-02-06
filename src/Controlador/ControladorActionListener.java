package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Logica.Server.Server;
import Modelo.Modelo;

public class ControladorActionListener implements ActionListener {

	private Modelo modelo; 
	
	public ControladorActionListener(Modelo m) {
		modelo=m;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg) {
		if(arg.getActionCommand().equals("aceptar")){
			modelo.setServidor(new Server(Integer.parseInt(modelo.getVistaEntradaPuerto().getTxtPuerto().getText())));
			modelo.getVistaEntradaPuerto().setVisible(false);
			modelo.getVistaLoading().setVisible(true);
		}
		if(arg.getActionCommand().equals("cancelar")){
			System.exit(0);
		}
	}

}
