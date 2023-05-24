package co.udea.api.administrador.controller;


import co.udea.api.administrador.model.Jugador;
import co.udea.api.administrador.service.JugadorService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jugador")
public class JugadorController {
    private final Logger log = LoggerFactory.getLogger(JugadorController.class);

    private JugadorService jugadorService;

    public JugadorController(JugadorService jugadorService) {
        this.jugadorService = jugadorService;
    }

    @GetMapping("{id}")
    @ApiOperation(value = "Busca  por su id", response = Jugador.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Jugador encontrado existosamente"),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<Jugador> getJugador(@PathVariable Integer id) {
        log.info("Rest request buscar Jugador por id: " + id);
        return ResponseEntity.ok(jugadorService.getJugador(id));
    }


    /*
    @GetMapping("")
    @ApiOperation(value = "Buscar todos los Jugadores",  response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Jugadores encontrado exitosamente"),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<List<Jugador>> getJugador(){
        log.info("Rest request buscar Jugadores");
        return ResponseEntity.ok(jugadorService.getJugadores());
    }*/

    /*

    @GetMapping("buscar/{nombre}")
    @ApiOperation(value = "Jugadores Encontrdaos",  response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Jugadores encontrados exitosamente"),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<List<Jugador>> searchJugadores(@PathVariable String nombre){
        log.info("Rest request buscar Jugadores");
        return ResponseEntity.ok(jugadorService.searchJugadores(nombre));
    }
    */


    /** PUT: update the Jugador on the server */
    /*
    @PutMapping()
    @ApiOperation(value = "Jugador actualizado",  response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Jugador actualizado exitosamente"),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<Jugador> updateJugador(@RequestBody Jugador jugador){
        log.info("Rest request actualizar Jugador");
        return ResponseEntity.ok(jugadorService.updateJugador(jugador));
    }*/

    /** POST: add a new Jugadorto the server */
    /*
    @PostMapping ()
    @ApiOperation(value = "Agregar Jugador",  response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Jugador agregado exitosamente"),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<Jugador> addJugador(@RequestBody Jugador jugador){
        log.info("Rest request agregar Jugador");
        return ResponseEntity.ok(jugadorService.addJugador(jugador));
    }*/

    /** DELETE: delete the Jugador from the server */

    /*
    @DeleteMapping("{id}")
    @ApiOperation(value = "Jugador eliminado",  response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Jugador eliminado exitosamente"),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public void deleteEquipo(@PathVariable Integer id){
        log.info("Rest request eliminar Jugador");
        jugadorService.deleteJugador(id);
    }

    */
}


