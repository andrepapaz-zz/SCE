package com.sce.model.service;

import com.sce.model.domain.Usuario;

import java.util.List;

/**
 * Created by Andre on 12/06/2016.
 */
public interface UsuarioService {
    List<Usuario> getUsuarios();

    Usuario inserir(Usuario usuario);

    void alterar(Usuario usuario);

    void excluir(Usuario usuario);

    Usuario find(String username, String password);
}
