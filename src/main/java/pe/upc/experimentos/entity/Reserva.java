package pe.upc.experimentos.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Reserva")
public class Reserva implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idJugador")
	private int idReserva;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idCancha")
	private Cancha cancha;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idEquipoA")
	private Equipo equipoA;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idEquipoB")
	private Equipo equipoB;
	
	//@Future(message="La fecha debe estar en futuro")
	@NotNull(message = "Debe ingresar fecha*")
	@Temporal(TemporalType.DATE)	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	//@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name ="fechaReserva", nullable=false)
	private Date fechaReserva;

	@Column(name ="estadoReserva", nullable=false)
	private Boolean estadoReserva; 
	
	
	public Reserva() {
		
		this.estadoReserva = true;
		
	}

	public int getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	public Cancha getCancha() {
		return cancha;
	}

	public void setCancha(Cancha cancha) {
		this.cancha = cancha;
	}

	public Equipo getEquipoA() {
		return equipoA;
	}

	public void setEquipoA(Equipo equipoA) {
		this.equipoA = equipoA;
	}

	public Equipo getEquipoB() {
		return equipoB;
	}

	public void setEquipoB(Equipo equipoB) {
		this.equipoB = equipoB;
	}

	public Date getFechaReserva() {
		return fechaReserva;
	}

	public void setFechaReserva(Date fechaReserva) {
		this.fechaReserva = fechaReserva;
	}

	
	public Boolean getEstadoReserva() {
		return estadoReserva;
	}

	public void setEstadoReserva(Boolean estadoReserva) {
		this.estadoReserva = estadoReserva;
	}

	
	
}
