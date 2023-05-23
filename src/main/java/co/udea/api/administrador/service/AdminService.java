package co.udea.api.administrador.service;

import co.udea.api.administrador.exception.BusinessException;
import co.udea.api.administrador.model.Equipo;

import co.udea.api.administrador.repository.AdminRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AdminService {

    private final Logger log = LoggerFactory.getLogger(AdminService.class);

    private AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;

    }

    public List<Equipo> getEquipos() {
        List<Equipo> EquiposList = adminRepository.findAll();
        if (EquiposList.isEmpty()) {
            log.info("No se encuentran Equipos en la base de datos");
            throw new BusinessException("Los Equipos no existen. ");
        }
        return EquiposList;
    }


    public Equipo getEquipo(Integer id) {
        Optional<Equipo> optionalEquipo = adminRepository.findById(id);
        if (!optionalEquipo.isPresent()) {
            log.info("No se encuentra un Equipo con ID: " + id);
            throw new BusinessException("El Equipo no existe");
        }
        return optionalEquipo.get();
    }



    /*

    public List<Equipo> searchEquipos(String nombre_equipo) {
        List<Equipo> equipos = adminRepository.findByNameContaining(nombre_equipo);
        if (equipos.isEmpty()) {
            log.info("No se encuentra un Equipo con nombre :" + nombre_equipo);
            throw new BusinessException("No hay mensaje disponible para mostrar.");
        }
        return equipos;
    }
       */

    public Equipo updateEquipo(Equipo equipo) {

        int id = equipo.getId();
        Optional<Equipo> optionalEquipo = adminRepository.findById(id);


        if (!optionalEquipo.isPresent()) {
            log.info("No se encuentra un Equipo registrado con ID: " + id);
            throw new BusinessException("No hay mensaje disponible para mostrar.");
        }
        Equipo existingEquipo = optionalEquipo.get();
        existingEquipo.setNombre_equipo(equipo.getNombre_equipo());
        existingEquipo.setCategoria(equipo.getCategoria());
        existingEquipo.setCapitan(equipo.getCapitan());
        existingEquipo.setEntrenador(equipo.getEntrenador());


        log.info("Actualizando equipo: " + existingEquipo.toString());
        return adminRepository.save(existingEquipo);
    }

    public Equipo addEquipo(Equipo equipo) {
        log.info("Agregando equipo: " + equipo.toString());
        return adminRepository.save(equipo);
    }


    public void deleteEquipo(Integer id) {
        Optional<Equipo> optionalEquipo = adminRepository.findById(id);
        if (!optionalEquipo.isPresent()) {
            log.info("No se encuentra un Equipo con ID:" + id);
            throw new BusinessException("No hay mensaje disponible para mostrar.");
        }
        adminRepository.delete(optionalEquipo.get());
    }


}
