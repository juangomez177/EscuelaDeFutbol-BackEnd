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


}
