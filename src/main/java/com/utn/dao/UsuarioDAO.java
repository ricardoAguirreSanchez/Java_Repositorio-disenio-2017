package com.utn.dao;

import com.google.common.collect.Lists;
import com.utn.writer.CuentaValorWriter;
import com.utn.model.Usuario;
import com.utn.repositorio.Usuarios;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by nicolaslamas on 11/10/17.
 */
@Component
public class UsuarioDAO {

    private static final Logger log = LoggerFactory.getLogger(CuentaValorWriter.class);

    @Autowired
    private Usuarios usuarios;

    public List<Usuario> getUsuarios()  {
        return Lists.newArrayList(usuarios.findAll());
    }

    public Usuario getUsuario(String mail, String password) {
        return  usuarios.findByMailAndPassword(mail,password).stream().findFirst().get();
    }
}
