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
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "Deporte")
public class Deporte implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idDeporte")
	private int idDeporte;
	
	@NotEmpty(message = "Debe ingresar el nombre del deporte")
	@Column(name = "nombreDeporte", length = 50, nullable = false)
	
	private String nombreDeporte;
	
	@OneToMany(mappedBy = "deporte", cascade = CascadeType.ALL)
	private List<Cancha> Canchas;

	
	
	public Deporte() {
		Canchas = new ArrayList<Cancha>();
		
	}

	public int getIdDeporte() {
		return idDeporte;
	}

	public void setIdDeporte(int idDeporte) {
		this.idDeporte = idDeporte;
	}

	public String getNombreDeporte() {
		return nombreDeporte;
	}

	public void setNombreDeporte(String nombreDeporte) {
		this.nombreDeporte = nombreDeporte;
	}

	public List<Cancha> getCanchas() {
		return Canchas;
	}

	public void setCanchas(List<Cancha> canchas) {
		Canchas = canchas;
	}
	
	
}
