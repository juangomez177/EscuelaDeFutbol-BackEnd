
package co.udea.api.administrador.controller;

import co.udea.api.administrador.repository.AdminRepositoryLogin;
import co.udea.api.administrador.service.AdminServiceLogin;
import co.udea.api.model.Login;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
public class AdminControllerLogin {
    private static final Logger logger = LoggerFactory.getLogger(AdminControllerLogin.class);

    private final AdminServiceLogin adminServiceLogin;

    @Autowired
    public AdminControllerLogin(AdminServiceLogin adminServiceLogin) {
        this.adminServiceLogin = adminServiceLogin;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Login request) {
        try {
            String result = adminServiceLogin.login(request);
            return ResponseEntity.ok(result);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
        }
    }

}


