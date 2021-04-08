package pe.upc.experimentos.serviceimpl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.upc.experimentos.entity.Equipo;
import pe.upc.experimentos.repository.IEquipoRepository;
import pe.upc.experimentos.service.IEquipoService;

@Service
public class EquipoService implements IEquipoService, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private IEquipoRepository equipoRepository;
	
	
	@Transactional
	@Override
	public Integer save(Equipo Equipo) {
		int rpta = equipoRepository.searchNombreEquipoEquipo(Equipo.getNombreEquipo());
		if (rpta==0) {
			equipoRepository.save(Equipo);
		}
		
		return rpta;
	}

	@Transactional
	@Override
	public void update(Equipo Equipo) {
		// TODO Auto-generated method stub
		equipoRepository.save(Equipo);
	}

	@Transactional
	@Override
	public void delete(Integer idEquipo) {
		// TODO Auto-generated method stub
		
		equipoRepository.deleteById(idEquipo);
	}

	@Override
	public Equipo findByIdEquipo(int idEquipo) {
		// TODO Auto-generated method stub
		return equipoRepository.findByIdEquipoEquipo(idEquipo);
	}

	@Override
	public List<Equipo> findAll() {
		// TODO Auto-generated method stub
		return equipoRepository.findAll();
	}

}
