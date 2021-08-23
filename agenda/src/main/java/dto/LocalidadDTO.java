package dto;

public class LocalidadDTO 
{
	private int idLocalidad;
	private String nombre;
	private String provincia;
	private String pais;

	public LocalidadDTO(int idLocalidad, String nombre, String provincia, String pais) {
		this.idLocalidad = idLocalidad;
		this.nombre = nombre;
		this.provincia = provincia;
		this.pais = pais;
	
	}

	public int getIdLocalidad() {
		return idLocalidad;
	}

	public void setIdLocalidad(int idLocalidad) {
		this.idLocalidad = idLocalidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	

}