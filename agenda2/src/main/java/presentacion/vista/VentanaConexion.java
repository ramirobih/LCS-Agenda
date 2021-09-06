package presentacion.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaConexion extends JFrame {

	private JPanel contentPane;
	private JTextField textUsuario;
	private JTextField textContraseña;
	private JTextField textHost;
	private JTextField textPuerto;
	private JButton btnEntrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaConexion frame = new VentanaConexion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaConexion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(10, 27, 70, 20);
		panel.add(lblUsuario);
		
		JLabel lblContraseña = new JLabel("Contrase\u00F1a:");
		lblContraseña.setBounds(10, 77, 70, 20);
		panel.add(lblContraseña);
		
		textUsuario = new JTextField();
		textUsuario.setBounds(90, 27, 290, 20);
		panel.add(textUsuario);
		textUsuario.setColumns(10);
		
		textContraseña = new JTextField();
		textContraseña.setBounds(90, 77, 290, 20);
		panel.add(textContraseña);
		textContraseña.setColumns(10);
		
		JLabel lblHost = new JLabel("Host: ");
		lblHost.setBounds(10, 121, 70, 20);
		panel.add(lblHost);
		
		textHost = new JTextField();
		textHost.setBounds(90, 121, 290, 20);
		panel.add(textHost);
		textHost.setColumns(10);
		
		JLabel lblPuerto = new JLabel("Puerto:");
		lblPuerto.setBounds(10, 165, 70, 20);
		panel.add(lblPuerto);
		
		textPuerto = new JTextField();
		textPuerto.setBounds(90, 165, 290, 20);
		panel.add(textPuerto);
		textPuerto.setColumns(10);
		
		btnEntrar = new JButton("Entrar");
		btnEntrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				//GUARDA EN ARCHIVO DATOS DE CONEXION
				//TESTEO CONEXION
				//CHEQUEO SI EXISTE DB
				//SI NO EXISTE CREO DB Y TABLAS
			}
		});
		btnEntrar.setBounds(180, 217, 89, 23);
		panel.add(btnEntrar);
	}
}
