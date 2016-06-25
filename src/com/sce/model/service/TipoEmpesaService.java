package com.sce.model.service;

import com.sce.model.domain.TipoEmpresaEnum;
import com.sce.model.wrapper.TipoEmpresaWrapper;

import java.util.List;

/**
 * Created by Andre on 27/05/2016.
 */
public interface TipoEmpesaService {

    List<TipoEmpresaWrapper> getTipoEmpresas();

}
