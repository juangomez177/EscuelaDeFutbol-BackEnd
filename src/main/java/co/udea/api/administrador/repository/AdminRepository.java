package co.udea.api.administrador.repository;

import java.util.List;
import co.udea.api.administrador.model.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Equipo, Integer> {

   // List<Equipo> findByNameContaining(String nombre_equipo);
}
