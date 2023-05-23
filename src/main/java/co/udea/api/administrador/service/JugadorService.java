package co.udea.api.administrador.service;

import co.udea.api.administrador.exception.BusinessException;
import co.udea.api.administrador.model.Admon;
import co.udea.api.administrador.model.Jugador;
import co.udea.api.administrador.repository.JugadorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class JugadorService {

    private final Logger log = LoggerFactory.getLogger(JugadorService.class);

    private JugadorRepository jugadorRepository;

    public JugadorService(JugadorRepository jugadorRepository) {
        this.jugadorRepository = jugadorRepository;

    }

    public Jugador getJugador(Integer id) {
        Optional<Jugador> optionalJugador;
        optionalJugador = jugadorRepository.findById(id);
        if (!optionalJugador.isPresent()) {
            log.info("No se encuentra un Jugador con ID: " + id);
            throw new BusinessException("El Jugador no existe");
        }
        return optionalJugador.get();
    }
    /*
    public List<Jugador> getJugadores() {
        List<Jugador> JugadoresList = jugadorRepository.findAll();
        if (JugadoresList.isEmpty()) {
            log.info("No se encuentran Jugadores en la base de datos");
            throw new BusinessException("Los Jugadores no existen. ");
        }
        return JugadoresList;
    }
    */

    /*
    public List<Jugador> searchJugadores(String nombre) {
        List<Jugador> jugadores = jugadoresRepository.findByNameContaining(nombre);
        if (jugadores.isEmpty()) {
            log.info("No se encuentra un Jugador con nombre :" + nombre);
            throw new BusinessException("No hay mensaje disponible para mostrar.");
        }
        return jugadores;

    }*/
/*
        public Jugador updateJugador (Jugador jugador){
            Optional<Jugador> optionalJugador = jugadorRepository.findById(jugador.getId());
            if (!optionalJugador.isPresent()) {
                log.info("No se encuentra un Jugador registrado con ID: " + Jugador.getId());
                throw new BusinessException("No hay mensaje disponible para mostrar.");
            }
            optionalJugador.get().setNombre(jugador.getNombre());
            return jugadorRepository.save(optionalJugador.get());
        }*/


    public Jugador addJugador(Jugador jugador){

        return jugadorRepository.save(jugador);
    }

/*
    public void deleteJugador(Integer id){
        Optional<Jugador> optionalJugador = jugadorRepository.findById(id);
        if(!optionalJugador.isPresent()){
            log.info("No se encuentra un Jugador con ID:"+id);
            throw new BusinessException("No hay mensaje disponible para mostrar.");
        }
        jugadorRepository.delete(optionalJugador.get());
    }*/











}
