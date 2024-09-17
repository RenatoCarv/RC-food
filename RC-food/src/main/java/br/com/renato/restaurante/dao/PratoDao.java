package br.com.renato.restaurante.dao;

import br.com.renato.restaurante.entity.Prato;

import javax.persistence.EntityManager;

public class PratoDao {

    private EntityManager entityManager;

    public PratoDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void cadastrar(final Prato prato){
        this.entityManager.persist(prato);
    }

    public Prato consultar(final Integer id){
        return this.entityManager.find(Prato.class,id);
    }

    public void atualizar(final Prato prato){
        this.entityManager.merge(prato);
    }

    public void excluir(final Prato prato){
        this.entityManager.remove(prato);
    }

}
