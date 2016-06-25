package com.sce.model.domain;

/**
 * Created by Andre on 28/05/2016.
 */
public enum TipoNFEnum {
    ENTRADA("E", "Entrada"),
    SAIDA("S", "Saída");

    private String codigo;
    private String descricao;

    TipoNFEnum(String codigo, String descricao) {
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

    public static TipoNFEnum getValue(String tipoBase) {
        TipoNFEnum[] values = TipoNFEnum.values();
        for (TipoNFEnum value : values) {
            if (value.getCodigo().equals(tipoBase)) {
                return value;
            }
        }
        return null;
    }
}
