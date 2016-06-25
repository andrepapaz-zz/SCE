package com.sce.model.dao;

import com.sce.model.domain.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Andre on 12/06/2016.
 */
public class UsuarioDaoImpl implements UsuarioDao {

    @PersistenceContext(unitName = "SCEPU")
    private EntityManager entityManager;

    @Override
    @SuppressWarnings("unchecked")
    public List<Usuario> getUsuarios() {
        Query query = entityManager.createQuery("from Usuario");
        return query.getResultList();
    }

    @Override
    @Transactional
    public Usuario inserir(Usuario usuario) {
        entityManager.persist(usuario);
        return usuario;
    }

    @Override
    @Transactional
    public void alterar(Usuario usuario) {
        Usuario usuarioMerge = entityManager.merge(usuario);
        entityManager.persist(usuarioMerge);
    }

    @Override
    @Transactional
    public void excluir(Usuario usuario) {
        Usuario usuarioMerge = entityManager.merge(usuario);
        entityManager.remove(usuarioMerge);
    }

    @Override
    public Usuario find(String username, String password) {
        Query query = entityManager.createQuery("from Usuario u where u.nome = :nome and u.senha = :senha");
        query.setParameter("nome", username);
        query.setParameter("senha", password);
        return (Usuario) query.getSingleResult();
    }
}
