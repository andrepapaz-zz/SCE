package com.sce.model.dao;

import com.sce.model.domain.ItensNotaFiscal;
import com.sce.model.domain.NotaFiscal;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andre on 29/05/2016.
 */
public class NotaFiscalDaoImpl implements NotaFiscalDao {

    @PersistenceContext(unitName = "SCEPU")
    private EntityManager entityManager;

    @Override
    @SuppressWarnings("unchecked")
    public List<NotaFiscal> getNotaFiscais() {
        Query query = entityManager.createQuery("from NotaFiscal");
        return query.getResultList();
    }

    @Override
    public List<NotaFiscal> getNotasFiscaisEntrada() {
        Query query = entityManager.createQuery("from NotaFiscal n where n.tipoBase = :tipo");
        query.setParameter("tipo", "E");
        return query.getResultList();
    }

    @Override
    public List<NotaFiscal> getNotasFiscaisSaida() {
        Query query = entityManager.createQuery("from NotaFiscal n where n.tipoBase = :tipo");
        query.setParameter("tipo", "S");
        return query.getResultList();
    }

    @Override
    @Transactional
    public NotaFiscal inserir(NotaFiscal notaFiscal) {
        entityManager.persist(notaFiscal);
        return notaFiscal;
    }

    @Override
    @Transactional
    public void alterar(NotaFiscal notaFiscal) {
        notaFiscal.setPrePersist();
        NotaFiscal notaFiscalMerge = entityManager.merge(notaFiscal);
        entityManager.persist(notaFiscalMerge);

    }

    @Override
    @Transactional
    public void excluir(NotaFiscal notaFiscal) {
        NotaFiscal notaFiscalMerge = entityManager.merge(notaFiscal);
        entityManager.remove(notaFiscalMerge);
    }
}
