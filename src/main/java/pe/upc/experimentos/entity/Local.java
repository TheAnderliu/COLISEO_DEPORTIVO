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
@Table(name = "Local")
public class Local implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idLocal")
	private int idLocal;
	
	@NotEmpty(message = "Debe ingresar el nombre del local")
	@Column(name = "nombreLocal", length = 50, nullable = false)
	
	private String nombreLocal;
	
	@OneToMany(mappedBy = "local", cascade = CascadeType.ALL)
	private List<Cancha> Canchas;

	
	
	public Local() {
		Canchas = new ArrayList<Cancha>();
	}

	public int getIdLocal() {
		return idLocal;
	}

	public void setIdLocal(int idLocal) {
		this.idLocal = idLocal;
	}

	public String getNombreLocal() {
		return nombreLocal;
	}

	public void setNombreLocal(String nombreLocal) {
		this.nombreLocal = nombreLocal;
	}

	public List<Cancha> getCanchas() {
		return Canchas;
	}

	public void setCanchas(List<Cancha> canchas) {
		Canchas = canchas;
	}
	
	
	
}
