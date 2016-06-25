package com.sce.model.service;

import com.sce.model.dao.NotaFiscalDao;
import com.sce.model.domain.NotaFiscal;
import com.sce.model.exceptions.SCEApplicationException;

import javax.inject.Inject;
import javax.persistence.PersistenceException;
import java.util.List;

/**
 * Created by Andre on 29/05/2016.
 */
public class NotaFiscalServiceImpl implements NotaFiscalService {

    @Inject
    private NotaFiscalDao notaFiscalDao;

    @Override
    public List<NotaFiscal> getNotaFiscais() {
        return notaFiscalDao.getNotaFiscais();
    }

    @Override
    public List<NotaFiscal> getNotasFiscaisEntrada() {
        return notaFiscalDao.getNotasFiscaisEntrada();
    }

    @Override
    public List<NotaFiscal> getNotasFiscaisSaida() {
        return notaFiscalDao.getNotasFiscaisSaida();
    }

    @Override
    public NotaFiscal inserir(NotaFiscal notaFiscal) {
        try {
            return notaFiscalDao.inserir(notaFiscal);
        } catch (PersistenceException e) {
            throw new SCEApplicationException("Nota Fiscal já existe. Favor digite outro Número");
        }
    }

    @Override
    public void alterar(NotaFiscal notaFiscal) {
        try {
            notaFiscalDao.alterar(notaFiscal);
        } catch (Exception e) {
            throw new SCEApplicationException("Nota Fiscal já existe. Favor digite outro Número");
        }
    }

    @Override
    public void excluir(NotaFiscal notaFiscal) {
        try {
            notaFiscalDao.excluir(notaFiscal);
        } catch (Exception e) {
            throw new SCEApplicationException("Nota Fiscal possúi relacionamento, não é possível excluí-la");
        }
    }
}
