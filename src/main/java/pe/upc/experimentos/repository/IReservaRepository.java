package pe.upc.experimentos.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import pe.upc.experimentos.entity.Reserva;

@Repository
public interface IReservaRepository extends JpaRepository<Reserva, Integer>{

	@Query("select count(e.idReserva) from Reserva e where e.idReserva=:idReserva")
	public int searchIdReservaReserva(@Param("idReserva")int idReserva);
	
	@Query("select e from Reserva e where e.idReserva = :idReserva")
	public Reserva findByIdReservaReserva(@Param("idReserva")int idReserva);
	
	@Query("select count(r.idReserva) from Reserva r JOIN r.cancha c where c.idCancha=:idCancha AND r.fechaReserva=:fechaReserva AND r.estadoReserva=:estadoReserva")
	public int searchIdCanchaFechaReservaActualizar(@Param("idCancha")int idCancha, @Param("fechaReserva")Date fechaReserva, @Param("estadoReserva")Boolean estadoReserva);
	
	@Query("select count(r.idReserva) from Reserva r JOIN r.cancha c where c.idCancha=:idCancha AND r.fechaReserva=:fechaReserva")
	public int searchIdCanchaFechaReserva(@Param("idCancha")int idCancha, @Param("fechaReserva")Date fechaReserva);
	
	@Query("select r from Reserva r where r.estadoReserva=:estadoReserva")
	List<Reserva> ListaDeReservasPorEstado(@Param("estadoReserva")Boolean estadoReserva);
	
	
}
