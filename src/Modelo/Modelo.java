package Modelo;

import Controlador.ControladorActionListener;
import Logica.Server.Server;
import Vista.EntradaPuerto;
import Vista.Loading;

public class Modelo {
	
	private Server servidor;
	private Loading vistaLoading;
	private ControladorActionListener CAL;
	private EntradaPuerto vistaEntradaPuerto;
	
	public Modelo() {
		CAL=new ControladorActionListener(this);
		vistaEntradaPuerto=new EntradaPuerto(CAL);
		vistaLoading=new Loading();
		
		vistaEntradaPuerto.setVisible(true);
	}

	public Server getServidor() {
		return servidor;
	}

	public void setServidor(Server servidor) {
		this.servidor = servidor;
	}

	public Loading getVistaLoading() {
		return vistaLoading;
	}

	public EntradaPuerto getVistaEntradaPuerto() {
		return vistaEntradaPuerto;
	}
	
}
