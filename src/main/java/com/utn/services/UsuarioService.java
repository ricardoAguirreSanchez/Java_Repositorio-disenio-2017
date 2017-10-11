package com.utn.services;

import com.utn.model.Usuario;

import java.util.List;

/**
 * Created by nicolaslamas on 11/10/17.
 */
public interface UsuarioService {

    public List<Usuario> getUsuarios();

    public Usuario getUsuario(String mail, String password);
}
