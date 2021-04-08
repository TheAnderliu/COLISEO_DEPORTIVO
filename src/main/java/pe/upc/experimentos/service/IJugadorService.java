package pe.upc.experimentos.service;

import java.util.List;

import pe.upc.experimentos.entity.Jugador;

public interface IJugadorService {

	public Integer save(Jugador Jugador);
	
	public void update(Jugador Jugador);
	
	public void delete(Integer idJugador);
	
	public Jugador findByIdJugador(int idJugador);
	
	public List<Jugador> findAll();
	
	public Jugador findByDniJugadorJugador(String dniJugador);
}
