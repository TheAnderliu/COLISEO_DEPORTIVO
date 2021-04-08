package pe.upc.experimentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.upc.experimentos.entity.Jugador;


@Repository
public interface IJugadorRepository extends JpaRepository<Jugador, Integer>{

	@Query("select count(e.idJugador) from Jugador e where e.idJugador=:idJugador")
	public int searchIdJugadorJugador(@Param("idJugador")int idJugador);
	
	@Query("select e from Jugador e where e.idJugador = :idJugador")
	public Jugador findByIdJugadorJugador(@Param("idJugador")int idJugador);
	
	@Query("select count(e.dniJugador) from Jugador e where e.dniJugador = :dniJugador")
	public int searchDniJugadorJugador(@Param("dniJugador")String dniJugador);
	
	@Query("select e from Jugador e where e.dniJugador = : dniJugador")
	public Jugador findByDniJugadorJugador(@Param("dniJugador")String dniJugador);
	
	
}
