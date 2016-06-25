package com.sce.model.wrapper;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Andre on 27/05/2016.
 */
@XmlRootElement(name = "tipoEmpresa")
public class TipoEmpresaWrapper {
    private String codigo;
    private String descricao;

    public TipoEmpresaWrapper() {
    }

    public TipoEmpresaWrapper(String codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TipoEmpresaWrapper that = (TipoEmpresaWrapper) o;

        return codigo.equals(that.codigo);

    }

    @Override
    public int hashCode() {
        return codigo.hashCode();
    }
}
