package pe.upc.experimentos.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
@Table(name = "Jugador")
public class Jugador implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idJugador")
	private int idJugador;
	
	
	@NotEmpty(message = "Debe ingresar nombre")
	@Column(name = "nombreJugador", length = 50, nullable = false)
	private String nombreJugador;
	
	@NotEmpty(message = "Debe ingresar primer apellido")
	@Column(name = "primerApellidoJugador", length = 50, nullable = false)
	private String primerApellidoJugador;
	
	@NotEmpty(message = "Debe ingresar segundo apellido")
	@Column(name = "segundoApellidoJugador", length = 50, nullable = false)	
	private String segundoApellidoJugador;
	
	@Size(min = 8, max = 8)
	@NotEmpty(message = "Debe ingresar DNI")
	@Column(name="dniJugador", nullable=false, length = 8)
	private String dniJugador;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idEquipo")
	private Equipo equipo;
	
	
	
	public Jugador() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public int getIdJugador() {
		return idJugador;
	}

	public void setIdJugador(int idJugador) {
		this.idJugador = idJugador;
	}

	public String getNombreJugador() {
		return nombreJugador;
	}

	public void setNombreJugador(String nombreJugador) {
		this.nombreJugador = nombreJugador;
	}

	public String getPrimerApellidoJugador() {
		return primerApellidoJugador;
	}

	public void setPrimerApellidoJugador(String primerApellidoJugador) {
		this.primerApellidoJugador = primerApellidoJugador;
	}

	public String getSegundoApellidoJugador() {
		return segundoApellidoJugador;
	}

	public void setSegundoApellidoJugador(String segundoApellidoJugador) {
		this.segundoApellidoJugador = segundoApellidoJugador;
	}

	public String getDniJugador() {
		return dniJugador;
	}

	public void setDniJugador(String dniJugador) {
		this.dniJugador = dniJugador;
	}
	
	

}
