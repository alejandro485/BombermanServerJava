package Logica.Server;

import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Server extends Thread{
	private ServerSocket server;
	private GrupoClientes grupo;
	private int puerto;
	
	public Server(int puerto) {
		try {
			server=new ServerSocket(puerto);
			this.puerto=puerto;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		grupo=new GrupoClientes();
		grupo.start();
		this.start();
	}
	
	public void run() {
		while(server!=null){
			System.out.println("Conectado a puerto "+puerto);
			JOptionPane.showMessageDialog(null,"Conectado a puerto "+puerto);
			Socket temporal;
			try {
				temporal=server.accept();
				System.out.println("Nuevo cliente conectado");
				grupo.agregarCliente(temporal);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	public void finalize(){
		try {
			server.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		server=null;
	}
}
