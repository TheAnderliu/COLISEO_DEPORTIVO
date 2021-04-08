package pe.upc.experimentos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import pe.upc.experimentos.entity.Equipo;
import pe.upc.experimentos.entity.Jugador;

@Repository
public interface IEquipoRepository extends JpaRepository<Equipo, Integer>{

	@Query("select count(e.idEquipo) from Equipo e where e.idEquipo=:idEquipo")
	public int searchIdEquipoEquipo(@Param("idEquipo")int idEquipo);
	
	@Query("select e from Equipo e where e.idEquipo = :idEquipo")
	public Equipo findByIdEquipoEquipo(@Param("idEquipo")int idEquipo);
	
	@Query("select count(e.nombreEquipo) from Equipo e where e.nombreEquipo=:nombreEquipo")
	public int searchNombreEquipoEquipo(@Param("nombreEquipo")String nombreEquipo);
	
	@Query("select e from Equipo e where e.nombreEquipo = :nombreEquipo")
	public Equipo findByNombreEquipoEquipo(@Param("nombreEquipo")String nombreEquipo);
	
	@Query("select e from Jugador e where e.equipo = :Equipo")
	List<Jugador> ListaDeJugadores(@Param("Equipo")Equipo Equipo);
	
}
