package modelo;

import java.util.List;

import dto.DomicilioDTO;
import dto.PersonaDTO;
import persistencia.dao.interfaz.DAOAbstractFactory;
import persistencia.dao.interfaz.PersonaDAO;


public class Agenda 
{
	private PersonaDAO persona;	
	
	public Agenda(DAOAbstractFactory metodo_persistencia)
	{
		this.persona = metodo_persistencia.createPersonaDAO();
	}
	
	public void agregarPersona(PersonaDTO nuevaPersona, DomicilioDTO domicilio)
	{
		this.persona.insert(nuevaPersona, domicilio);
	}

	public void borrarPersona(PersonaDTO persona_a_eliminar, DomicilioDTO domicilio_a_eliminar) 
	{
		this.persona.delete(persona_a_eliminar, domicilio_a_eliminar);
	}
	
	public List<PersonaDTO> obtenerPersonas()
	{
		return this.persona.readAll();		
	}
	
}
