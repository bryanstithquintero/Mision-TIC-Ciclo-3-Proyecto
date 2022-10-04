package misiontic.ciclo3.proyecto.subgrupo14.libreria.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import misiontic.ciclo3.proyecto.subgrupo14.libreria.controller.dto.LoginRequest;
import misiontic.ciclo3.proyecto.subgrupo14.libreria.service.SecurityService;

@AllArgsConstructor
@RestController
@RequestMapping("/api/login")
public class loginRestController {
    private final SecurityService securityService;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginRequest user) {
        try {
            var response = securityService.validateUser(user.getUsername(), user.getPassword());
            return ResponseEntity.ok(response);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(ex.getMessage());
        }
    }
}
