package dto;

public class LocalidadDTO 
{
	private int idLocalidad;
	private String nombre;
	private String provincia;
	private String pais;
	public LocalidadDTO(int idLocalidad, String nombre, String provincia, String pais) 
	{
		this.idLocalidad = idLocalidad;
		this.nombre = nombre;
		this.pais = pais;
		this.provincia = provincia;
	}
	
	public int getIdLocalidad() 
	{
		return idLocalidad;
	}
	
	public void setIdLocalidad(int idLocalidad) 
	{
		this.idLocalidad = idLocalidad;
	}
	
	public String getNombre() 
	{
		return nombre;
	}
	
	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}
	
	public String toString()
    {
        return getNombre();
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idLocalidad;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LocalidadDTO other = (LocalidadDTO) obj;
		if (idLocalidad != other.idLocalidad)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
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
