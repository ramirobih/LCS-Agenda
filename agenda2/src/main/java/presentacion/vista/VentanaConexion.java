package presentacion.vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import modelo.Agenda;
//import dto.ConexionDTO;
import persistencia.conexion.Conexion;
import presentacion.controlador.Controlador;

public class VentanaConexion implements ActionListener {
	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JPanel contentPane;
	private JTextField txtServidor;
	private JTextField txtPuerto;
	private JTextField txtUsuario;
	private JTextField txtContraseña;
	private JTextField txtBaseDatos;
	private JButton btnIniciarServidor;
	private Controlador controlador;
	private JPanel panel;

	public VentanaConexion() {
		super();
		//this.controlador = controlador;
		inicializar();
		this.getBtnIniciarServidor().addActionListener(this);

		this.getFrame().addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				// Se habilita abrir la ventana de agregar persona luego de
				// que la misma se cierra
				
			}
		});

		this.frame.setVisible(true);
	}

	private void inicializar() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 350, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setBounds(10, 11, 340, 340);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNombre = new JLabel("Servidor");
		lblNombre.setBounds(10, 11, 113, 14);
		panel.add(lblNombre);

		JLabel lblPuerto = new JLabel("Puerto");
		lblPuerto.setBounds(10, 52, 113, 14);
		panel.add(lblPuerto);

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(10, 93, 113, 14);
		panel.add(lblUsuario);

		JLabel lblClave = new JLabel("Clave");
		lblClave.setBounds(10, 134, 113, 14);
		panel.add(lblClave);

		JLabel lblBD = new JLabel("Base de Datos");
		lblBD.setBounds(10, 175, 113, 14);
		panel.add(lblBD);

		txtServidor = new JTextField();
		txtServidor.setBounds(133, 8, 164, 20);
		panel.add(txtServidor);
		txtServidor.setColumns(10);

		txtPuerto = new JTextField();
		txtPuerto.setBounds(133, 49, 164, 20);
		panel.add(txtPuerto);
		txtPuerto.setColumns(10);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(133, 90, 164, 20);
		panel.add(txtUsuario);
		txtServidor.setColumns(10);

		txtContraseña = new JTextField();
		txtContraseña.setBounds(133, 131, 164, 20);
		panel.add(txtContraseña);
		txtContraseña.setColumns(10);

		txtBaseDatos = new JTextField();
		txtBaseDatos.setBounds(133, 172, 164, 20);
		panel.add(txtBaseDatos);
		txtBaseDatos.setColumns(10);

		btnIniciarServidor = new JButton("Actualizar");
		btnIniciarServidor.addActionListener(this.controlador);
		btnIniciarServidor.setBounds(90, 250, 100, 23);
		panel.add(btnIniciarServidor);

		this.frame.setTitle("Configurar conexión");

	}

	public JTextField getTxtServidor() {
		return txtServidor;
	}

//	public static long getSerialversionuid() {
//		return serialVersionUID;
//	}

	public JTextField getTxtPuerto() {
		return txtPuerto;
	}

	public JTextField getTxtUsuario() {
		return txtUsuario;
	}

	public JTextField getTxtContraseña() {
		return txtContraseña;
	}

	public JTextField getTxtBaseDatos() {
		return txtBaseDatos;
	}

	public JButton getBtnIniciarServidor() {
		return btnIniciarServidor;
	}

	public JFrame getFrame() {
		return this.frame;
	}

	public void show() {
		this.frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.getBtnIniciarServidor()) {
			actionBtnActualizarConexion();
		}
	}

	private void actionBtnActualizarConexion()
	{
		
		Conexion conexion = new Conexion(getTxtServidor().getText(),getTxtPuerto().getText(),getTxtBaseDatos().getText(),getTxtUsuario().getText(),getTxtContraseña().getText());
		Vista vista = new Vista();
		Agenda modelo = new Agenda();
		Controlador controlador = new Controlador(vista, modelo);
		controlador.inicializar();
		frame.dispose();
	}
			
			
		
}
