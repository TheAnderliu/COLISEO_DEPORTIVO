package pe.upc.experimentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import pe.upc.experimentos.entity.Local;

@Repository
public interface ILocalRepository extends JpaRepository<Local, Integer>{

	@Query("select count(e.idLocal) from Local e where e.idLocal=:idLocal")
	public int searchIdLocalLocal(@Param("idLocal")int idLocal);
	
	@Query("select e from Local e where e.idLocal = :idLocal")
	public Local findByIdLocalLocal(@Param("idLocal")int idLocal);
}
