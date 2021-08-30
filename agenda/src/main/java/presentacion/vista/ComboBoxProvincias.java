package presentacion.vista;


import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import dto.LocalidadDTO;
import persistencia.dao.mysql.LocalidadDAOImpl;

public class ComboBoxProvincias extends JComboBox<String>
{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ComboBoxProvincias()
	{
		super();
		DefaultComboBoxModel<String> value = new DefaultComboBoxModel<String>();
		this.setModel(value);
		value.addElement("");
		for(LocalidadDTO localidad : new LocalidadDAOImpl().readAll())
		{
			if(value.getIndexOf(localidad.getProvincia()) == -1) {
				value.addElement(localidad.getProvincia());
			}
			
		}
	}
	
	
	public LocalidadDTO getLocalidad()
	{
		return (LocalidadDTO) this.getSelectedItem();
	}
	
}
