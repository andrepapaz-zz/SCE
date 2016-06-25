package com.sce.model.service;

import com.sce.model.domain.TipoNFEnum;
import com.sce.model.wrapper.TipoNFWrapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andre on 28/05/2016.
 */
public class TipoNFServiceImpl implements TipoNFService {
    @Override
    public List<TipoNFWrapper> getTipoNF() {
        List<TipoNFWrapper> tipoNFWrappers = new ArrayList<TipoNFWrapper>();
        TipoNFEnum entrada = TipoNFEnum.ENTRADA;
        tipoNFWrappers.add(new TipoNFWrapper(entrada.getCodigo(), entrada.getDescricao()));
        TipoNFEnum saida = TipoNFEnum.SAIDA;
        tipoNFWrappers.add(new TipoNFWrapper(saida.getCodigo(), saida.getDescricao()));
        return tipoNFWrappers;
    }
}
