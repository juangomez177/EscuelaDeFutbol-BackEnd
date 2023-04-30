package co.udea.api.administrador.repository;


import co.udea.api.administrador.model.Admon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdmonRepository extends JpaRepository<Admon, Integer> {


}
