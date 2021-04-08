package pe.upc.experimentos.serviceimpl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.upc.experimentos.entity.Local;
import pe.upc.experimentos.repository.ILocalRepository;
import pe.upc.experimentos.service.ILocalService;

@Service
public class LocalService implements ILocalService, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private ILocalRepository localRepository;
	
	@Transactional
	@Override
	public Integer save(Local Local) {
		int rpta = localRepository.searchIdLocalLocal(Local.getIdLocal());
		if (rpta==0) {
			localRepository.save(Local);
		}
		
		return rpta;
	}

	@Transactional
	@Override
	public void update(Local Local) {
		// TODO Auto-generated method stub
		localRepository.save(Local);
	}

	@Transactional
	@Override
	public void delete(Local Local) {
		// TODO Auto-generated method stub
		localRepository.delete(Local);
	}

	@Override
	public Local findByIdJugador(int idLocal) {
		// TODO Auto-generated method stub
		return localRepository.findByIdLocalLocal(idLocal);
	}

	@Override
	public List<Local> findAll() {
		// TODO Auto-generated method stub
		return localRepository.findAll();
	}

}
