package persistencia.conexion;

import java.sql.Connection;
import java.sql.DriverManager;



public class Conexion
{
	public static Conexion instancia;
	private Connection conexion, conexion2;
	private static String servidor;
	private static String puerto;
	private static String baseDatos;
	private static String usuario;
	private static String clave;
	
	public Conexion()
	{
		try
		{	
			conexion2 = DriverManager.getConnection("jdbc:mysql://" + servidor + ":" + puerto + "/" + baseDatos, usuario, clave);
//			this.conexion = DriverManager.getConnection("jdbc:mysql://134.122.19.242:3346/agenda?useSSL=false","tpagenda","tpagenda_2021");
			//conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda","root","tonimax321");
			System.out.println("Conexion exitosa");
		}
		catch(Exception e)
		{
			System.out.println("Conexion fallida");
		}
	}
	
	
	public Conexion(String servidor, String puerto, String baseDatos, String usuario, String clave)
	{	
		
//		instancia = null;
//		conexion2 = null;
//		conexion = null;
		Conexion.servidor = servidor;
		Conexion.puerto = puerto;
		Conexion.baseDatos = baseDatos;
		Conexion.usuario = usuario;
		Conexion.clave = clave;
		try {
			conexion = DriverManager.getConnection("jdbc:mysql://" + servidor + ":" + puerto + "/" + baseDatos, usuario, clave);
			System.out.println("Conexion exitosa");
		
		} catch (Exception e) {
			System.out.println("Conexion fallida");
			
		}
		new Conexion();
		
	}
	
	public static Conexion getConexion()   
	{								
		if(instancia == null)
		{
		
				instancia = new Conexion();
			
		}
		return instancia;
	}

	public Connection getSQLConexion() 
	{
		return conexion2;
	}
	
	public void cerrarConexion()
	{
		instancia = null;
	}
}
