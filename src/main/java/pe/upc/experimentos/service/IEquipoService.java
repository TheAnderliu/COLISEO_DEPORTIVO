package pe.upc.experimentos.service;

import java.util.List;

import pe.upc.experimentos.entity.Equipo;

public interface IEquipoService {

public Integer save(Equipo Equipo);
	
	public void update(Equipo Equipo);
	
	public void delete(Integer idEquipo);
	
	public Equipo findByIdEquipo(int idEquipo);
	
	public List<Equipo> findAll();
	
}
