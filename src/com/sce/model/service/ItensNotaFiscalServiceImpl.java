package com.sce.model.service;

import com.sce.model.dao.ItensNotaFiscalDao;
import com.sce.model.domain.ItensNotaFiscal;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Andre on 05/06/2016.
 */
public class ItensNotaFiscalServiceImpl implements ItensNotaFiscalService {
    @Inject
    private ItensNotaFiscalDao itensNotaFiscalDao;

    @Override
    public List<ItensNotaFiscal> getItensNotaFiscal() {
        return itensNotaFiscalDao.getItensNotaFiscal();
    }

}
