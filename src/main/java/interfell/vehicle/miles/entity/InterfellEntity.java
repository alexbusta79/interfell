package interfell.vehicle.miles.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Interfell")
public class InterfellEntity  {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column(name="county_fips", nullable=false)
    private Integer condado;	

	@Column(name="county_name", nullable=false)
    private String nombreDelCondado;
     
    @Column(name="date", nullable=false)
    private Date date;
    
    @Column(name="percent_change_from_jan", nullable=false)
    private Double porcentajeDeCambioParaEnero;
     
    @Column(name="mean7_county_vmt",nullable=false)
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

    @Override
    public String toString() {
        return "InterfellEntity [id=" + this.id + ", nombre del condado=" + this.nombreDelCondado + 
                ", porcentaje=" + this.porcentajeDeCambioParaEnero   + "]";
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
}
