package co.udea.api.administrador.controller;


import co.udea.api.administrador.model.Admon;
import co.udea.api.administrador.service.AdmonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/equipo")
public class AdmonController {
    private final Logger log = LoggerFactory.getLogger(AdmonController.class);

    private AdmonService admonService;

    public AdmonController(AdmonService admonService){ this.admonService = admonService;}

    @GetMapping("{id}")
    @ApiOperation(value = "Busca  por su id",  response = Admon.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Equipo encontrado existosamente"),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<Admon> getAdmon(@PathVariable Integer id){
        log.info("Rest request buscar Equipo por id: "+ id);
        return ResponseEntity.ok(admonService.getAdmon(id));
    }

    @GetMapping("")
    @ApiOperation(value = "Buscar todos los Equipos",  response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Equipos encontrado exitosamente"),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<List<Admon>> getEquipos(){
        log.info("Rest request buscar Equipos");
        return ResponseEntity.ok(admonService.getAdmon());
    }

    @GetMapping("buscar/{name}")
    @ApiOperation(value = "Equipos Encontrdaos",  response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Equipos encontrados exitosamente"),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<List<Admon>> searchEquipos(@PathVariable String name){
        log.info("Rest request buscar Equipos");
        return ResponseEntity.ok(admonService.searchEquipos(name));
    }


    /** PUT: update the Equipo on the server */
    @PutMapping()
    @ApiOperation(value = "Equipo actualizado",  response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Equipo actualizado exitosamente"),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<Admon> updateEquipo(@RequestBody Admon admon){
        log.info("Rest request actualizar Equipo");
        return ResponseEntity.ok(admonService.updateEquipo(admon));
    }

    /** POST: add a new Equipo to the server */
    @PostMapping ()
    @ApiOperation(value = "Agregar Equipo",  response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Equipo agregado exitosamente"),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<Admon> addEquipo(@RequestBody Admon admon){
        log.info("Rest request agregar Equipo");
        return ResponseEntity.ok(admonService.addEquipo(admon));
    }

    /** DELETE: delete the Equipo from the server */
    @DeleteMapping("{id}")
    @ApiOperation(value = "Equipo eliminado",  response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Equipo eliminado exitosamente"),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public void deleteEquipo(@PathVariable Integer id){
        log.info("Rest request eliminar Equipo");
        (admonService.deleteEquipo(id);
    }




}
