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
@RequestMapping("equipo")
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


}
