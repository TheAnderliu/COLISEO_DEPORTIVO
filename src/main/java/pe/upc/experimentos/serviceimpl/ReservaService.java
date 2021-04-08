package pe.upc.experimentos.serviceimpl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.upc.experimentos.entity.Cancha;
import pe.upc.experimentos.entity.Reserva;
import pe.upc.experimentos.repository.ICanchaRepository;
import pe.upc.experimentos.repository.IReservaRepository;
import pe.upc.experimentos.service.IReservaService;

@Service
public class ReservaService implements IReservaService, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private IReservaRepository reservaRepository;
	
	@Autowired
	private ICanchaRepository canchaRepository;
	
	
	@Transactional
	@Override
	public Integer save(Reserva Reserva) {
		int rpta = reservaRepository.searchIdCanchaFechaReserva(Reserva.getCancha().getIdCancha(), Reserva.getFechaReserva());
		if (rpta==0) {
			
			reservaRepository.save(Reserva);
			
			//Cambia el estado a "No Disponible" de la cancha de la reserva
			
			Cancha cancha = canchaRepository.findByIdCanchaCancha(Reserva.getCancha().getIdCancha());
			
			
			
			cancha.setDisponibilidad(false);
			
			canchaRepository.save(cancha);
			
		}
		
		return rpta;
	}

	@Transactional
	@Override
	public Integer update(Reserva Reserva) {
		
		int rpta = reservaRepository.searchIdCanchaFechaReserva(Reserva.getCancha().getIdCancha(), Reserva.getFechaReserva());
		if (rpta==0) {
			
			reservaRepository.save(Reserva);
			
			//Cambia el estado a "No Disponible" de la cancha de la reserva
			
			Cancha cancha = canchaRepository.findByIdCanchaCancha(Reserva.getCancha().getIdCancha());
			
			
			
			cancha.setDisponibilidad(false);
			
			canchaRepository.save(cancha);
			
		}
		
		return rpta;
	}

	@Transactional
	@Override
	public void delete(Integer idReserva) {
		
		
		
		
		
		//Cambia el estado a "Disponible" de la cancha de la reserva cancelada
		
		Reserva reservaEncontrada = reservaRepository.findByIdReservaReserva(idReserva);
		
		Cancha cancha = canchaRepository.findByIdCanchaCancha(reservaEncontrada.getCancha().getIdCancha());
		
		cancha.setDisponibilidad(true);
		
		canchaRepository.save(cancha);
		
		reservaRepository.deleteById(idReserva);
	}

	@Override
	public Reserva findByIdReserva(int idReserva) {
		// TODO Auto-generated method stub
		return reservaRepository.findByIdReservaReserva(idReserva);
	}

	@Override
	public List<Reserva> findAll() {
		// TODO Auto-generated method stub
		return reservaRepository.findAll();
	}


}
