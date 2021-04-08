package pe.upc.experimentos.serviceimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.upc.experimentos.entity.Cancha;
import pe.upc.experimentos.repository.ICanchaRepository;
import pe.upc.experimentos.service.ICanchaService;

@Service
public class CanchaService implements ICanchaService, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private ICanchaRepository canchaRepository;
	
	@Transactional
	@Override
	public Integer save(Cancha Cancha) {
		int rpta = canchaRepository.searchIdDeporteLocalHorarioCancha((Cancha.getDeporte()).getIdDeporte(), (Cancha.getLocal()).getIdLocal(), (Cancha.getHorario()).getIdHorario());
		if (rpta==0) {
			canchaRepository.save(Cancha);
		}
		
		return rpta;
	}

	@Transactional
	@Override
	public Integer update(Cancha Cancha) {
		// TODO Auto-generated method stub
		int rpta = canchaRepository.searchIdDeporteLocalHorarioCancha((Cancha.getDeporte()).getIdDeporte(), (Cancha.getLocal()).getIdLocal(), (Cancha.getHorario()).getIdHorario());
		if (rpta==0) {
			
			canchaRepository.save(Cancha);
		}
		
		return rpta;
	}

	@Transactional
	@Override
	public void delete(Integer idCancha) {
		// TODO Auto-generated method stub
		canchaRepository.deleteById(idCancha);
	}

	@Override
	public Cancha findByIdCancha(int idCancha) {
		// TODO Auto-generated method stub
		return canchaRepository.findByIdCanchaCancha(idCancha);
	}

	@Override
	public List<Cancha> findAll() {
		// TODO Auto-generated method stub
		return canchaRepository.findAll();
	}

	@Override
	public List<Cancha> encontrarCanchasDisponibles() {
		
		List<Cancha> listadoCanchas = canchaRepository.findAll();
		
		List<Cancha> listadoCanchasDisponibles = new ArrayList<Cancha>();
		
		if (listadoCanchas.isEmpty()==false) {
			
			for (Cancha cancha : listadoCanchas) {
				
				if (cancha.getDisponibilidad()==true) {
					
					listadoCanchasDisponibles.add(cancha);
				}
				
				
			}
			
			
		}
		
		return listadoCanchasDisponibles;
	}

	@Override
	public List<Cancha> encontrarCanchasNoDisponibles() {
		
		List<Cancha> listadoCanchas = canchaRepository.findAll();
		
		List<Cancha> listadoCanchasNoDisponibles = new ArrayList<Cancha>();
		
		if (listadoCanchas.isEmpty()==false) {
			
			for (Cancha cancha : listadoCanchas) {
				
				if (cancha.getDisponibilidad()==false) {
					
					listadoCanchasNoDisponibles.add(cancha);
				}
				
				
			}
			
			
		}
		
		return listadoCanchasNoDisponibles;
	}

}
