package pe.upc.experimentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.upc.experimentos.entity.Deporte;


@Repository
public interface IDeporteRepository extends JpaRepository<Deporte, Integer>{

	@Query("select count(e.idDeporte) from Deporte e where e.idDeporte=:idDeporte")
	public int searchIdDeporteDeporte(@Param("idDeporte")int idDeporte);
	
	@Query("select e from Deporte e where e.idDeporte = :idDeporte")
	public Deporte findByIdDeporteDeporte(@Param("idDeporte")int idDeporte);
	
	@Query("select count(e.nombreDeporte) from Deporte e where e.nombreDeporte=:nombreDeporte")
	public int searchNombreDeporteDeporte(@Param("nombreDeporte")String nombreDeporte);
	
}
