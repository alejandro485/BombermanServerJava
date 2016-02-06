package Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import Controlador.ControladorActionListener;

public class EntradaPuerto extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField txtPuerto;

	public EntradaPuerto(ControladorActionListener CAL) {
		setTitle("Bomberman Server");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 246, 140);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtPuerto = new JTextField();
		txtPuerto.setBounds(10, 36, 210, 20);
		contentPane.add(txtPuerto);
		txtPuerto.setColumns(10);
		
		JLabel lblDigiteElPuerto = new JLabel("Digite el puerto que desea usar");
		lblDigiteElPuerto.setBounds(10, 11, 210, 14);
		contentPane.add(lblDigiteElPuerto);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(10, 67, 89, 23);
		btnAceptar.setActionCommand("aceptar");
		btnAceptar.addActionListener(CAL);
		contentPane.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(131, 67, 89, 23);
		btnCancelar.setActionCommand("cancelar");
		btnCancelar.addActionListener(CAL);
		contentPane.add(btnCancelar);
	}

	public JTextField getTxtPuerto() {
		return txtPuerto;
	}

}
