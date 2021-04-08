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
@Table(name = "Equipo")
public class Equipo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idEquipo")
	private int idEquipo;
	
	@NotEmpty(message = "Debe ingresar el nombre del equipo")
	@Column(name = "nombreEquipo", length = 50, nullable = false)
	private String nombreEquipo;
	
	@OneToMany(mappedBy = "equipo", cascade = CascadeType.ALL)
	private List<Jugador> Jugadores;
	
	@OneToMany(mappedBy = "equipoA", cascade = CascadeType.ALL)
	private List<Reserva> ReservasA;	
	
	@OneToMany(mappedBy = "equipoB", cascade = CascadeType.ALL)
	private List<Reserva> ReservasB;

	
	
	public Equipo() {
		Jugadores = new ArrayList<Jugador>();
		ReservasA = new ArrayList<Reserva>();
		ReservasB = new ArrayList<Reserva>();
	}

	public int getIdEquipo() {
		return idEquipo;
	}

	public void setIdEquipo(int idEquipo) {
		this.idEquipo = idEquipo;
	}

	public String getNombreEquipo() {
		return nombreEquipo;
	}

	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}

	public List<Jugador> getJugadores() {
		return Jugadores;
	}

	public void setJugadores(List<Jugador> jugadores) {
		Jugadores = jugadores;
	}

	public List<Reserva> getReservasA() {
		return ReservasA;
	}

	public void setReservasA(List<Reserva> reservasA) {
		ReservasA = reservasA;
	}

	public List<Reserva> getReservasB() {
		return ReservasB;
	}

	public void setReservasB(List<Reserva> reservasB) {
		ReservasB = reservasB;
	}
	
	
}
