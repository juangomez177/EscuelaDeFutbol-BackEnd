package co.udea.api.administrador.repository;



import co.udea.api.administrador.model.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JugadorRepository extends JpaRepository<Jugador, Integer> {

   //List<Jugador> findByNameContaining(String nombre);
}
