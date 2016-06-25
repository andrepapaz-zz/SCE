package com.sce.model.service;

import com.sce.model.dao.UsuarioDao;
import com.sce.model.domain.Usuario;
import com.sce.model.exceptions.SCEApplicationException;

import javax.inject.Inject;
import javax.persistence.PersistenceException;
import java.util.List;

/**
 * Created by Andre on 12/06/2016.
 */
public class UsuarioServiceImpl implements UsuarioService {
    @Inject
    private UsuarioDao usuarioDao;

    @Override
    public List<Usuario> getUsuarios() {
        return usuarioDao.getUsuarios();
    }

    @Override
    public Usuario inserir(Usuario usuario) {
        try {
            return usuarioDao.inserir(usuario);
        } catch (PersistenceException e) {
            throw new SCEApplicationException("Usuario já existe. Favor digite outro Nome");
        }
    }

    @Override
    public void alterar(Usuario usuario) {
        try {
            usuarioDao.alterar(usuario);
        } catch (Exception e) {
            throw new SCEApplicationException("Usuario já existe. Favor digite outro Nome");
        }
    }

    @Override
    public void excluir(Usuario usuario) {
        try {
            usuarioDao.excluir(usuario);
        } catch (Exception e) {
            throw new SCEApplicationException("Usuario possúi relacionamento, não é possível excluí-lo");
        }
    }

    @Override
    public Usuario find(String username, String password) {
        return usuarioDao.find(username, password);
    }
}
