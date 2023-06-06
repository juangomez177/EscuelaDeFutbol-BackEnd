package co.udea.api.administrador.controller;

import co.udea.api.model.Equipo;
import co.udea.api.administrador.service.AdminServiceEquipo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class AdminControllerEquipo {
    private final Logger log = LoggerFactory.getLogger(AdminControllerEquipo.class);

    private AdminServiceEquipo adminServiceEquipo;

    public AdminControllerEquipo(AdminServiceEquipo adminServiceEquipo) {
        this.adminServiceEquipo = adminServiceEquipo;
    }

    /***** SERVICIOS PARA EQUIPO *****/

    /**
     * GET: get Equipo for id from the server
     */
    @GetMapping("/equipo/{id}")
    @ApiOperation(value = "Busca  por su id", response = Equipo.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Equipo encontrado existosamente"),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<Equipo> getEquipo(@PathVariable Integer id) {
        log.info("Rest request buscar Equipo por id: " + id);
        return ResponseEntity.ok(adminServiceEquipo.getEquipo(id));
    }

    /**
     * GETALL: get all Equipo from the server
     */
    @GetMapping("/equipo")
    @ApiOperation(value = "Buscar todos los Equipos", response = Equipo.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Equipos encontrado exitosamente"),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<List<Equipo>> getEquipos() {
        log.info("Rest request buscar Equipos");
        return ResponseEntity.ok(adminServiceEquipo.getEquipos());
    }

    /*
    /** GET: get Equipo for name from the server
    @GetMapping("/equipo/buscar/{nombre_equipo}")
    @ApiOperation(value = "Equipos Encontrdaos",  response = Equipo.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Equipos encontrados exitosamente"),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<List<Equipo>> searchEquipos(@PathVariable String nombre_equipo){
        log.info("Rest request buscar Equipos");
        return ResponseEntity.ok(adminServiceEquipo.searchEquipos(nombre_equipo));
    }
    */

    /**
     * PUT: update the Equipo on the server
     */
    @PutMapping("/equipo")
    @ApiOperation(value = "Equipo actualizado", response = Equipo.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Equipo actualizado exitosamente"),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<Equipo> updateEquipo(@RequestBody Equipo equipo) {
        log.info("Rest request actualizar Equipo");
        return ResponseEntity.ok(adminServiceEquipo.updateEquipo(equipo));
    }

    /**
     * POST: add a new Equipo to the server
     */
    @PostMapping("/equipo")
    @ApiOperation(value = "Agregar Equipo", response = Equipo.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Equipo agregado exitosamente"),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<Equipo> addEquipo(@RequestBody Equipo equipo) {
        log.info("Rest request agregar Equipo");
        return ResponseEntity.ok(adminServiceEquipo.addEquipo(equipo));
    }

    /**
     * DELETE: delete the Equipo from the server
     */
    @DeleteMapping("/equipo/{id}")
    @ApiOperation(value = "Equipo eliminado", response = Equipo.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Equipo eliminado exitosamente"),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<Void> deleteEquipo(@PathVariable Integer id) {
        log.info("Rest request eliminar Equipo");
        adminServiceEquipo.deleteEquipo(id);
        return ResponseEntity.noContent().build();
    }
}
