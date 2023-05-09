package co.udea.api.administrador.service;

import co.udea.api.administrador.exception.BusinessException;
import co.udea.api.administrador.model.Admon;

import co.udea.api.administrador.repository.AdmonRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AdmonService {

    private final Logger log = LoggerFactory.getLogger(AdmonService.class);

    private AdmonRepository admonRepository;

    public AdmonService(AdmonRepository admonRepository) {
        this.admonRepository = admonRepository;

    }

    public Admon getAdmon(Integer id) {
        Optional<Admon> optionalAdmon = admonRepository.findById(id);
        if (!optionalAdmon.isPresent()) {
            log.info("No se encuentra un Equipo con ID: " + id);
            throw new BusinessException("El Equipo no existe");
        }
        return optionalAdmon.get();
    }

    public List<Admon> getEquipos() {
        List<Admon> EquiposList = admonRepository.findAll();
        if (EquiposList.isEmpty()) {
            log.info("No se encuentran Equipos en la base de datos");
            throw new BusinessException("Los Equipos no existen. ");
        }
        return EquiposList;
    }

    public List<Admon> searchEquipos(String nombre_equipo) {
        List<Admon> equipos = admonRepository.findByNameContaining(nombre_equipo);
        if (equipos.isEmpty()) {
            log.info("No se encuentra un Equipo con nombre :" + nombre_equipo);
            throw new BusinessException("No hay mensaje disponible para mostrar.");
        }
        return equipos;

    }

        public Admon updateEquipo (Admon admon){
            Optional<Admon> optionalAdmon = admonRepository.findById(admon.getId());
            if (!optionalAdmon.isPresent()) {
                log.info("No se encuentra un Equipo registrado con ID: " + admon.getId());
                throw new BusinessException("No hay mensaje disponible para mostrar.");
            }
            optionalAdmon.get().setNombre_equipo(admon.getNombre_equipo());
            return admonRepository.save(optionalAdmon.get());
        }


    public Admon addEquipo(Admon admon){

        return admonRepository.save(admon);
    }


    public void deleteEquipo(Integer id){
        Optional<Admon> optionalAdmon = admonRepository.findById(id);
        if(!optionalAdmon.isPresent()){
            log.info("No se encuentra un Equipo con ID:"+id);
            throw new BusinessException("No hay mensaje disponible para mostrar.");
        }
        admonRepository.delete(optionalAdmon.get());
    }











}
