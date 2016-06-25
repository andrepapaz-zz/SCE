package com.sce.model.domain;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Andre on 22/05/2016.
 */
@XmlRootElement
@Entity
@Table
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer codigo;

    @Column(nullable = false, unique = true)
    private String descricao;

    @OneToMany(mappedBy = "produto")
    private List<ItensNotaFiscal> itens;

    public Produto() {
    }

    public Produto(Integer codigo, String descricao) {
        if (codigo == null || descricao == null) {
            throw new NullPointerException("Campo não pode ser nulo");
        }
        if (descricao.equals("")) {
            throw new IllegalArgumentException("Campo obrigatório");
        }
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        if (codigo == null) {
            throw new NullPointerException("Campo não pode ser nulo");
        }
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        if (descricao == null) {
            throw new NullPointerException("Campo não pode ser nulo");
        }
        if (descricao.equals("")) {
            throw new IllegalArgumentException("Campo obrigatório");
        }
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Produto produto = (Produto) o;

        return codigo.equals(produto.codigo);

    }

    @Override
    public int hashCode() {
        return codigo.hashCode();
    }
}
