package pe.upc.experimentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.upc.experimentos.entity.Cancha;


@Repository
public interface ICanchaRepository extends JpaRepository<Cancha, Integer>{

	@Query("select count(e.idCancha) from Cancha e where e.idCancha=:idCancha")
	public int searchIdCanchaCancha(@Param("idCancha")int idCancha);
	
	@Query("select e from Cancha e where e.idCancha = :idCancha")
	public Cancha findByIdCanchaCancha(@Param("idCancha")int idCancha);
	
	@Query("SELECT COUNT(c.idCancha) FROM Cancha c JOIN c.deporte d JOIN c.local l JOIN c.horario h WHERE d.idDeporte=:idDeporte AND l.idLocal=:idLocal AND h.idHorario=:idHorario")
	public int searchIdDeporteLocalHorarioCancha(@Param("idDeporte")int idDeporte, @Param("idLocal")int idLocal, @Param("idHorario")int idHorario);
	
}
