package br.com.renato.restaurante.dao;

import br.com.renato.restaurante.entity.Cardapio;
import br.com.renato.restaurante.entity.Categoria;

import javax.persistence.EntityManager;
import java.util.List;

public class CategoriaDao {

    private EntityManager entityManager;

    public CategoriaDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void cadastrar(Categoria categoria){
        this.entityManager.persist(categoria);
    }

    public Cardapio consultarPorID(final Integer id){
        return this.entityManager.find(Cardapio.class,id);
    }

    public List<Categoria> consultarTodos(){
        String jpql = "SELECT c FROM Categoria c";
        return this.entityManager.createQuery(jpql, Categoria.class).getResultList();
    }

    public void atualizar(Categoria categoria){
        this.entityManager.merge(categoria);
    }

    public void excluir(Categoria categoria){
        this.entityManager.remove(categoria);
    }
}
