package co.udea.api.administrador.repository;

import co.udea.api.model.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepositoryEquipo extends JpaRepository<Equipo, Integer> {

   // List<Equipo> findByNameContaining(String nombre_equipo);
}
