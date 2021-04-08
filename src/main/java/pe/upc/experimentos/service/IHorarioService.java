package pe.upc.experimentos.service;

import java.util.List;

import pe.upc.experimentos.entity.Horario;

public interface IHorarioService {

	public Integer save(Horario Horario);
	
	public void update(Horario Horario);
	
	public void delete(Horario Horario);
	
	public Horario findByIdHorario(int idHorario);
	
	public List<Horario> findAll();
}
