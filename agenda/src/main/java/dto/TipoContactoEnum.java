package dto;

public enum TipoContactoEnum {
	
	
	AMIGO("Amigo"),
	TRABAJO("Trabajo"),
	FAMILIA("Familia");


	private final String tipo;
	
	private TipoContactoEnum(String tipo) {
		this.tipo = tipo;
	}
	

	public String getTipo() {
	      return tipo;
	   }
	
}
