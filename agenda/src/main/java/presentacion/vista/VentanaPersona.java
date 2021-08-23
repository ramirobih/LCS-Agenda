package presentacion.vista;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import dto.TipoContactoEnum;

public class VentanaPersona extends JFrame 
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textTelefono;
	private JTextField textEmail;
	private TipoContactoEnum tipoContacto;
	private String tipes = "";
	
	
	private JButton btnAgregarPersona;
	private static VentanaPersona INSTANCE;
	private JTextField textCalle;
	private JTextField textAltura;
	private JTextField textPiso;
	private JTextField textNumDepto;
	private JTextField textCumple;
	
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
		setBounds(100, 100, 551, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_Persona = new JPanel();
		panel_Persona.setBounds(10, 0, 492, 156);
		contentPane.add(panel_Persona);
		panel_Persona.setLayout(null);
		
		JLabel lblNombreYApellido = new JLabel("Nombre y Apellido");
		lblNombreYApellido.setBounds(10, 11, 164, 14);
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
		textEmail.setBounds(245, 57, 220, 20);
		panel_Persona.add(textEmail);
		textEmail.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 59, 113, 14);
		panel_Persona.add(lblEmail);
		
		JLabel lblTipoDeContacto = new JLabel("Tipo de Contacto");
		lblTipoDeContacto.setBounds(10, 118, 139, 14);
		panel_Persona.add(lblTipoDeContacto);
		
		textCumple = new JTextField();
		textCumple.setBounds(245, 83, 220, 20);
		panel_Persona.add(textCumple);
		textCumple.setColumns(10);
		
		JLabel lblCumple = new JLabel("Fecha de Cumpleaños");
		lblCumple.setBounds(10, 85, 164, 14);
		panel_Persona.add(lblCumple);
		
		JComboBox comboBox_tipoContacto = new JComboBox(tipoContacto.values());
		comboBox_tipoContacto.setEditable(true);
		comboBox_tipoContacto.setBounds(245, 113, 220, 20);
		tipes = comboBox_tipoContacto.getSelectedItem().toString();
		panel_Persona.add(comboBox_tipoContacto);
		
		btnAgregarPersona = new JButton("Guardar");
		btnAgregarPersona.setBounds(206, 354, 117, 23);
		contentPane.add(btnAgregarPersona);
		
		JPanel panel_Domicilio = new JPanel();
		panel_Domicilio.setLayout(null);
		panel_Domicilio.setBounds(10, 164, 492, 178);
		contentPane.add(panel_Domicilio);
		
		JLabel lblCalle = new JLabel("Calle");
		lblCalle.setBounds(12, 40, 39, 14);
		panel_Domicilio.add(lblCalle);
		
		JLabel lblAltura = new JLabel("Altura");
		lblAltura.setBounds(12, 66, 65, 14);
		panel_Domicilio.add(lblAltura);
		
		textCalle = new JTextField();
		textCalle.setColumns(10);
		textCalle.setBounds(116, 38, 309, 20);
		panel_Domicilio.add(textCalle);
		
		textAltura = new JTextField();
		textAltura.setColumns(10);
		textAltura.setBounds(116, 64, 65, 20);
		panel_Domicilio.add(textAltura);
		
		textPiso = new JTextField();
		textPiso.setColumns(10);
		textPiso.setBounds(242, 64, 49, 20);
		panel_Domicilio.add(textPiso);
		
		JLabel lblPiso = new JLabel("Piso");
		lblPiso.setBounds(193, 66, 74, 14);
		panel_Domicilio.add(lblPiso);
		
		JLabel lblNmeroDepartamento = new JLabel("Dpto");
		lblNmeroDepartamento.setBounds(319, 66, 65, 14);
		panel_Domicilio.add(lblNmeroDepartamento);
		
		textNumDepto = new JTextField();
		textNumDepto.setColumns(10);
		textNumDepto.setBounds(376, 64, 49, 20);
		panel_Domicilio.add(textNumDepto);
		
		JLabel lblPais = new JLabel("Pais");
		lblPais.setBounds(12, 97, 70, 15);
		panel_Domicilio.add(lblPais);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(116, 92, 309, 24);
		panel_Domicilio.add(comboBox_1);
		
		JLabel lblProvincia = new JLabel("Provincia");
		lblProvincia.setBounds(12, 124, 70, 15);
		panel_Domicilio.add(lblProvincia);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(116, 119, 309, 24);
		panel_Domicilio.add(comboBox_2);
		
		JLabel lblLocalidad = new JLabel("Localidad");
		lblLocalidad.setBounds(12, 151, 70, 15);
		panel_Domicilio.add(lblLocalidad);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(116, 146, 309, 24);
		panel_Domicilio.add(comboBox_3);
		
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

	public TipoContactoEnum getTipoContacto() {
		return tipoContacto;
	}

	public void setTipoContacto(TipoContactoEnum tipoContacto) {
		this.tipoContacto = tipoContacto;
	}

	public String getTipes() {
		return tipes;
	}



	

	
}