package com.sce.model.domain;

import com.sce.model.wrapper.TipoEmpresaWrapper;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.List;


/**
 * Created by Andre on 27/05/2016.
 */
@XmlRootElement
@Entity
@Table(
        uniqueConstraints = @UniqueConstraint(columnNames = {"nome", "tipo"})
)
public class Empresa implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer codigo;

    @Column(nullable = false)
    private String nome;

    @Column(name = "tipo", nullable = false)
    private String tipoBase;

    @OneToMany(mappedBy = "empresa")
    private List<NotaFiscal> notaFiscais;

    @Transient
    private TipoEmpresaWrapper tipo;

    public Empresa() {
    }

    public Empresa(Integer codigo, String nome, String tipoBase) {
        this.codigo = codigo;
        this.nome = nome;
        this.tipoBase = tipoBase;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlTransient
    public String getTipoBase() {
        return tipoBase;
    }

    public void setTipoBase(String tipoBase) {
        this.tipoBase = tipoBase;
    }

    public TipoEmpresaWrapper getTipo() {
        return tipo;
    }

    public void setTipo(TipoEmpresaWrapper tipo) {
        this.setTipoBase(tipo.getCodigo());
        this.tipo = tipo;
    }

    @XmlTransient
    public List<NotaFiscal> getNotaFiscais() {
        return notaFiscais;
    }

    public void setNotaFiscais(List<NotaFiscal> notaFiscais) {
        this.notaFiscais = notaFiscais;
    }

    @PostLoad
    public void setTipoLoad() {
        TipoEmpresaEnum tipoEmpresaEnum = TipoEmpresaEnum.getValue(tipoBase);
        this.tipo = new TipoEmpresaWrapper(tipoEmpresaEnum.getCodigo(), tipoEmpresaEnum.getDescricao());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Empresa empresa = (Empresa) o;

        return codigo.equals(empresa.codigo);

    }

    @Override
    public int hashCode() {
        return codigo.hashCode();
    }
}
