package presentacion.vista;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class VentanaPersona extends JFrame 
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textTelefono;
	private JTextField textEmail;
	
	
	private JButton btnAgregarPersona;
	private static VentanaPersona INSTANCE;
	private JTextField textCalle;
	private JTextField textAltura;
	private JTextField textPiso;
	private JTextField textNumDepto;
	private JTextField textCumple;
	private JTextField textTipoDeContacto;
	
	public static VentanaPersona getInstance()
	{
		if(INSTANCE == null)
		{
			INSTANCE = new VentanaPersona(); 	
			return new VentanaPersona();
		}
		else
			return INSTANCE;
	}

	private VentanaPersona() 
	{
		super();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 545, 278);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_Persona = new JPanel();
		panel_Persona.setBounds(10, 11, 492, 144);
		contentPane.add(panel_Persona);
		panel_Persona.setLayout(null);
		
		JLabel lblNombreYApellido = new JLabel("Nombre y apellido");
		lblNombreYApellido.setBounds(10, 11, 113, 14);
		panel_Persona.add(lblNombreYApellido);
		
		JLabel lblTelfono = new JLabel("Teléfono");
		lblTelfono.setBounds(10, 34, 113, 14);
		panel_Persona.add(lblTelfono);
		
		textNombre = new JTextField();
		textNombre.setBounds(245, 8, 220, 20);
		panel_Persona.add(textNombre);
		textNombre.setColumns(10);
		
		textTelefono = new JTextField();
		textTelefono.setBounds(245, 31, 220, 20);
		panel_Persona.add(textTelefono);
		textTelefono.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setBounds(245, 55, 220, 20);
		panel_Persona.add(textEmail);
		textEmail.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 59, 113, 14);
		panel_Persona.add(lblEmail);
		
		JLabel lblTipoDeContacto = new JLabel("Tipo de contacto");
		lblTipoDeContacto.setBounds(10, 113, 113, 14);
		panel_Persona.add(lblTipoDeContacto);
		
		textTipoDeContacto = new JTextField();
		textTipoDeContacto.setBounds(245, 110, 220, 20);
		panel_Persona.add(textTipoDeContacto);
		textTipoDeContacto.setColumns(10);
		
		textCumple = new JTextField();
		textCumple.setBounds(245, 79, 220, 20);
		panel_Persona.add(textCumple);
		textCumple.setColumns(10);
		
		JLabel lblCumple = new JLabel("Fecha de cumpleaños");
		lblCumple.setBounds(10, 88, 113, 14);
		panel_Persona.add(lblCumple);
		
		btnAgregarPersona = new JButton("Agregar");
		btnAgregarPersona.setBounds(430, 213, 89, 23);
		contentPane.add(btnAgregarPersona);
		
		JPanel panel_Domicilio = new JPanel();
		panel_Domicilio.setLayout(null);
		panel_Domicilio.setBounds(10, 160, 492, 42);
		contentPane.add(panel_Domicilio);
		
		JLabel lblCalle = new JLabel("Calle");
		lblCalle.setBounds(10, 11, 39, 14);
		panel_Domicilio.add(lblCalle);
		
		JLabel lblAltura = new JLabel("Altura");
		lblAltura.setBounds(157, 11, 39, 14);
		panel_Domicilio.add(lblAltura);
		
		textCalle = new JTextField();
		textCalle.setColumns(10);
		textCalle.setBounds(41, 8, 96, 20);
		panel_Domicilio.add(textCalle);
		
		textAltura = new JTextField();
		textAltura.setColumns(10);
		textAltura.setBounds(195, 8, 39, 20);
		panel_Domicilio.add(textAltura);
		
		textPiso = new JTextField();
		textPiso.setColumns(10);
		textPiso.setBounds(273, 8, 39, 20);
		panel_Domicilio.add(textPiso);
		
		JLabel lblPiso = new JLabel("Piso");
		lblPiso.setBounds(244, 11, 19, 14);
		panel_Domicilio.add(lblPiso);
		
		JLabel lblNmeroDepartamento = new JLabel("Número departamento");
		lblNmeroDepartamento.setBounds(322, 11, 113, 14);
		panel_Domicilio.add(lblNmeroDepartamento);
		
		textNumDepto = new JTextField();
		textNumDepto.setColumns(10);
		textNumDepto.setBounds(445, 8, 39, 20);
		panel_Domicilio.add(textNumDepto);
		
		this.setVisible(false);
	}
	
	public void mostrarVentana()
	{
		this.setVisible(true);
	}
	
	public JTextField getTextNombre() 
	{
		return textNombre;
	}

	public JTextField getTextTelefono() 
	{
		return textTelefono;
	}

	public JButton getBtnAgregarPersona() 
	{
		return btnAgregarPersona;
	}

	public void cerrar()
	{
		this.textNombre.setText(null);
		this.textTelefono.setText(null);
		this.dispose();
	}

	
	public JTextField getTextEmail() 
	{
		return textEmail;
	}
	
	public JTextField getTextCalle() 
	{
		return textCalle;
	}

	public JTextField getTextAltura() 
	{
		return textAltura;
	}
	
	public JTextField getTextPiso() 
	{
		return textPiso;
	}
	
	public JTextField getTextNumDepto() 
	{
		return textNumDepto;
	}

	public JTextField getTextCumple() {
		return textCumple;
	}

	public void setTextCumple(JTextField textCumple) {
		this.textCumple = textCumple;
	}

	public JTextField getTextTipoContacto() {
		return textTipoDeContacto;
	}

	public void setTextTipoContacto(JTextField textTipoContacto) {
		this.textTipoDeContacto = textTipoContacto;
	}
}

