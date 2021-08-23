package persistencia.dao.interfaz;

import java.util.List;

import dto.DomicilioDTO;

public interface DomicilioDAO 
{
	
	public boolean insert(DomicilioDTO domicilio);

	public boolean delete(DomicilioDTO domicilio_a_eliminar);
	
	public List<DomicilioDTO> readAll();
}
