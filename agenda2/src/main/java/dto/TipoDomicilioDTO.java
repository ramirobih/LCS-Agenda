package dto;

public class TipoDomicilioDTO {
	private int idTipoDomicilio;
	private String nombre;
	
	public TipoDomicilioDTO(int idTipoDomicilio, String nombre) 
	{
		this.idTipoDomicilio = idTipoDomicilio;
		this.nombre = nombre;
	}

	public int getIdTipoDomicilio() {
		return idTipoDomicilio;
	}

	public void setIdTipoDomicilio(int idTipoDomicilio) {
		this.idTipoDomicilio = idTipoDomicilio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String toString()
	{
		return this.getNombre();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idTipoDomicilio;
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
		TipoDomicilioDTO other = (TipoDomicilioDTO) obj;
		if (idTipoDomicilio != other.idTipoDomicilio)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

}
