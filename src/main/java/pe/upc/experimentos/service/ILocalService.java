package pe.upc.experimentos.service;

import java.util.List;

import pe.upc.experimentos.entity.Local;

public interface ILocalService {

	public Integer save(Local Local);
	
	public void update(Local Local);
	
	public void delete(Local Local);
	
	public Local findByIdJugador(int idLocal);
	
	public List<Local> findAll();
}
