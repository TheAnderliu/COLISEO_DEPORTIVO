package pe.upc.experimentos.service;

import java.util.List;

import pe.upc.experimentos.entity.Deporte;


public interface IDeporteService {

	public Integer save(Deporte Deporte);
	
	public void update(Deporte Deporte);
	
	public void delete(Integer idDeporte);
	
	public Deporte findByIdDeporte(int idDeporte);
	
	public List<Deporte> findAll();
	
}
