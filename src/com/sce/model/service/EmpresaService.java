package com.sce.model.service;

import com.sce.model.domain.Empresa;

import java.util.List;

/**
 * Created by Andre on 27/05/2016.
 */
public interface EmpresaService {
    List<Empresa> getEmpresas();

    Empresa inserir(Empresa empresa);

    void alterar(Empresa empresa);

    void excluir(Empresa empresa);
}
