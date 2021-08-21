package dto;

public class DomicilioDTO 
{
	private int idDomicilio;
	private String calle;
	private String altura;
	private String piso;
	private String numDepto;
	
	
	public DomicilioDTO(int idDomicilio, String calle, String altura, String piso, String numDepto) {

		this.idDomicilio = idDomicilio;
		this.calle = calle;
		this.altura = altura;
		this.piso = piso;
		this.numDepto = numDepto;
	}


	public int getIdDomicilio() {
		return idDomicilio;
	}


	public void setIdDomicilio(int idDomicilio) {
		this.idDomicilio = idDomicilio;
	}


	public String getCalle() {
		return calle;
	}


	public void setCalle(String calle) {
		this.calle = calle;
	}


	public String getAltura() {
		return altura;
	}


	public void setAltura(String altura) {
		this.altura = altura;
	}


	public String getPiso() {
		return piso;
	}


	public void setPiso(String piso) {
		this.piso = piso;
	}


	public String getNumDepto() {
		return numDepto;
	}


	public void setNumDepto(String numDepto) {
		this.numDepto = numDepto;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	}

	