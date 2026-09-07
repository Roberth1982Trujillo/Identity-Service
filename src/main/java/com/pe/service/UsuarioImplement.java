package com.pe.service;

import com.pe.model.Usuario;
import com.pe.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioImplement implements IUsuarioService{
    @Autowired
    IUsuarioRepository repoUsuario;

    @Autowired
    PasswordEncoder passwordEncoder;


    @Override
    public String createUsuario(Usuario usuario) {
        String encryptedPassword = passwordEncoder.encode(usuario.getPassword());
        usuario.setPassword(encryptedPassword);

        repoUsuario.save(usuario);

        return "Usuario creado";
    }
}
