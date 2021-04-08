package pe.upc.experimentos.service;

import java.util.List;

import pe.upc.experimentos.entity.Cancha;

public interface ICanchaService {

	public Integer save(Cancha Cancha);
	
	public Integer update(Cancha Cancha);
	
	public void delete(Integer idCancha);
	
	public Cancha findByIdCancha(int idCancha);
	
	public List<Cancha> findAll();
	
	public List<Cancha> encontrarCanchasDisponibles();
	
	public List<Cancha> encontrarCanchasNoDisponibles();
}
