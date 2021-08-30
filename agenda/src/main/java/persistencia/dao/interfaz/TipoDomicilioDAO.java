package persistencia.dao.interfaz;

import java.util.List;

import dto.TipoDomicilioDTO;

public interface TipoDomicilioDAO 
{
	public boolean update(TipoDomicilioDTO tipoDomicilio_a_editar);
	
	public boolean insert(TipoDomicilioDTO tipoDomicilio);

	public boolean delete(TipoDomicilioDTO tipoDomicilio_a_eliminar);
	
	public TipoDomicilioDTO getById(TipoDomicilioDTO tipoDomicilio_a_obtener);
	
	public List<TipoDomicilioDTO> readAll();
}