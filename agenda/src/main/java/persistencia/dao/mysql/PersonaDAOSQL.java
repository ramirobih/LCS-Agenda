package persistencia.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.DomicilioDTO;
import dto.PersonaDTO;
import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.PersonaDAO;

public class PersonaDAOSQL implements PersonaDAO
{
	private static final String insert = "INSERT INTO persona(idPersona, Nombre, Telefono, Email, domicilioID, cumple, TipoDeContactoID) VALUES(?, ?, ?, ?, ?, ?, ?)";
	private static final String delete = "DELETE FROM persona WHERE idPersona = ?";
	//agregar borrado de domicilio al borrar una persona
	private static final String readall = "SELECT * FROM persona";
	//private static final String innerJoin = "SELECT * FROM persona INNER JOIN domicilio ON persona.idPersona = domicilio.idDomicilio";
		
	public boolean insert(PersonaDTO persona, DomicilioDTO domicilio)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		DomicilioDAOSQL dom = new DomicilioDAOSQL();

		try
		{
			//agregamos primero el domicilio
		
			if(dom.insert(domicilio)) {
		
			
			statement = conexion.prepareStatement(insert);
			statement.setInt(1, persona.getIdPersona());
			statement.setString(2, persona.getNombre());
			statement.setString(3, persona.getTelefono());
			statement.setString(4, persona.getEmail());
			statement.setInt(5, domicilio.getIdDomicilio());
			statement.setString(6, persona.getCumple());
			statement.setString(7, persona.getTipo());
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isInsertExitoso = true;
			}
		} }
		catch (SQLException e) 
		{
			e.printStackTrace();
			try {
				dom.delete(domicilio);
				conexion.rollback();				
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		return isInsertExitoso;
	}
	
	public boolean delete(PersonaDTO persona_a_eliminar, DomicilioDTO  domicilio_a_eliminar)
	{
		DomicilioDAOSQL dom = new DomicilioDAOSQL();
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try 
		{
			if(dom.delete(domicilio_a_eliminar))
			{
				statement = conexion.prepareStatement(delete);
				statement.setString(1, Integer.toString(persona_a_eliminar.getIdPersona()));
			
				if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isdeleteExitoso = true;
			}}} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return isdeleteExitoso;
	}
	
	public List<PersonaDTO> readAll()
	{
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<PersonaDTO> personas = new ArrayList<PersonaDTO>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
//			statement = conexion.getSQLConexion().prepareStatement(innerJoin);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				personas.add(getPersonaDTO(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return personas;
	}
	
	private PersonaDTO getPersonaDTO(ResultSet resultSet) throws SQLException
	{
		int id = resultSet.getInt("idPersona");
		String nombre = resultSet.getString("Nombre");
		String tel = resultSet.getString("Telefono");
		String mail = resultSet.getString("Email");
		int domID  = resultSet.getInt("domicilioID");
		String cumple = resultSet.getString("cumple");
		String tipo = resultSet.getString("tipoDeContactoID");
		
		//String dom = resultSet.getString("Domicilio");
		return new PersonaDTO(id, nombre, tel, mail, cumple, tipo, domID);
	}
}
