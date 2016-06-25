package com.sce.model.dao;

import com.sce.model.domain.ItensNotaFiscal;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Andre on 05/06/2016.
 */
public class ItensNotaFiscalDaoImpl implements ItensNotaFiscalDao {

    @PersistenceContext(unitName = "SCEPU")
    private EntityManager entityManager;

    @Override
    public List<ItensNotaFiscal> getItensNotaFiscal(){
        Query query = entityManager.createQuery("from ItensNotaFiscal");
        return query.getResultList();
    }
}
