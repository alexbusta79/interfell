package interfell.vehicle.miles.dto;

import java.util.Date;

public class InterfellDTO {
	
    private Long id;
    private Integer condado;	
    private String nombreDelCondado;
    private Date date;
    private Double porcentajeDeCambioParaEnero;
    private Double mediaDelCondado;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Integer getCondado() {
		return condado;
	}
	public void setCondado(Integer condado) {
		this.condado = condado;
	}
	
	public String getNombreDelCondado() {
		return nombreDelCondado;
	}
	public void setNombreDelCondado(String nombreDelCondado) {
		this.nombreDelCondado = nombreDelCondado;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public Double getPorcentajeDeCambioParaEnero() {
		return porcentajeDeCambioParaEnero;
	}
	public void setPorcentajeDeCambioParaEnero(Double porcentajeDeCambioParaEnero) {
		this.porcentajeDeCambioParaEnero = porcentajeDeCambioParaEnero;
	}
	
	public Double getMediaDelCondado() {
		return mediaDelCondado;
	}
	public void setMediaDelCondado(Double mediaDelCondado) {
		this.mediaDelCondado = mediaDelCondado;
	}
    

//    @NotNull Ejemplos de Validacion 
//    private String password;
//    @NotBlank 
//    private String name;
//	  @Min(value = 18, message = "Age should not be less than 18")
    
}
