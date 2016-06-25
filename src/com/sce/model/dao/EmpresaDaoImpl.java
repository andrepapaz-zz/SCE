package com.sce.model.dao;

import com.sce.model.domain.Empresa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Andre on 27/05/2016.
 */
public class EmpresaDaoImpl implements EmpresaDao {

    @PersistenceContext(unitName = "SCEPU")
    private EntityManager entityManager;

    @Override
    public List<Empresa> getEmpresas(){
        Query query = entityManager.createQuery("from Empresa");
        return query.getResultList();
    }

    @Override
    @Transactional
    public Empresa inserir(Empresa empresa) {
        entityManager.persist(empresa);
        return empresa;
    }

    @Override
    @Transactional
    public void alterar(Empresa empresa) {
        Empresa empresaMerge = entityManager.merge(empresa);
        entityManager.persist(empresaMerge);
    }

    @Override
    @Transactional
    public void excluir(Empresa empresa) {
        Empresa empresaMerge = entityManager.merge(empresa);
        entityManager.remove(empresaMerge);
    }
}
