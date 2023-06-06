package co.udea.api.administrador.service;

import co.udea.api.administrador.repository.AdminRepositoryLogin;
import co.udea.api.model.Login;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceLogin {
    private static final Logger logger = LoggerFactory.getLogger(AdminServiceLogin.class);

    private final AdminRepositoryLogin adminRepositoryLogin;

    @Autowired
    public AdminServiceLogin(AdminRepositoryLogin adminRepositoryLogin) {
        this.adminRepositoryLogin = adminRepositoryLogin;
    }

    public String login(Login request) {
        String correo = request.getCorreo();
        String contraseña = request.getContraseña();

        Login usuario = adminRepositoryLogin.findByCorreo(correo, contraseña);
        logger.info("Usuario: {}", usuario);

        if (usuario != null) {
            return "Inicio de sesión exitoso";
        } else {
            throw new IllegalArgumentException("Credenciales inválidas");
        }
    }
}