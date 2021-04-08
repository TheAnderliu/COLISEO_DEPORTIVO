package pe.upc.experimentos.serviceimpl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.upc.experimentos.entity.Jugador;
import pe.upc.experimentos.repository.IJugadorRepository;
import pe.upc.experimentos.service.IJugadorService;

@Service
public class JugadorService implements IJugadorService, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private IJugadorRepository jugadorRepository;
	
	@Transactional
	@Override
	public Integer save(Jugador Jugador) {
		int rpta = jugadorRepository.searchDniJugadorJugador(Jugador.getDniJugador());
		if (rpta==0) {
			jugadorRepository.save(Jugador);
		}
		
		return rpta;
	}

	@Transactional
	@Override
	public void update(Jugador Jugador) {
		// TODO Auto-generated method stub
		jugadorRepository.save(Jugador);
	}

	@Transactional
	@Override
	public void delete(Integer idJugador) {
		// TODO Auto-generated method stub
		jugadorRepository.deleteById(idJugador);
	}

	@Override
	public Jugador findByIdJugador(int idJugador) {
		// TODO Auto-generated method stub
		return jugadorRepository.findByIdJugadorJugador(idJugador);
	}

	@Override
	public List<Jugador> findAll() {
		// TODO Auto-generated method stub
		return jugadorRepository.findAll();
	}

	@Override
	public Jugador findByDniJugadorJugador(String dniJugador) {
		// TODO Auto-generated method stub
		return jugadorRepository.findByDniJugadorJugador(dniJugador);
	}

}
