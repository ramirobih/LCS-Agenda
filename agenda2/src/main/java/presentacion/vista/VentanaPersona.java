package presentacion.vista;


import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.jdatepicker.impl.JDatePickerImpl;

import dto.LocalidadDTO;
import dto.PersonaDTO;
import dto.TipoContactoDTO;
import dto.TipoDomicilioDTO;
import presentacion.controlador.Controlador;
import util.Fechas;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class VentanaPersona extends JFrame 
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int idPersona;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JTextField txtEmail;
	private JDatePickerImpl datePicker;
	private JPanel pnlDatePicker;
	private JTextField txtCalle;
	private JSpinner txtAltura;
	private JSpinner txtPiso;
	private JTextField txtDpto;
	private ComboBoxPais cmbPais;
	private ComboBoxLocalidades cmbLocalidades;
	private ComboBoxProvincias cmbProvincias;
	private ComboBoxTiposContacto cmbTiposContacto;
	private ComboBoxTiposDomicilio cmbTiposDomicilio;
	private JButton btnAgregarPersona;
	private JButton btnEditarPersona;
	private Controlador controlador;
	
	
	public VentanaPersona(Controlador controlador, String accion, PersonaDTO persona) 
	{
		super();
		this.controlador = controlador;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 350, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 340, 520);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNombreYApellido = new JLabel("Nombre y apellido");
		lblNombreYApellido.setBounds(10, 11, 113, 14);
		panel.add(lblNombreYApellido);
		
		JLabel lblTelfono = new JLabel("Tel\u00E9fono");
		lblTelfono.setBounds(10, 52, 113, 14);
		panel.add(lblTelfono);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 93, 113, 14);
		panel.add(lblEmail);
		
		JLabel lblFechaNacimiento = new JLabel("Cumplea\u00f1os");
		lblFechaNacimiento.setBounds(10, 134, 113, 14);
		panel.add(lblFechaNacimiento);
		
		JLabel lblCalle = new JLabel("Calle");
		lblCalle.setBounds(10, 170, 113, 14);
		panel.add(lblCalle);
		
		JLabel lblAltura = new JLabel("Altura");
		lblAltura.setBounds(10, 211, 113, 14);
		panel.add(lblAltura);
		
		JLabel lblPiso = new JLabel("Piso");
		lblPiso.setBounds(10, 252, 113, 14);
		panel.add(lblPiso);
		
		JLabel lblDpto = new JLabel("Depto");
		lblDpto.setBounds(10, 293, 113, 14);
		panel.add(lblDpto);
		
		JLabel lblPais = new JLabel("Pais");
		lblPais.setBounds(10, 320, 113, 14);
		panel.add(lblPais);
		
		JLabel lblProvincia = new JLabel("Provincia");
		lblProvincia.setBounds(10, 350, 113, 14);
		panel.add(lblProvincia);
		
		JLabel lblLocalidad = new JLabel("Localidad");
		lblLocalidad.setBounds(10, 380, 113, 14);
		panel.add(lblLocalidad);
		
		JLabel lblTipoContacto = new JLabel("Tipo de Contacto");
		lblTipoContacto.setBounds(10, 410, 113, 14);
		panel.add(lblTipoContacto);
		
		JLabel lblTipoDomicilio = new JLabel("Tipo de Domicilio");
		lblTipoDomicilio.setBounds(10, 430, 113, 14);
		panel.add(lblTipoDomicilio);
		
		idPersona = 0;
		
		txtNombre = new JTextField();
		txtNombre.setBounds(133, 8, 164, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(133, 49, 164, 20);
		panel.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(133, 90, 164, 20);
		panel.add(txtEmail);
		txtEmail.setColumns(10);
		
		pnlDatePicker = new JPanel();
		pnlDatePicker.setBounds(90, 125, 250, 40);
		panel.add(pnlDatePicker);
		
		txtCalle = new JTextField();
		txtCalle.setBounds(133, 166, 164, 20);
		panel.add(txtCalle);
		txtCalle.setColumns(10);
		
		txtAltura = new JSpinner();
		txtAltura.setBounds(133, 207, 164, 20);
		panel.add(txtAltura);
		
		txtPiso = new JSpinner();
		txtPiso.setBounds(133, 248, 164, 20);
		panel.add(txtPiso);
		
		txtDpto = new JTextField();
		txtDpto.setBounds(133, 289, 164, 20);
		panel.add(txtDpto);
		txtDpto.setColumns(10);
		
		cmbPais = new ComboBoxPais();
		cmbPais.setBounds(133, 320, 164, 20);
		panel.add(cmbPais);
		
		
		cmbLocalidades = new ComboBoxLocalidades("");
		cmbProvincias = new ComboBoxProvincias();
		cmbProvincias.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				panel.remove(cmbLocalidades);
				cmbLocalidades = new ComboBoxLocalidades((String)cmbProvincias.getSelectedItem());
				cmbLocalidades.setBounds(133, 380, 164, 20);
				panel.add(cmbLocalidades);
			}
		});
		cmbProvincias.setBounds(133, 350, 164, 20);
		panel.add(cmbProvincias);
		
		

		
		cmbTiposContacto = new ComboBoxTiposContacto();
		cmbTiposContacto.setBounds(133, 410, 164, 20);
		panel.add(cmbTiposContacto);
		
		cmbTiposDomicilio = new ComboBoxTiposDomicilio();
		cmbTiposDomicilio.setBounds(133, 430, 164, 20);
		panel.add(cmbTiposDomicilio);
		
		if(accion == "Agregar")
			inicializarAgregar(panel);
		else inicializarEditar(panel,persona);
		
		this.setVisible(true);
	}
	
	private void inicializarAgregar(JPanel panel)
	{	
		this.setTitle("Agregar Persona");
		
		datePicker = VentanaCalendario.getPickerToday();
		pnlDatePicker.add(datePicker);
		
		btnAgregarPersona = new JButton("Agregar");
		btnAgregarPersona.addActionListener(this.controlador);
		btnAgregarPersona.setBounds(208, 450, 89, 23);
		
		panel.add(btnAgregarPersona);
	}
	
	private void inicializarEditar(JPanel panel, PersonaDTO persona)
	{
		this.setTitle("Editar Persona");
		
		idPersona = persona.getIdPersona();
		txtNombre.setText(persona.getNombre());
		txtTelefono.setText(persona.getTelefono());
		txtEmail.setText(persona.getEmail());
		datePicker = VentanaCalendario.getPickerDate(persona.getFechaNacimiento());
		pnlDatePicker.add(datePicker);
		txtCalle.setText(persona.getCalle());
		txtAltura.setValue(persona.getAltura());
		txtPiso.setValue(persona.getPiso());
		txtDpto.setText(persona.getDepto());
		cmbPais.setSelectedItem(persona.getLocalidad().getPais());
		cmbLocalidades.setSelectedItem(persona.getLocalidad());
		cmbProvincias.setSelectedItem(persona.getLocalidad().getProvincia());
		cmbTiposContacto.setSelectedItem(persona.getTipoContacto());
		cmbTiposDomicilio.setSelectedItem(persona.getTipoDomicilio());
		
		btnEditarPersona = new JButton("Actualizar");
		btnEditarPersona.addActionListener(this.controlador);
		btnEditarPersona.setBounds(208, 450, 95, 23);
		panel.add(btnEditarPersona);
	}
	
	public int getIdPersona()
	{
		return idPersona;
	}
	
	public JTextField getTxtNombre() 
	{
		return txtNombre;
	}

	public JTextField getTxtTelefono() 
	{
		return txtTelefono;
	}
	
	public JTextField getTxtEmail() 
	{
		return txtEmail;
	}
	
	public JTextField getTxtCalle() 
	{
		return txtCalle;
	}

	public JSpinner getTxtAltura() 
	{
		return txtAltura;
	}

	public JSpinner getTxtPiso() 
	{
		return txtPiso;
	}

	public JTextField getTxtDpto() 
	{
		return txtDpto;
	}

	public JButton getBtnAgregarPersona() 
	{
		return btnAgregarPersona;
	}
	
	public JButton getBtnEditarPersona() 
	{
		return btnEditarPersona;
	}
	
	public PersonaDTO getDatosPersona()
	{
		String fecha = datePicker.getJFormattedTextField().getText().trim();
		Calendar cal = Fechas.String_a_Fecha(fecha);
		LocalidadDTO localidad = cmbLocalidades.getLocalidad();
		TipoContactoDTO tipoContacto = cmbTiposContacto.getTipoContacto();
		TipoDomicilioDTO tipoDomicilio = cmbTiposDomicilio.getTipoDomicilio();
		PersonaDTO persona = new PersonaDTO
				(idPersona,this.getTxtNombre().getText(), this.getTxtTelefono().getText(),this.getTxtEmail().getText(),cal,
				this.getTxtCalle().getText(),(Integer) this.getTxtAltura().getValue(),(Integer) this.getTxtPiso().getValue(),
				this.getTxtDpto().getText(),localidad,tipoContacto, tipoDomicilio);
		return persona;
	}
	
}

