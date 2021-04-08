package pe.upc.experimentos.serviceimpl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.upc.experimentos.entity.Deporte;
import pe.upc.experimentos.repository.IDeporteRepository;
import pe.upc.experimentos.service.IDeporteService;

@Service
public class DeporteService implements IDeporteService, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private IDeporteRepository deporteRepository;
	
	@Transactional
	@Override
	public Integer save(Deporte Deporte) {
		int rpta = deporteRepository.searchNombreDeporteDeporte(Deporte.getNombreDeporte());
		if (rpta==0) {
			deporteRepository.save(Deporte);
		}
		
		return rpta;
	}

	@Transactional
	@Override
	public void update(Deporte Deporte) {
		// TODO Auto-generated method stub
		deporteRepository.save(Deporte);
	}

	@Transactional
	@Override
	public void delete(Integer idDeporte) {
		// TODO Auto-generated method stub
		deporteRepository.deleteById(idDeporte);
	}

	@Override
	public Deporte findByIdDeporte(int idDeporte) {
		// TODO Auto-generated method stub
		return deporteRepository.findByIdDeporteDeporte(idDeporte);
	}

	@Override
	public List<Deporte> findAll() {
		// TODO Auto-generated method stub
		return deporteRepository.findAll();
	}

}
