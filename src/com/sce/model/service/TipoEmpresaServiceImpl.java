package com.sce.model.service;

import com.sce.model.domain.TipoEmpresaEnum;
import com.sce.model.wrapper.TipoEmpresaWrapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andre on 27/05/2016.
 */
public class TipoEmpresaServiceImpl implements TipoEmpesaService{
    @Override
    public List<TipoEmpresaWrapper> getTipoEmpresas() {
        List<TipoEmpresaWrapper> tipoEmpresaWrappers = new ArrayList<TipoEmpresaWrapper>();
        TipoEmpresaEnum cliente = TipoEmpresaEnum.CLIENTE;
        tipoEmpresaWrappers.add(new TipoEmpresaWrapper(cliente.getCodigo(), cliente.getDescricao()));
        TipoEmpresaEnum fornecedor = TipoEmpresaEnum.FORNECEDOR;
        tipoEmpresaWrappers.add(new TipoEmpresaWrapper(fornecedor.getCodigo(), fornecedor.getDescricao()));
        return tipoEmpresaWrappers;
    }
}
