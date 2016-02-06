package Logica.Server;

import java.io.DataInputStream;
import java.io.PrintStream;
import java.net.Socket;

public class ClienteHilo extends Thread {
	private GrupoClientes padre;
	private Socket socket;
	private DataInputStream dis;
	private PrintStream ps;
	
	public ClienteHilo(GrupoClientes p,Socket s) {
		padre=p;
		socket=s;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void run() {
		try {
			dis=new DataInputStream(socket.getInputStream());
			ps=new PrintStream(socket.getOutputStream());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		while(socket!=null){
			String input;
			try {
				input=dis.readLine().trim();
				if(input!=null){
					padre.InterpretarMensaje(input, this);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	public void mensaje(String mensaje){
		ps.println(mensaje);
	}
	
	@Override
	public void finalize() throws Throwable {
		ps.close();
		dis.close();
		socket.close();
		socket=null;
	}
	
}
