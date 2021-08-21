package persistencia.dao.interfaz;

import java.util.List;

import dto.DomicilioDTO;
import dto.PersonaDTO;

public interface PersonaDAO 
{
	
	public boolean insert(PersonaDTO persona, DomicilioDTO domicilio);

	public boolean delete(PersonaDTO persona_a_eliminar);
	
	public List<PersonaDTO> readAll();
}
