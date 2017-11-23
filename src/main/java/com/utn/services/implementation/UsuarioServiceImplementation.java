package com.utn.services.implementation;

import com.utn.model.Usuario;
import com.utn.repositorio.Usuarios;
import com.utn.services.UsuarioService;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by nicolaslamas on 11/10/17.
 */
@Service
public class UsuarioServiceImplementation implements UsuarioService {
    private final Usuarios usuarios;

    @Autowired
    public UsuarioServiceImplementation(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public List<Usuario> getUsuarios() {
        return Lists.newArrayList(usuarios.findAll());
    }

    @Override
    public Usuario getUsuario(String mail, String password) {
        return  usuarios.findByMailAndPassword(mail, password).stream().findFirst().orElse(null);
    }
}

