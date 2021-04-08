package pe.upc.experimentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.upc.experimentos.entity.Horario;

@Repository
public interface IHorarioRepository extends JpaRepository<Horario, Integer>{

	@Query("select count(e.idHorario) from Horario e where e.idHorario=:idHorario")
	public int searchIdHorarioHorario(@Param("idHorario")int idHorario);
	
	@Query("select e from Horario e where e.idHorario = :idHorario")
	public Horario findByIdHorarioHorario(@Param("idHorario")int idHorario);
	
}
