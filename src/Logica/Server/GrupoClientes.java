package Logica.Server;

import java.net.Socket;
import java.util.ArrayList;

public class GrupoClientes extends Thread {
	
	private ArrayList<ClienteHilo> listaClientes;
	
	public GrupoClientes() {
		listaClientes=new ArrayList<ClienteHilo>();
	}
	
	public void agregarCliente(Socket s){
		ClienteHilo cliente=new ClienteHilo(this, s);
		listaClientes.add(cliente);
		cliente.start();
	}
	
	@Override
	public void run() {
		while(true){
			limpiar();
			try {
				Thread.sleep(3000);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	private void limpiar(){
		for(int i=0;i<listaClientes.size();i++){
			if(listaClientes.get(i)==null | !listaClientes.get(i).isAlive()){
				listaClientes.remove(i);
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	public void InterpretarMensaje(String ms,ClienteHilo hijo){
		enviarMensaje(ms,hijo);
		if(ms.startsWith("logout")){
			hijo.stop();
		}
	}
	
	public void enviarMensaje(String ms,ClienteHilo hijo){
		for(int i=0;i<listaClientes.size();i++){
			if(!hijo.equals(listaClientes.get(i))){
				listaClientes.get(i).mensaje(ms);
			}
		}
	}
	
}
