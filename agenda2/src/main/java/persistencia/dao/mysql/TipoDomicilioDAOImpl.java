package persistencia.dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.TipoDomicilioDTO;
import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.TipoDomicilioDAO;

public class TipoDomicilioDAOImpl implements TipoDomicilioDAO
{
	private static final String insert = "INSERT INTO tiposDomicilio (idTipoDomicilio, nombre) VALUES(?, ?)";
	private static final String update = "UPDATE tiposDomicilio SET nombre = ? WHERE idTipoDomicilio = ?";
	private static final String delete = "DELETE FROM tiposDomicilio WHERE idTipoDomicilio = ?";
	private static final String readall = "SELECT * FROM tiposDomicilio";
	private static final String getById = "SELECT * FROM tiposDomicilio WHERE idTipoDomicilio = ?";
	private static final Conexion conexion = Conexion.getConexion();
	
	public boolean update(TipoDomicilioDTO tipoDomicilio_a_editar) 
	{
		PreparedStatement statement;
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(update);
			statement.setInt(2, tipoDomicilio_a_editar.getIdTipoDomicilio());
			statement.setString(1, tipoDomicilio_a_editar.getNombre());
			
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

	public boolean insert(TipoDomicilioDTO tipoDomicilio) 
	{
		PreparedStatement statement;
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(insert);
			statement.setInt(1, tipoDomicilio.getIdTipoDomicilio());
			statement.setString(2, tipoDomicilio.getNombre());
			
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

	@Override
	public boolean delete(TipoDomicilioDTO tipoDomicilio_a_eliminar) 
	{
		PreparedStatement statement;
		int chequeoUpdate=0;
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(delete);
			statement.setInt(1, tipoDomicilio_a_eliminar.getIdTipoDomicilio());
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

	public TipoDomicilioDTO getById(TipoDomicilioDTO tipoDomicilio_a_obtener)
	{
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		TipoDomicilioDTO tipoDomicilio = null;
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(getById);
			statement.setInt(1, tipoDomicilio_a_obtener.getIdTipoDomicilio());
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				tipoDomicilio = new TipoDomicilioDTO(resultSet.getInt("idTipoDomicilio"),resultSet.getString("nombre"));
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
		return tipoDomicilio;
	}

	@Override
	public List<TipoDomicilioDTO> readAll() 
	{
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<TipoDomicilioDTO> tipoDomicilios = new ArrayList<TipoDomicilioDTO>();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			
			while(resultSet.next())
			{
				TipoDomicilioDTO tipoDomicilio = new TipoDomicilioDTO(resultSet.getInt("idTipoDomicilio"),resultSet.getString("nombre"));
				tipoDomicilios.add(tipoDomicilio);
				System.out.println(tipoDomicilio);
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
		return tipoDomicilios;
		
	}

}
