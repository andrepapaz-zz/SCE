package com.sce.model.domain;

/**
 * Created by Andre on 27/05/2016.
 */
public enum TipoEmpresaEnum {
    FORNECEDOR("F", "Fornecedor"),
    CLIENTE("C", "Cliente");

    private String codigo;
    private String descricao;

    TipoEmpresaEnum(String codigo, String descricao) {
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

    public static TipoEmpresaEnum getValue(String tipoBase) {
        TipoEmpresaEnum[] values = TipoEmpresaEnum.values();
        for (TipoEmpresaEnum value : values) {
            if (value.getCodigo().equals(tipoBase)) {
                return value;
            }
        }
        return null;
    }
}
