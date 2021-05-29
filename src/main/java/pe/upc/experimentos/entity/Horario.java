package pe.upc.experimentos.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "Horario")
public class Horario implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idHorario")
	private int idHorario;
	
	@NotEmpty(message = "Debe ingresar la descripcion del horario")
	@Column(name = "descripcionHorario", length = 50, nullable = false)	
	private String descripcionHorario;
	
	@OneToMany(mappedBy = "horario", cascade = CascadeType.ALL)
	private List<Cancha> Canchas;

	
	
	
	public Horario() {
		Canchas = new ArrayList<Cancha>();
	}

	public int getIdHorario() {
		return idHorario;
	}

	public void setIdHorario(int idHorario) {
		this.idHorario = idHorario;
	}

	public String getDescripcionHorario() {
		return descripcionHorario;
	}

	public void setDescripcionHorario(String descripcionHorario) {
		this.descripcionHorario = descripcionHorario;
	}

	public List<Cancha> getCanchas() {
		return Canchas;
	}

	public void setCanchas(List<Cancha> canchas) {
		Canchas = canchas;
	}

	
}
