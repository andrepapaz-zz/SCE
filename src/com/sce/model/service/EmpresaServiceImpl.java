package com.sce.model.service;

import com.sce.model.dao.EmpresaDao;
import com.sce.model.domain.Empresa;
import com.sce.model.exceptions.SCEApplicationException;

import javax.inject.Inject;
import javax.persistence.PersistenceException;
import java.util.List;

/**
 * Created by Andre on 27/05/2016.
 */
public class EmpresaServiceImpl implements EmpresaService {

    @Inject
    private EmpresaDao empresaDao;

    @Override
    public List<Empresa> getEmpresas() {
        return empresaDao.getEmpresas();
    }

    @Override
    public Empresa inserir(Empresa empresa) {
        try {
            return empresaDao.inserir(empresa);
        } catch (PersistenceException e) {
            throw new SCEApplicationException("Empresa já existe. Favor digite outro Nome");
        }
    }

    @Override
    public void alterar(Empresa empresa) {
        try {
            empresaDao.alterar(empresa);
        } catch (Exception e) {
            throw new SCEApplicationException("Empresa já existe. Favor digite outro Nome");
        }
    }

    @Override
    public void excluir(Empresa empresa) {
        try {
            empresaDao.excluir(empresa);
        } catch (Exception e) {
            throw new SCEApplicationException("Empresa possúi relacionamento, não é possível excluí-la");
        }
    }
}
