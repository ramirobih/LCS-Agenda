package presentacion.vista;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;


import dto.TipoDomicilioDTO;
import persistencia.dao.mysql.TipoDomicilioDAOImpl;

public class ComboBoxTiposDomicilio extends JComboBox<TipoDomicilioDTO> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ComboBoxTiposDomicilio() 
	{	
		super();
		DefaultComboBoxModel<TipoDomicilioDTO> value = new DefaultComboBoxModel<TipoDomicilioDTO>();
		this.setModel(value);
		for(TipoDomicilioDTO tipoDomicilio : new TipoDomicilioDAOImpl().readAll())
		{
			value.addElement(tipoDomicilio);
		}
		
	}
	
	public TipoDomicilioDTO getTipoDomicilio()
	{
		return (TipoDomicilioDTO) this.getSelectedItem();
	}

}
