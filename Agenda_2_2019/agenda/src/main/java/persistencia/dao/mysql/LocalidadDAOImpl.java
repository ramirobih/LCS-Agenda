package persistencia.dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.LocalidadDTO;
import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.LocalidadDAO;

public class LocalidadDAOImpl implements LocalidadDAO
{
	
	private static final String insert = "INSERT INTO localidades(idLocalidad, nombre) VALUES(?, ?)";
	private static final String update = "UPDATE localidades SET nombre = ? WHERE idLocalidad = ?";
	private static final String delete = "DELETE FROM localidades WHERE idLocalidad = ?";
	private static final String readall = "SELECT * FROM localidades";
	private static final String getById = "SELECT * FROM localidades WHERE idLocalidad = ?";
	private static final Conexion conexion = Conexion.getConexion();
	
	public boolean update(LocalidadDTO localidad_a_editar) 
	{
		PreparedStatement statement;
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(update);
			statement.setInt(2, localidad_a_editar.getIdLocalidad());
			statement.setString(1, localidad_a_editar.getNombre());
			
			if(statement.executeUpdate() > 0) //Si se ejecutó devuelvo true
				return true;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally //Se ejecuta siempre
		{
			conexion.cerrarConexion();
		}
		return false;
	}

	
	public boolean insert(LocalidadDTO localidad) 
	{
		PreparedStatement statement;
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(insert);
			statement.setInt(1, localidad.getIdLocalidad());
			statement.setString(2, localidad.getNombre());
			
			if(statement.executeUpdate() > 0) //Si se ejecutó devuelvo true
				return true;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally //Se ejecuta siempre
		{
			conexion.cerrarConexion();
		}
		return false;
	}

	
	public boolean delete(LocalidadDTO localidad_a_eliminar) 
	{
		PreparedStatement statement;
		int chequeoUpdate=0;
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(delete);
			statement.setInt(1, localidad_a_eliminar.getIdLocalidad());
			chequeoUpdate = statement.executeUpdate();
			if(chequeoUpdate > 0) //Si se ejecut� devuelvo true
				return true;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally //Se ejecuta siempre
		{
			conexion.cerrarConexion();
		}
		return false;
	}

	
	public LocalidadDTO getById(LocalidadDTO localidad_a_obtener) 
	{
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		LocalidadDTO localidad = null;
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(getById);
			statement.setInt(1, localidad_a_obtener.getIdLocalidad());
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				localidad = new LocalidadDTO(resultSet.getInt("idLocalidad"),resultSet.getString("nombre"), resultSet.getString("provincia"), resultSet.getString("pais"));
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally //Se ejecuta siempre
		{
			conexion.cerrarConexion();
		}
		return localidad;
	}

	public List<LocalidadDTO> readAll() 
	{
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<LocalidadDTO> localidades = new ArrayList<LocalidadDTO>();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			
			while(resultSet.next())
			{
			
					LocalidadDTO localidad = new LocalidadDTO(resultSet.getInt("idLocalidad"),resultSet.getString("nombre"), resultSet.getString("provincia"), resultSet.getString("pais"));;
					localidades.add(localidad);
				
				
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally //Se ejecuta siempre
		{
			conexion.cerrarConexion();
		}
		return localidades;
	}



public List<LocalidadDTO> readAllProvincia(Object provincia) 
{
	PreparedStatement statement;
	ResultSet resultSet; //Guarda el resultado de la query
	ArrayList<LocalidadDTO> localidades = new ArrayList<LocalidadDTO>();
	try 
	{
		statement = conexion.getSQLConexion().prepareStatement(readall);
		resultSet = statement.executeQuery();
		
		while(resultSet.next())
		{
			if(resultSet.getString("provincia").equals(provincia)) {
				LocalidadDTO localidad = new LocalidadDTO(resultSet.getInt("idLocalidad"),resultSet.getString("nombre"), resultSet.getString("provincia"), resultSet.getString("pais"));;
				localidades.add(localidad);
			}
			
		}
	} 
	catch (SQLException e) 
	{
		e.printStackTrace();
	}
	finally //Se ejecuta siempre
	{
		conexion.cerrarConexion();
	}
	return localidades;
}

}
