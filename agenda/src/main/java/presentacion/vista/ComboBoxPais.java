package presentacion.vista;


import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import dto.LocalidadDTO;
import persistencia.dao.mysql.LocalidadDAOImpl;

public class ComboBoxPais extends JComboBox<String>
{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ComboBoxPais()
	{
		super();
		DefaultComboBoxModel<String> value = new DefaultComboBoxModel<String>();
		this.setModel(value);
		value.addElement("");
		for(LocalidadDTO localidad : new LocalidadDAOImpl().readAll())
		{
			if(value.getIndexOf(localidad.getPais()) == -1) {
				value.addElement(localidad.getPais());
			}
			
		}
	}
	
	
	public LocalidadDTO getLocalidad()
	{
		return (LocalidadDTO) this.getSelectedItem();
	}
	
}
