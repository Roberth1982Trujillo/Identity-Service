package com.pe.controller;

import com.pe.model.Usuario;
import com.pe.model.UsuarioRequest;
import com.pe.service.IUsuarioService;
import com.pe.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
    @Autowired
    IUsuarioService servUsuario;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/createUsuario")
    public String crearUsuario(Usuario usuario){ return servUsuario.createUsuario(usuario); }

    @PostMapping("/token")
    public String getToken(@RequestBody UsuarioRequest usuarioRequest) { return jwtService.generateToken(usuarioRequest.getEmail()); }

}

