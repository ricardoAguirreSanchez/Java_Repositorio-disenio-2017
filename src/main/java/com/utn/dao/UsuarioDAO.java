package com.utn.dao;

import com.utn.model.Usuario;
import com.utn.repositorio.Repositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by nicolaslamas on 11/10/17.
 */
@Component
public class UsuarioDAO {

    private Repositorio repositorio;

    @Autowired
    public UsuarioDAO(Repositorio repositorio){
        this.repositorio = repositorio;
    }

    public List<Usuario> getUsuarios()  {
        return repositorio.usuarios().getUsuarios();
    }

    public Usuario getUsuario(String mail, String password) {
        return repositorio.usuarios().buscarPorMailYPassword(mail, password);
    }
}
