package pe.upc.experimentos.serviceimpl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.upc.experimentos.entity.Horario;
import pe.upc.experimentos.repository.IHorarioRepository;
import pe.upc.experimentos.service.IHorarioService;

@Service
public class HorarioService implements IHorarioService, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private IHorarioRepository horarioRepository;
	
	@Transactional
	@Override
	public Integer save(Horario Horario) {
		int rpta = horarioRepository.searchIdHorarioHorario(Horario.getIdHorario());
		if (rpta==0) {
			horarioRepository.save(Horario);
		}
		
		return rpta;
	}

	@Transactional
	@Override
	public void update(Horario Horario) {
		// TODO Auto-generated method stub
		horarioRepository.save(Horario);
	}

	@Transactional
	@Override
	public void delete(Horario Horario) {
		// TODO Auto-generated method stub
		horarioRepository.delete(Horario);
	}

	@Override
	public Horario findByIdHorario(int idHorario) {
		// TODO Auto-generated method stub
		return horarioRepository.findByIdHorarioHorario(idHorario);
	}

	@Override
	public List<Horario> findAll() {
		// TODO Auto-generated method stub
		return horarioRepository.findAll();
	}

}
