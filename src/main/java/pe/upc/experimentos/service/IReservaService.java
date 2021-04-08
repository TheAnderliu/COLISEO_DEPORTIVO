package pe.upc.experimentos.service;

import java.util.List;

import pe.upc.experimentos.entity.Reserva;

public interface IReservaService {

	public Integer save(Reserva Reserva);
	
	public Integer update(Reserva Reserva);
	
	public void delete(Integer idReserva);
	
	public Reserva findByIdReserva(int idReserva);
	
	public List<Reserva> findAll();
	
}
