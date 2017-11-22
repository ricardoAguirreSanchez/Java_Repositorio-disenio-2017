package com.utn.services.implementation;

import com.utn.model.Usuario;
import com.utn.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by nicolaslamas on 11/10/17.
 */
@Service
public class UsuarioServiceImplementation implements UsuarioService {
    private final UsuarioDAO usuarioDAO;

    @Autowired
    public UsuarioServiceImplementation(UsuarioDAO userDAO) {
        this.usuarioDAO = userDAO;
    }

    @Override
    public List<Usuario> getUsuarios() {
        return usuarioDAO.getUsuarios();
    }

    @Override
    public Usuario getUsuario(String mail, String password) {

        return usuarioDAO.getUsuario(mail, password);
    }
}

