package com.sce.model.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Andre on 07/06/2016.
 */
public class ProdutoTest {
    private Produto produtoBefore;

    @Before
    public void before () {
        produtoBefore = new Produto();
    }

    @Test(expected = NullPointerException.class)
    public void testCodeNull() {
        Produto produto = new Produto(null, "Tesoura");
    }

    @Test(expected = NullPointerException.class)
    public void testDescriptionNull() {
        Produto produto = new Produto(1, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDescriptionEmpty() {
        Produto produto = new Produto(1, "");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetDescriptionEmpty() {
        produtoBefore.setDescricao("");
    }

    @Test(expected = NullPointerException.class)
    public void testSetDescriptionNull() {
        produtoBefore.setDescricao(null);
    }

    @Test(expected = NullPointerException.class)
    public void testSetCodigoNull() {
        produtoBefore.setCodigo(null);
    }
}