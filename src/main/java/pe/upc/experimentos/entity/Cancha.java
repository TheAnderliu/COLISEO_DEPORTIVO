package pe.upc.experimentos.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Cancha")
public class Cancha implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idCancha")
	private int idCancha;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idDeporte")
	private Deporte deporte;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idLocal")
	private Local local;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idHorario")
	private Horario horario;
	
	@Column(name ="disponibilidad", nullable=false)
	private Boolean disponibilidad;

	@OneToMany(mappedBy = "cancha", cascade = CascadeType.ALL)
	private List<Reserva> Reservas;
	
	public Cancha() {
		this.disponibilidad = true;
		Reservas = new ArrayList<Reserva>();
	}

	public int getIdCancha() {
		return idCancha;
	}

	public void setIdCancha(int idCancha) {
		this.idCancha = idCancha;
	}

	public Deporte getDeporte() {
		return deporte;
	}

	public void setDeporte(Deporte deporte) {
		this.deporte = deporte;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	public Boolean getDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(Boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
	
	
	
}
